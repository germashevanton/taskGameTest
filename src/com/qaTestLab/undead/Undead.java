package com.qaTestLab.undead;


import com.qaTestLab.Army;


public class Undead extends Army {

    private Necromancer necromancer;
    private static Hunter[] hunters;
    private Zombie[] zombies;

    int j = 0;

    public Undead(String name) {
        super(name);

        necromancer = new Necromancer("Undead's necromancer", j);
        mapArmy.put(j++, necromancer);
        hunters = new Hunter[3];
        for (int i = 0; i < hunters.length; i++) {
            hunters[i] = new Hunter("Undead's hunter #" + (i + 1), j);
            mapArmy.put(j++, hunters[i]);
        }
        zombies = new Zombie[4];
        for (int i = 0; i < zombies.length; i++) {
            zombies[i] = new Zombie("Undead's zombie #" + (i + 1), j);
            mapArmy.put(j++, zombies[i]);
        }
        aliveHeroes = mapArmy.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}

