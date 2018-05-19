package com;

import java.util.HashMap;
import java.util.Map;

public class Giorgio implements CharacterStatsInterface{
    Map<String, Integer> giorgioStats = new HashMap<String, Integer>();
    int strong = 5;
    int defence = 4;
    int beauty = 7;
    int health = 900;
    int money = 1700;

    @Override
    public int getStrong(int luck) {
        this.strong = luck * 2;
        return strong;
    }

    @Override
    public int getBeauty(int luck) {
        this.beauty = luck * 10;
        return beauty;
    }

    @Override
    public int getDefence(int luck) {
        this.defence = luck * 6;
        return defence;
    }

    @Override
    public int getHealth(){
        this.health = 900;
        return health;
    }

    @Override
    public int getMoney(){
        this.money = 1700;
        return money;
    }

    public Map<String, Integer> getGiorgioStats(int luck){
        giorgioStats.put("Strong", getStrong(luck));
        giorgioStats.put("Beauty", getBeauty(luck));
        giorgioStats.put("Defence", getDefence(luck));
        giorgioStats.put("Luck", luck);
        giorgioStats.put("Health", getHealth());
        giorgioStats.put("Money", getMoney());
        return giorgioStats;
    }
}
