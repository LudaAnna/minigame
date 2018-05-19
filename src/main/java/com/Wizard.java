package com;

import java.util.HashMap;
import java.util.Map;

public class Wizard implements CharacterStatsInterface{
    Map<String, Integer> wizardStats = new HashMap<String, Integer>();
    int strong = 5;
    int defence = 4;
    int beauty = 7;
    int health = 1100;
    int money = 1200;

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
        this.health = 900;
        return health;
    }

    @Override
    public int getMoney(){
        this.money = 1200;
        return money;
    }

    public Map<String, Integer> getWizardStats(int luck){
        wizardStats.put("Strong", getStrong(luck));
        wizardStats.put("Beauty", getBeauty(luck));
        wizardStats.put("Defence", getDefence(luck));
        wizardStats.put("Luck", luck);
        wizardStats.put("Health", getHealth());
        wizardStats.put("Money", getMoney());
        return wizardStats;
    }
}
