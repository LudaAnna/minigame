package com;

import java.util.HashMap;
import java.util.Map;

public class Alien implements CharacterStatsInterface{
    Map<String, Integer> alienStats = new HashMap<String, Integer>();
    int strong = 5;
    int defence = 4;
    int beauty = 7;
    int health = 1300;
    int money = 600;

    @Override
    public int getStrong(int luck) {
        this.strong = luck * 8;
        return strong;
    }

    @Override
    public int getBeauty(int luck) {
        this.beauty = luck * 2;
        return beauty;
    }

    @Override
    public int getDefence(int luck) {
        this.defence = luck * 2;
        return defence;
    }

    @Override
    public int getHealth(){
        this.health = 1300;
        return health;
    }

    @Override
    public int getMoney(){
        this.money = 600;
        return money;
    }

    public Map<String, Integer> getAlienStats(int luck){
        alienStats.put("Strong", getStrong(luck));
        alienStats.put("Beauty", getBeauty(luck));
        alienStats.put("Defence", getDefence(luck));
        alienStats.put("Luck", luck);
        alienStats.put("Health", getHealth());
        alienStats.put("Money", getMoney());
        return alienStats;
    }
}
