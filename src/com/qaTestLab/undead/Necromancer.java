package com.qaTestLab.undead;


import com.qaTestLab.Entity;
import com.qaTestLab.Main;

import java.util.Random;

public class Necromancer extends Entity{
    public Necromancer(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {
        if (random.nextInt(2) == 0) {
            Main.outputPrintln(getName() + " has reduced force of some Enemy at next attack");
            return -3;
        } else {
            Main.outputPrintln(getName() + " has attacked");
            return 5;
        }
    }
}
