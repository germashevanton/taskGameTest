package com.qaTestLab.elf;


import com.qaTestLab.Army;

public class Elf extends Army{
    private Magician magician;
    private static Archer[] archers;
    private Warrior[] warriors;

    int j = 0;

    public Elf(String name){
        super(name);


        magician = new Magician("Elf's magician", j);
        mapArmy.put(j++, magician);
        archers = new Archer[3];
        for (int i = 0; i < archers.length; i++) {
            archers[i] = new Archer("Elf's archer #" + (i+1), j);
            mapArmy.put(j++, archers[i]);
        }
        warriors = new Warrior[4];
        for (int i = 0; i < warriors.length; i++) {
            warriors[i] = new Warrior("Elf's warrior #" + (i+1), j);
            mapArmy.put(j++, warriors[i]);
        }
        aliveHeroes = mapArmy.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
