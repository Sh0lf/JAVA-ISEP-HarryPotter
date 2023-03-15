package com.isep.hpah;

import com.isep.hpah.core.*;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.character.Character; //Because of suspected ambiguity
import com.isep.hpah.core.potions.AllPotionsFunction;
import com.isep.hpah.core.spells.AllSpellsFunction;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.isep.hpah.core.character.Wizard.checkLevelUp;


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
        Wizard player = new Wizard(name, "The player", 200, 0, 20, 20, 20, 1, wand, pet, house,
                AllSpellsFunction.startingSpellList(), AllPotionsFunction.empty(), 0, 100, 100);
        return player;
    }

    public static void dungeonCombat(List<Character> enemies, Wizard player) {
        SafeScanner sc = new SafeScanner(System.in);
        int round = 1;
        boolean verifInput = false;

        // Loop until all enemies are defeated or the player dies
        while (!enemies.isEmpty() && player.getHealth() > 0) {
            player.setDefending(false);
            System.out.println("\nRound " + round + " begins.");
            // Player's turn
            int choice = 0;
            while (!verifInput) {
                try {
                    printHeading("It's your turn to attack. What do you want to do? " +
                            "\n1. Attack\n2. Defend\n3. Use spells\n4. Use items");
                    choice = sc.getInt();
                    verifInput = true;
                } catch (Exception e) {
                    System.out.println("Please write valid content");
                    verifInput = false;
                }
            }
            verifInput = false;
            if (choice == 1) {
                int targetIndex = 0;
                while (!verifInput) {
                    try {
                        System.out.println("Which enemy do you want to attack?");
                        for (int i = 0; i < enemies.size(); i++) {
                            System.out.println((i + 1) + ". " + enemies.get(i).getName() + " : " +
                                    enemies.get(i).getHealth() + " health");
                            targetIndex = sc.getInt() - 1;
                            verifInput = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Please write valid content");
                        verifInput = false;
                    }
                }

                Character target = enemies.get(targetIndex);
                player.normalAttack(target);

            } else if (choice == 2) {
                System.out.println("You brace yourself for an attack and double your defense for this turn.");
                player.setDefending(true);
            } else if (choice == 3) {
                // TODO: Implement spell casting
                System.out.println("Spell casting not implemented.");

            } else if (choice == 4) {
                // TODO: Implement Item usage (pots)
                System.out.println("Item usage not implemented.");
            }

            // Enemies' turn
            for (Character enemy : enemies) {
                enemy.setDefending(false);
                if (enemy.getHealth() > 0 && (Objects.equals(enemy.getType(), "Enemy: Boss") ||
                        Objects.equals(enemy.getType(), "Enemy: Mob"))) {
                    Random rand = new Random();
                    float chance = rand.nextFloat();
                    if (chance <= 0.8) {
                        enemy.normalAttack(player);
                    } else {
                        enemy.setDefending(true);
                        System.out.println("The enemy has decided to defend !");
                    }
                }
            }

            for (Character enemy : enemies) {
                if (enemy.getHealth() <= 0) {
                    player.setExp(player.getExp() + enemy.getExp());
                    System.out.println("You gained " + enemy.getExp() + " experience points.");
                }
            }

            checkLevelUp(player);
            round++;

            // Remove defeated enemies
            enemies.removeIf(enemy -> enemy.getHealth() <= 0);
        }

        // Determine the outcome of the fight
        if (player.getHealth() <= 0) {
            System.out.println("\nYou have been defeated.");
        } else {
            System.out.println("\nYou are victorious!");
        }
    }
}
