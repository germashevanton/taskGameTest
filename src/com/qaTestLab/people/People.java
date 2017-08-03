package com.qaTestLab.people;


import com.qaTestLab.Army;


public class People extends Army{



    private Magician magician;
    private static Crossbowman[] crossbowmen;
    private Warrior[] warriors;

    int j = 0;

    public People(String name){
        super(name);

        magician = new Magician("People's magician", j);
        mapArmy.put(j++, magician);
        crossbowmen = new Crossbowman[3];
        for (int i = 0; i < crossbowmen.length; i++) {
            crossbowmen[i] = new Crossbowman("People's crossbowman #" + (i+1), j);
            mapArmy.put(j++, crossbowmen[i]);
        }
        warriors = new Warrior[4];
        for (int i = 0; i < warriors.length; i++) {
            warriors[i] = new Warrior("People's warrior #" + (i+1), j);
            mapArmy.put(j++, warriors[i]);
        }
        aliveHeroes = mapArmy.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
