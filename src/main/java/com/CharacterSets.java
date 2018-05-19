package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CharacterSets{
    private String name;
    private String characterClass;
    private Map<String, Integer> enemy;
    private Map<String, Integer> characterStats = new HashMap<String, Integer>();
    private CharacterClassStats characterClassStats = new CharacterClassStats();
    private ItemBoost itemBoost = new ItemBoost();

    public String getCharacterName() throws IOException {
        System.out.println("What is your name? \n");
        BufferedReader enterName = new BufferedReader(new InputStreamReader(System.in));
        String name = enterName.readLine();
        this.name = name;
        return this.name;
    }

    public String getCharacterClass() throws IOException {
        System.out.println("What are you? \n (choose number) \n");
        System.out.println("1. Human \n 2. Alien \n 3. Giorgio A. Tsoukalos \n 4. Wizard \n 5. Goblin \n");
        BufferedReader enterClass = new BufferedReader(new InputStreamReader(System.in));
        String classNumber = enterClass.readLine();
        String className = checkClassNumber(classNumber);
        if (className.equals("Wrong")){
            getCharacterClass();
        } else{
            this.characterClass = className;
        }
        return characterClass;
    }

    public Map<String, Integer> getClassStats(String characterClass){
        Map <String, Integer> classStats = characterClassStats.getCharacterStats(characterClass);
        this.characterStats = classStats;
        this.characterStats.put(characterClass, 0);
        return characterStats;
    }

    public String checkClassNumber(String classNumber) throws IOException {
        if (classNumber.equals("1")) {
            return "Human";

        } else if (classNumber.equals("2")) {
            return "Alien";

        } else if (classNumber.equals("3")) {
            return "Giorgio A. Tsoukalos";

        } else if (classNumber.equals("4")) {
            return "Wizard";

        } else if (classNumber.equals("5")) {
            return "Goblin";

        } else {
            System.out.println(("Wrong answer. You can't trick me. \n"));
            return "Wrong";

        }
    }

    public Map<String, Integer> getFigthEnemy() throws IOException {
        System.out.println("Do you want to fight?\n");
        System.out.println("1. yes \n 2. no \n");
        String answer = getConsoleInputValue();
        if (answer.equals("1")){
            this.characterClass = checkClassNumber(String.valueOf(characterClassStats.checkLuck()));
            this.enemy = characterClassStats.getCharacterStats(characterClass);
            this.enemy.put(this.characterClass, 0);
        } else if (answer.equals("2")){
            System.out.println("You have to fight :) \n");
            getFigthEnemy();
        } else {
            System.out.println("Wrong answer");
            getFigthEnemy();
        }
        return enemy;
    }

    public String getConsoleInputValue() throws IOException {
        BufferedReader enterClass = new BufferedReader(new InputStreamReader(System.in));
        String consoleValue = enterClass.readLine();
        return consoleValue;
    }

    public Map<String, Integer> getItemBoost(Map<String, Integer> characterStats) throws IOException{
        Map <String, Integer> boostedCharacterStats = new HashMap<String, Integer>();
        Map<String, Integer> itemBoostMap;
        itemBoostMap = itemBoost.getItemBoost();
        System.out.println(itemBoostMap);
        System.out.println("Do you want it? \n 1. yes \n 2. no \n");
        String answer = getConsoleInputValue();
        if(answer.equals("1")){
            boostedCharacterStats.put("Strong", characterStats.get("Strong") + itemBoostMap.get("Strong"));
            boostedCharacterStats.put("Beauty", characterStats.get("Beauty") + itemBoostMap.get("Beauty"));
            boostedCharacterStats.put("Defence", characterStats.get("Defence") + itemBoostMap.get("Defence"));
            boostedCharacterStats.put("Health", characterStats.get("Health") + itemBoostMap.get("Health"));
            boostedCharacterStats.put("Luck", characterStats.get("Luck"));
            boostedCharacterStats.put("Money", characterStats.get("Money") - itemBoostMap.get("Price"));
            boostedCharacterStats.put(getMapKey(itemBoostMap, 0), 0);
            System.out.println("\n Your old stats: \n" + characterStats + ""
                + "\n Your new stats: \n" + boostedCharacterStats);
        } else if(answer.equals("2")){
            boostedCharacterStats = characterStats;
            System.out.println("\n As you want \n");
        } else {
            System.out.println("\n Wrong answer \n");
            getItemBoost(characterStats);
        }
        return boostedCharacterStats;
    }

    public String getMapKey(Map<String, Integer> map, Integer value){
        String newValue = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                newValue = entry.getKey();
                return newValue;
            }
        }
        return newValue;
    }
}
