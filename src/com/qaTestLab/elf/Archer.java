package com.qaTestLab.elf;


import com.qaTestLab.Entity;
import com.qaTestLab.Main;

import java.util.Random;

public class Archer extends Entity {
    public Archer(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {
        if (random.nextInt() == 0) {
            Main.outputPrintln(getName() + " shot from the bow");
            return 7;
        } else {
            Main.outputPrintln(getName() + " attack an enemy");
            return 3;
        }
    }
}
