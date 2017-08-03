package com.qaTestLab;


import java.util.HashMap;
import java.util.Map;



public class Army {


    protected String name;
    protected int[] aliveHeroes;

    public Map<Integer, Entity> mapArmy = new HashMap<>();

    public Army(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
