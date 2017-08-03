package com.qaTestLab.orc;


import com.qaTestLab.Army;
import com.qaTestLab.Entity;

import java.util.HashMap;
import java.util.Map;

public class Orc extends Army{



    private Voodoo voodoo;
    private static Archer[] archers;
    private Warrior[] warriors;

    int j = 0;

    public Orc(String name){
        super(name);


        voodoo = new Voodoo("Orc's voodoo", j);
        mapArmy.put(j++, voodoo);
        archers = new Archer[3];
        for (int i = 0; i < archers.length; i++) {
            archers[i] = new Archer("Orc's archer #" + (i+1), j);
            mapArmy.put(j++, archers[i]);
        }
        warriors = new Warrior[4];
        for (int i = 0; i < warriors.length; i++) {
            warriors[i] = new Warrior("Orc's warrior #" + (i+1), j);
            mapArmy.put(j++, warriors[i]);
        }
        aliveHeroes = mapArmy.keySet().stream().mapToInt(Integer::intValue).toArray();
    }


}
