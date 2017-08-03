package com.qaTestLab.orc;




import com.qaTestLab.Entity;
import com.qaTestLab.Main;
import com.qaTestLab.Service;

import java.util.Random;

public class Voodoo extends Entity{

    public Voodoo(String name, int heroNumber) {
        super(name, heroNumber);
    }

    @Override
    public int attack(Random random) {

        if (random.nextInt(2) == 0) {
            Main.outputPrint(getName() + " has made improvements to ");
            return -1;
        } else {
            Main.outputPrintln(getName() + " prohibit improvements at the next step of the Enemy");
            return -2;
        }

    }
}
