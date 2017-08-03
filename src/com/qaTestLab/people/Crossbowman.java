package com.qaTestLab.people;

import com.qaTestLab.Entity;
import com.qaTestLab.Main;

import java.util.Random;

public class Crossbowman extends Entity {


    public Crossbowman(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {
        if (random.nextInt() == 0){
            Main.outputPrintln(getName() + " shot from the crossbow");
            return 5;
        } else {
            Main.outputPrintln(getName() + " attack an enemy");
            return 3;
        }

    }


}
