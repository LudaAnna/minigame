package com;

import java.util.HashMap;
import java.util.Map;

public class Human implements CharacterStatsInterface{
    Map<String, Integer> humanStats = new HashMap<String, Integer>();

    int strong = 5;
    int defence = 4;
    int beauty = 7;
    int health = 1000;
    int money = 1000;

    @Override
    public int getStrong(int luck) {
        this.strong = luck * 7;
        return strong;
    }

    @Override
    public int getBeauty(int luck) {
        this.beauty = luck * 6;
        return beauty;
    }

    @Override
    public int getDefence(int luck) {
        this.defence = luck * 4;
        return defence;
    }

    @Override
    public int getHealth(){
        this.health = 1000;
        return health;
    }

    @Override
    public int getMoney(){
        this.money = 1000;
        return money;
    }

    public Map<String, Integer> getHumanStats(int luck){
        humanStats.put("Strong", getStrong(luck));
        humanStats.put("Beauty", getBeauty(luck));
        humanStats.put("Defence", getDefence(luck));
        humanStats.put("Health", getHealth());
        humanStats.put("Luck", luck);
        humanStats.put("Money", getMoney());
        return humanStats;
    }

}
