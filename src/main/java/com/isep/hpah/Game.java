package com.isep.hpah;
import com.isep.hpah.core.*;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.character.Character;
import com.isep.hpah.core.dungeon.Dungeon;
import com.isep.hpah.core.potions.AllPotionsFunction;
import com.isep.hpah.core.spells.*;

import java.util.List;
import java.util.Scanner;
import static com.isep.hpah.core.Pet.*;
import static com.isep.hpah.core.SortingHat.*;
import static com.isep.hpah.core.dungeon.AllDungeonsFunction.*;

//for functions - the controller
public class Game {

    //function to clear console (technically skipping / doing empty lines)
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //function for separator
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //function to print a heading
    public static void printHeading(String title) {
        printSeparator(title.length());
        System.out.println(title);
        printSeparator(title.length());
    }

    //clears Console and does the heading afterwards
    public static void printHeader(String title){
        clearConsole();
        printHeading(title);
    }

    public static Wizard playerCreation (String name, Wand wand, Pet pet, House house) {
        Wizard player = new Wizard(name, "The player", 200, 0, 20, 20, 20, wand, pet, house,
                AllSpellsFunction.startingSpellList(), AllPotionsFunction.empty(), 0, 100, 100);
        return player;
    }

    public static void dungeonCombat(List<Dungeon> dungeons, int i){
        List<Character> enemies = dungeons.get(i).getEnemies();
    }

    public static void dungeonCombat(List<Character> enemies, Wizard player) {
        SafeScanner sc = new SafeScanner(System.in);
        int round = 1;

        // Loop until all enemies are defeated or the player dies
        while (!enemies.isEmpty() && player.getHealth() > 0) {
            System.out.println("Round " + round + " begins.");

            // Player's turn
            System.out.println("It's your turn. What do you want to do?");
            System.out.println("1. Attack");
            System.out.println("2. Use item");
            int choice = sc.getInt();

            if (choice == 1) {
                System.out.println("Which enemy do you want to attack?");
                for (int i = 0; i < enemies.size(); i++) {
                    System.out.println((i+1) + ". " + enemies.get(i).getName());
                }
                int targetIndex = sc.getInt() - 1;
                Character target = enemies.get(targetIndex);

                player.normalAttack(target);
                System.out.println("You attack " + target.getName() + " for " + player.getAtt() + " damage.");
            } else if (choice == 2) {
                // TODO: Implement item usage
                System.out.println("Items not implemented yet.");
            } else {
                System.out.println("Invalid choice.");
            }

            // Enemies' turn
            for (Character enemy : enemies) {
                if (enemy.getHealth() > 0 && (enemy.getDesc() == "Enemy: Boss" || enemy.getDesc() == "Enemy: Mob")) {
                    enemy.normalAttack(player);
                    System.out.println(enemy.getName() + " attacks you for " + enemy.getAtt() + " damage.");
                }
            }

            // Remove defeated enemies
            enemies.removeIf(enemy -> enemy.getHealth() <= 0);

            round++;
        }

        // Determine the outcome of the fight
        if (player.getHealth() <= 0) {
            System.out.println("You have been defeated.");
        } else {
            System.out.println("You are victorious!");
            double totalExp = enemies.stream().mapToDouble(Character::getExp).sum();
            System.out.println("You gain " + totalExp + " experience points.");

            // TODO: Implement leveling up
            System.out.println("Leveling up not implemented yet.");
        }
    }
}
