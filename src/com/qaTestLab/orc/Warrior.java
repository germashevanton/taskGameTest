package com.qaTestLab.orc;

import com.qaTestLab.Entity;
import com.qaTestLab.Main;

import java.util.Random;


public class Warrior extends Entity {

    public Warrior(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {
        Main.outputPrintln(getName() + " has attacked by truncheon");
        return 20;
    }
}
