package com.qaTestLab;

import java.util.Random;


public abstract class Entity {
    protected String name;
    protected int heroNumber;
    protected double liveLevel = 100;
    public Entity(String name, int heroNumber){
        this.name = name;
        this.heroNumber = heroNumber;
    }

    public String getName() {
        return name;
    }

    public int getHeroNumber() {
        return heroNumber;
    }

    public double getLiveLevel() {
        return liveLevel;
    }

    public boolean damage(double damageMagnitude){
        if (damageMagnitude < 0){
            return false;
        }
        liveLevel -= damageMagnitude;
        Main.outputPrintln(name + " live level after attack became " + liveLevel + " HP");
        if (liveLevel <= 0){
            Main.outputPrintln(name + " is killed");
            return true;
        }
        return false;
    }


    public abstract int attack(Random random);


}
