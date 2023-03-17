package com.isep.hpah;

import com.isep.hpah.core.*;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.character.Character; //Because of suspected ambiguity
import com.isep.hpah.core.potions.AllPotionsFunction;
import com.isep.hpah.core.spells.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.isep.hpah.core.Pet.generateRandomPet;
import static com.isep.hpah.core.SortingHat.getResHouse;
import static com.isep.hpah.core.character.Wizard.*;
import static com.isep.hpah.core.spells.AllSpellsFunction.*;

//for functions - the controller
public class Game {
    public static Wizard gamePres(SafeScanner sc){
        boolean verifInput = false;
        String name = "";
        House house;
        Pet pet;
        Wand wand;
        String wandName = "";
        int wandSize = 0;
        int res1 = 0;
        int res2 = 0;
        int finalRes = 0;

        sc.printHeading("Harry Potter RPG game, made by Yap Vincent");

        while (!verifInput) {
            try {
                System.out.println("WELCOME APPRENTICE ! What's your name ?");
                name = sc.getString();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid string, not an integer !");
                verifInput = false;
            }
        }

        verifInput = false;

        sc.printHeader("Welcome to Hogwarts, dear " + name + " ! Are you ready for a new adventure ?!");
        sc.pressEnterToContinue();

        sc.printHeading("Great ! Now let me put the mighty legendary Sorting Hat on your head, and let him do his " +
                "magic and allocate you to a house !");
        sc.pressEnterToContinue();

        sc.printHeading("Sorting Hat : Student, before I rashly allocate you to a house, let me ask you some questions " +
                ": \nYou come here with preferences and preconceptions - certain expectations. \n" +
                "[1] I can't wait to start classes. \n" +
                "[2] I can't wait to explore.");

        while(!verifInput) {
            try {
                int tempRes1 = sc.getInt();
                res1 = tempRes1 * 10;
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please select an answer by writing 1 or 2 !");
                verifInput = false;
            }
        }

        verifInput = false;

        sc.printHeading("Sorting Hat : I see... Hmm, I detect something in you. A certain sens of - hmm - " +
                "what is it ?\n" +
                "[1] Daring. \n" +
                "[2] Ambition.");

        while(!verifInput) {
            try {
                res2 = sc.getInt();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please select an answer by writing 1 or 2 !");
                verifInput = false;
            }
        }

        verifInput = false;

        finalRes = res1 + res2;
        house = getResHouse(finalRes);

        pet = generateRandomPet();
        sc.printHeading("Sorting Hat : You belong to " + house + " ! \nHere's your pet ! It's a small but " +
                "fierce " + pet + " !\nNow, get me out of him, I despise people of this house !");
        sc.pressEnterToContinue();

        sc.printHeader("Thank you Sorting Hat ! Don't mind him much, he can be mean but " +
                "he gets his job well done \nand ultimately he does care about the students ! \nNow let's get your wand ! \n" +
                "Of course you need one !");
        sc.pressEnterToContinue();

        while(!verifInput) {
            try {
                System.out.println("First of all, how would you call your wand?");
                wandName = sc.getString();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write valid content");
                verifInput = false;
            }
        }
        verifInput = false;

        while(!verifInput) {
            try {
                System.out.println("And what size in cm would be ideal for you ?");
                wandSize = sc.getInt();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write valid content");
                verifInput = false;
            }
        }

        wand = new Wand(wandName, wandSize);

        sc.printHeading("Great ! I found you a wand that looks perfect to you ! It has a " + wand.getCore() +
                " under the name of " + wand.getName() + " and the size is exactly what you wanted : " + wand.getSize());

        sc.pressEnterToContinue();

        Wizard player = playerCreation(name, wand, pet, house);

        sc.clearConsole();
        sc.printHeading("Now wizard, are you ready ?! You will start this story knowing a few spells:");

        for (AbstractSpell spell : player.getKnownSpells()) {
            // print out the name and description of the spell
            System.out.println(spell.getName() + " : " + spell.getDesc());
        }

        sc.printHeading("Now, watch out during your journey, there's forbidden spells. If you ever use them, " +
                "you would raise your corruption gauge. Do not go beyond 100 !\n\n" +
                "Your stats are:\nHealth: " + player.getHealth() + "\nAtt: " + player.getAtt() +
                "\nDef: " + player.getDef() + "\nDex: " + player.getDex() + "\nMana: " + player.getMana() +
                "\n\nNow, enough talking, your first quest :");

        return player;
    }

    private static Wizard playerCreation (String name, Wand wand, Pet pet, House house) {
        int defaultDef = 10;
        int defaultDex = 10;

        if (house == House.GRYFFINDOR){
            defaultDef = 20;
        }

        if (house == House.RAVENCLAW){
            defaultDex = 15;
        }

        Wizard player = Wizard.builder()
            .name(name)
            .desc("The player")
            .health(200)
            .exp(0)
            .att(20)
            .def(defaultDef)
            .dex(defaultDex)
            .level(1)
            .wand(wand)
            .pet(pet)
            .house(house)
            .knownSpells(AllSpellsFunction.startingSpellList())
            .potionsOwned(AllPotionsFunction.empty())
            .corruptionGauge(0)
            .maxMana(100)
            .mana(100)
            .build();
        return player;
    }

