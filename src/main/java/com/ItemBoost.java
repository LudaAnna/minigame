package com;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ItemBoost implements ItemsInterface{

    private Map<String, Integer> itemBoostMap = new HashMap<String, Integer>();
    private Map<Integer, String> itemTypeMap = new HashMap<Integer, String>();
    private int strongBoostValue;
    private int beautyBoostValue;
    private int defenceBoostValue;
    private int healthBoostValue;
    private int luck;

    @Override public int getStrongBoost() {
        return checkLuck();
    }

    @Override public int getBeautyBoost() {
        return checkLuck();
    }

    @Override public int getDefenceBoost() {
        return checkLuck();
    }

    @Override public int getHealthBoost() {
        return checkLuck();
    }

    @Override
    public int getPrice(){
        return (checkLuck() * 9);
    }

    @Override
    public String getType(){
        Random randomItem = new Random();
        itemTypeMap = typeMap();
        return itemTypeMap.get(randomItem.nextInt((5 - 1) + 1) + 1);
    }

    public Map<String, Integer> getItemBoost(){
        itemBoostMap.put("Strong", getStrongBoost());
        itemBoostMap.put("Beauty", getBeautyBoost());
        itemBoostMap.put("Defence", getDefenceBoost());
        itemBoostMap.put("Health", getHealthBoost());
        itemBoostMap.put("Price", getPrice());
        itemBoostMap.put(getType(), 0);
        return itemBoostMap;
    }
    public int checkLuck(){
        Random diceResult = new Random();
        this.luck = diceResult.nextInt((80 - 1) + 1) + 1;
        return this.luck;
    }

    public Map<Integer, String> typeMap(){
        itemTypeMap.put(1, "Hat");
        itemTypeMap.put(2, "Boots");
        itemTypeMap.put(3, "Glass eye");
        itemTypeMap.put(4, "Horse");
        itemTypeMap.put(5, "Lucky Penny");
        return itemTypeMap;
    }
}
