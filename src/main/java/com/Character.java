package com;

import java.io.IOException;
import java.util.Map;

public class Character{
    public static void main(String args[]) throws IOException {
        CharacterSets characterSets = new CharacterSets();

        String name = characterSets.getCharacterName();
        System.out.println("Welcome Mr/Mrs " + name);

        String characterClass = characterSets.getCharacterClass();
        System.out.println("Finally, a " + characterClass);

        Map<String, Integer> characterStats = characterSets.getClassStats(characterClass);
        System.out.println("your stats: \n" + characterStats);

        Map<String, Integer> enemyStats = characterSets.getFigthEnemy();
        System.out.println("\n your enemy stats: " + enemyStats);

        System.out.println("\n I have a gift for you. Item boost! \n");
        Map<String, Integer> newCharacterStats = characterSets.getItemBoost(characterStats);
    }
}