    public static void dungeonCombat(List<Character> enemies, Wizard player) {
        int round = 1;
        boolean verifInput = false;
        SafeScanner sc = new SafeScanner(System.in);
        List<AbstractSpell> spells = player.getKnownSpells();

        checkCooldown(spells);

        checkDefBoost(player);
        // Loop until all enemies are defeated or the player dies
        while (!enemies.isEmpty() && player.getHealth() > 0) {

            int choice = presentingTurn(player, round, sc);

            if (choice == 1) {

                attacking(enemies, player, sc);

            } else if (choice == 2) {
                System.out.println("You brace yourself for an attack and double your defense for this turn.");
                player.setDefending(true);
            } else if (choice == 3) {
                int spellIndex = chooseSpell(spells, sc);
                AbstractSpell spell = spells.get(spellIndex);
                if (spell.getType().equals("DMG")) {

                    processDmgSpell(player, spell, enemies, sc);

                } else if (spell.getType().equals("DEF")) {

                    processDefSpell(spell, player);

                } else if (spell.getType().equals("UTL")) {

                    processUtlSpell(player, spell, enemies, sc);

                }
            } else if (choice == 4) {
                // TODO: Implement Item usage (pots)
                System.out.println("Item usage not implemented.");
            }

            // Enemies' turn
            enemiesTurn(enemies, player);

            checkLevelUp(player);
            round++;

            // Remove defeated enemies
            enemies.removeIf(enemy -> enemy.getHealth() <= 0);
        }

        // Determine the outcome of the fight
        endDungeon(player);
    }

    private static int presentingTurn(Wizard player, int round, SafeScanner sc){
        sc.printHeading("Health: " + player.getHealth() + "\nMana: " + player.getMana() + "\nAtt: " + player.getAtt() + "\nDef: " + player.getDef());
        player.setDefending(false);
        System.out.println("\nRound " + round + " begins.");
        // Player's turn
        int choice = 0;
        boolean verifInput = false;
        while (!verifInput) {
            try {
                sc.printHeading("It's your turn to attack. What do you want to do? " +
                        "\n1. Attack\n2. Defend\n3. Use spells\n4. Use items");
                choice = sc.getInt();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write valid content");
                verifInput = false;
            }
        }
        return choice;
    }

    private static void attacking(List<Character> enemies, Wizard player, SafeScanner sc){
        int targetIndex = 0;
        boolean verifInput = false;
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
    }

    private static void enemiesTurn(List<Character> enemies, Wizard player){
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
    }

    private static int chooseSpell(List<AbstractSpell> spells, SafeScanner sc) {
        int spellIndex = 0;
        boolean verifInput = false;
        while (!verifInput) {
            try {
                System.out.println("Select a spell to cast:");
                for (int i = 0; i < spells.size(); i++) {
                    System.out.println((i + 1) + ". " + spells.get(i).getName() + " (Type: " + spells.get(i).getType() + ", Mana Cost: " + spells.get(i).getMana() + ", Cooldown: " + spells.get(i).getCooldown() + ")");
                }
                spellIndex = sc.getInt() - 1;
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write valid content");
                verifInput = false;
            }
        }
        return spellIndex;
    }

    private static void processDmgSpell(Wizard player, AbstractSpell spell, List<Character> enemies, SafeScanner sc) {
        boolean verifInput = false;
        if (spell.getCooldownRem() > 0) {
            System.out.println("Spell is on cooldown for " + spell.getCooldownRem() + " more rounds.");
        } else if (player.getMana() < spell.getMana()) {
            System.out.println("Not enough mana to cast " + spell.getName() + ".");
        } else {
            int targetIndex = 0;
            while (!verifInput) {
                try {
                    System.out.println("Choose an enemy to cast " + spell.getName() + " on:");
                    for (int i = 0; i < enemies.size(); i++) {
                        System.out.println((i + 1) + ". " + enemies.get(i).getName() + " (Health: " + enemies.get(i).getHealth() + ")");
                    }
                    targetIndex = sc.getInt() - 1;
                    verifInput = true;
                } catch (Exception e) {
                    System.out.println("Please write valid content");
                    verifInput = false;
                }
            }
            Character target = enemies.get(targetIndex);
            castDmgSpell(spell, player, target);

            spell.setCooldownRem(spell.getCooldown());
        }
    }

    private static void processDefSpell(AbstractSpell spell, Wizard player){
        if (spell.getCooldownRem() > 0) {
            System.out.println("Spell is on cooldown for " + spell.getCooldownRem() + " more rounds.");
        } else if (player.getMana() < spell.getMana()) {
            System.out.println("Not enough mana to cast " + spell.getName() + ".");
        } else {

            castDefSpell(spell, player);

            spell.setCooldownRem(spell.getCooldown());
        }
    }

    private static void processUtlSpell(Wizard player, AbstractSpell spell, List<Character> enemies, SafeScanner sc){
        boolean verifInput = false;
        if (spell.getCooldownRem() > 0) {
            System.out.println("Spell is on cooldown for " + spell.getCooldownRem() + " more rounds.");
        } else if (player.getMana() < spell.getMana()) {
            System.out.println("Not enough mana to cast " + spell.getName() + ".");
        } else {
            checkUtlSpellUsage(spell, player, enemies, sc);
        }
    }

    private static void endDungeon(Wizard player){
        // Determine the outcome of the fight
        if (player.getHealth() <= 0) {
            System.out.println("\nYou have been defeated.");
        } else {
            System.out.println("\nYou are victorious!");
        }
    }

    private static void checkDefBoost(Wizard player){
        if (player.getDefSpell() != 0) {
            player.setDef(player.getDef() - player.getDefSpell());
            player.setDefSpell(0);
        }
    }


    private static

}
