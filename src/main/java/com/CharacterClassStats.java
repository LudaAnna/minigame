package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CharacterClassStats{
    int luck;
    Human human = new Human();
    Alien alien = new Alien();
    Giorgio giorgio = new Giorgio();
    Wizard wizard = new Wizard();
    Goblin goblin = new Goblin();

    public Map<String, Integer> getCharacterStats(String characterClass){
        Map <String, Integer> classStats = new HashMap<String, Integer>();
        this.luck = checkLuck();
        if (characterClass.equals("Human")) {
            classStats = human.getHumanStats(this.luck);
        } else if (characterClass.equals("Alien")){
            classStats = alien.getAlienStats(this.luck);
        } else if (characterClass.equals("Giorgio")){
            classStats = giorgio.getGiorgioStats(this.luck);
        } else if (characterClass.equals("Wizard")){
            classStats = wizard.getWizardStats(this.luck);
        } else if (characterClass.equals("Goblin")) {
            classStats = goblin.getGoblinStats(this.luck);
        }
        return classStats;
    }
    public int checkLuck(){
        Random diceResult = new Random();
        this.luck = diceResult.nextInt((5 - 1) + 1) + 1;;
        return this.luck;
    }
}
