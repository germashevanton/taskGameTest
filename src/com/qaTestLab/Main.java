package com.qaTestLab;

import com.qaTestLab.elf.Elf;
import com.qaTestLab.orc.Orc;
import com.qaTestLab.people.People;
import com.qaTestLab.undead.Undead;

import java.io.*;
import java.util.Random;


public class Main {

    // LogFile
    private static PrintWriter logfile;

    // write to the file and console using print
    public static void outputPrint(final String str) {
        System.out.print(str);
        logfile.print(str);
    }

    // write to the file and console using println
    public static void outputPrintln(final String str) {
        System.out.println(str);
        logfile.println(str);
    }


    public static void main(String[] args) throws IOException {

        People people = new People("People");
        Orc orc = new Orc("Orc");
        Undead undead = new Undead("Undead");
        Elf elf = new Elf("Elf");
        Random random = new Random();
        Service service = new Service();


        try {
            logfile = new PrintWriter(new FileWriter("LogFile.txt"));

            switch (random.nextInt(4)) {
                case 0:
                    service.battle(undead, people);
                    break;
                case 1:
                    service.battle(undead, elf);
                    break;
                case 2:
                    service.battle(orc, people);
                    break;
                case 3:
                    service.battle(orc, elf);
                    break;
            }
        } finally {
            if (logfile != null) {
                logfile.close();
            }
        }


    }
}
