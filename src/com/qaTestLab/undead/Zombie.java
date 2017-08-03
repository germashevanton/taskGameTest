package com.qaTestLab.undead;


import com.qaTestLab.Entity;
import com.qaTestLab.Main;

import java.util.Random;

public class Zombie extends Entity{
    public Zombie(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {
        Main.outputPrintln(getName() + " has attacked by spear");
        return 18;
    }
}
