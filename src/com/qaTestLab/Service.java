package com.qaTestLab;


import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Service {

    private Random random = new Random();
    private int actionNumber = 0;
    private String attackingSide;
    private boolean voodooBane = false;
    private boolean necromancerBane = false;


    private int actionAttackHero(Entity entityFighter, Army armyFighter, Army armyVictim, boolean privilege, boolean baneOfNecromancer) {
        actionNumber++;

        boolean isDead;

        if (armyVictim.aliveHeroes.length == 0) { // check if some Heroes is still alive
            printStatisticAfterGame(armyFighter, armyVictim);
            if (Main.logfile != null) {
                Main.logfile.close();
            }
            System.exit(0);
        }

        int keyOfVictim = armyVictim.aliveHeroes[random.nextInt(armyVictim.aliveHeroes.length)]; //define victim for attack
        Entity victim = armyVictim.mapArmy.get(keyOfVictim);
        Main.outputPrint("ACTION NUMBER " + actionNumber + ": " + entityFighter.getName() + " attack " + victim.getName() + "; ATTACK CONTENT: ");

        // magnitude of the damage of some Hero at attack
        int damageMagnitude = entityFighter.attack(random);

        // magician made improvements
        if (damageMagnitude == -1) {
            return defineCandidateForUpgradingSkills(armyFighter, armyVictim);
        }
        //check if prohibit improvements at next step by VoodooBane
        if (damageMagnitude == -2) {
            voodooBane = true;
        }

        //check if reduce force at next step by Necromancer
        if (damageMagnitude == -3) {
            necromancerBane = true;
        }

        // correct damage magnitude according to privilege status and different banes
        if (privilege && !voodooBane) { // taking into account possible Voodoo bane
            isDead = victim.damage(1.5 * damageMagnitude);
        } else if (privilege && voodooBane && (attackingSide.equals("People") || attackingSide.equals("Elf"))) { // taking into account possible Voodoo bane
            voodooBane = false;
            Main.outputPrintln("Skills improvements of " + entityFighter.getName() + " was canceled by Voodoo bane!");
            isDead = victim.damage(damageMagnitude);
        } else if (baneOfNecromancer) {
            isDead = victim.damage(damageMagnitude / 2);
            Main.outputPrintln("Force of " + entityFighter.getName() + " was reduced by Necromancer bane");
        } else {
            isDead = victim.damage(damageMagnitude);
        }

        // check if hero alive
        if (!isDead) {
            armyVictim.mapArmy.put(keyOfVictim, victim);
        } else {
            armyVictim.mapArmy.remove(keyOfVictim);
            armyVictim.aliveHeroes = armyVictim.mapArmy.keySet().stream().mapToInt(Integer::intValue).toArray();
        }

        // reduce force if Necromancer bane exists
        if (necromancerBane && (attackingSide.equals("People") || attackingSide.equals("Elf"))) {
            necromancerBane = false;
            return defineCandidateForReducingSkills(armyFighter, armyVictim);
        }

        return -1;
    }

    private void shuffleAliveHeroes(int[] aliveHeroes) {
        Random random = new Random();
        int index;
        int temp;
        for (int i = aliveHeroes.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = aliveHeroes[index];
            aliveHeroes[index] = aliveHeroes[i];
            aliveHeroes[i] = temp;
        }
    }


    private int defineCandidateForUpgradingSkills(Army armyFighter, Army armyVictim) { //if People or Orc magician improve skill
        int keyOfCandidate = armyFighter.aliveHeroes[random.nextInt(armyFighter.aliveHeroes.length)];

        Entity candidate = armyFighter.mapArmy.get(keyOfCandidate);
        Main.outputPrintln(candidate.getName());
        Main.outputPrintln("The next fighter from privilege group:");
        actionAttackHero(candidate, armyFighter, armyVictim, true, false);
        return keyOfCandidate;
    }

    private int defineCandidateForReducingSkills(Army armyFighter, Army armyVictim) { //if Necromancer made bane to People or Orc
        int keyOfCandidate = armyFighter.aliveHeroes[random.nextInt(armyFighter.aliveHeroes.length)];

        Entity candidate = armyFighter.mapArmy.get(keyOfCandidate);
        Main.outputPrintln("The next fighter has lower force due to Necromancer bane:");
        actionAttackHero(candidate, armyFighter, armyVictim, false, true);
        return keyOfCandidate;
    }

    private int startOfAttack(Army armyFighter, Army armyVictim, int keyOfFighter) {
        Entity candidate = armyFighter.mapArmy.get(keyOfFighter);
        return actionAttackHero(candidate, armyFighter, armyVictim, false, false); // return candidate with upgrading if such exists, which is important for the second fighter
    }


    private void attack(Army armyFighter, Army armyVictim) {
        int secondFighter = 0;
        if (armyFighter.mapArmy.containsKey(0)) { // fist step makes Magician if he alives
            secondFighter = startOfAttack(armyFighter, armyVictim, 0); //number of the fighter from privilege group
        }
        shuffleAliveHeroes(armyFighter.aliveHeroes);
        for (int aliveHero : armyFighter.aliveHeroes) {
            if (aliveHero == secondFighter || aliveHero == 0) { // second fighter and Magician have already made their attacks
                continue;
            }
            startOfAttack(armyFighter, armyVictim, aliveHero); // attack of other heroes
        }
    }

    public void battle(Army oneSide, Army anotherSide) {
        Main.outputPrintln("!!!" + oneSide.getName() + " fight against " + anotherSide.getName() + "!!!");
        int numberOfStep = 0;

        do {
            int whoesTern = random.nextInt(2);
            numberOfStep++;
            if (whoesTern == 0) {
                attackingSide = oneSide.getName();
                Main.outputPrintln(" ");
                Main.outputPrintln(attackingSide + " is attacking, step #" + numberOfStep + ":");

                attack(oneSide, anotherSide);
            } else {
                attackingSide = anotherSide.getName();
                Main.outputPrintln(" ");
                Main.outputPrintln(attackingSide + " is attacking, step #" + numberOfStep + ":");
                attack(anotherSide, oneSide);
            }
            Main.outputPrintln("-----------------------------------");
            Main.outputPrintln(oneSide.getName() + " have " + oneSide.mapArmy.size() + " alive heroes");
            Main.outputPrintln(anotherSide.getName() + " have " + anotherSide.mapArmy.size() + " alive heroes");
        } while (oneSide.mapArmy.size() != 0 && anotherSide.mapArmy.size() != 0);


        printStatisticAfterGame(oneSide, anotherSide);
    }

    private void printStatisticAfterGame(Army oneSide, Army anotherSide) {
        Main.outputPrintln(" ");
        Main.outputPrintln("!!! Game Over !!!");
        if (oneSide.mapArmy.size() != 0) {
            Main.outputPrintln("!!!" + oneSide.getName() + " are winners!!!");
            Main.outputPrintln("At winners army have left alive are:");
            Set<Map.Entry<Integer, Entity>> entries = oneSide.mapArmy.entrySet();
            for (Map.Entry<Integer, Entity> entry : entries) {
                Main.outputPrintln(entry.getValue().getName() + " with live level " + entry.getValue().getLiveLevel() + " HP");
            }
        } else {
            Main.outputPrintln("!!!" + anotherSide.getName() + " are winners!!!");
            Main.outputPrintln("At winners army have left alive are:");
            for (Map.Entry<Integer, Entity> entry : anotherSide.mapArmy.entrySet()) {
                Main.outputPrintln(entry.getValue().getName() + " with live level " + entry.getValue().getLiveLevel() + " HP");

            }
        }
    }


}
