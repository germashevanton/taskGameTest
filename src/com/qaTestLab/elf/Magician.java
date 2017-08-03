package com.qaTestLab.elf;


import com.qaTestLab.Entity;
import com.qaTestLab.Main;

import java.util.Random;

public class Magician extends Entity {


    public Magician(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {
        if (random.nextInt(2) == 0) {
            Main.outputPrint(getName() + " has made improvements to ");
            return -1;
        } else {
            Main.outputPrintln(getName() + " has made damage by magic");
            return 10;
        }
    }


}