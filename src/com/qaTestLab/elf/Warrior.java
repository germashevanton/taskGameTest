package com.qaTestLab.elf;


import com.qaTestLab.Entity;
import com.qaTestLab.Main;

import java.util.Random;

public class Warrior extends Entity {


    public Warrior(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {
        Main.outputPrintln(getName() + " has attacked by sword");
        return 15;
    }


}
