package com;

import java.util.HashMap;
import java.util.Map;

public class Goblin implements CharacterStatsInterface{
    Map<String, Integer> goblinStats = new HashMap<String, Integer>();
    int strong = 5;
    int defence = 4;
    int beauty = 7;
    int health = 1800;
    int money = 1300;

    @Override
    public int getStrong(int luck) {
        this.strong = luck * 4;
        return strong;
    }

    @Override
    public int getBeauty(int luck) {
        this.beauty = luck * 2;
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
        this.money = 1300;
        return money;
    }

    public Map<String, Integer> getGoblinStats(int luck){
        goblinStats.put("Strong", getStrong(luck));
        goblinStats.put("Beauty", getBeauty(luck));
        goblinStats.put("Defence", getDefence(luck));
        goblinStats.put("Luck", luck);
        goblinStats.put("Health", getHealth());
        goblinStats.put("Money", getMoney());
        return goblinStats;
    }
}
