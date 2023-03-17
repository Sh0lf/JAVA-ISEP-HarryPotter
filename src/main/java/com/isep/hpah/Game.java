package com.isep.hpah;

import com.isep.hpah.core.*;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.character.Character; //Because of suspected ambiguity
import com.isep.hpah.core.potions.AllPotionsFunction;
import com.isep.hpah.core.spells.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.isep.hpah.SafeScanner.*;
import static com.isep.hpah.core.character.Wizard.*;
import static com.isep.hpah.core.spells.AllSpellsFunction.*;

//for functions - the controller
public class Game {

    public static Wizard playerCreation (String name, Wand wand, Pet pet, House house) {
        Wizard player = Wizard.builder()
            .name(name)
            .desc("The player")
            .health(200)
            .exp(0)
            .att(20)
            .def(20)
            .dex(20)
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
                    //TODO HERE
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
        if (player.getHealth() <= 0) {
            System.out.println("\nYou have been defeated.");
        } else {
            System.out.println("\nYou are victorious!");
        }
    }

    private static int presentingTurn(Wizard player, int round, SafeScanner sc){
        printHeading("Health: " + player.getHealth() + "\nMana: " + player.getMana() + "\nAtt: " + player.getAtt() + "\nDef: " + player.getDef());
        player.setDefending(false);
        System.out.println("\nRound " + round + " begins.");
        // Player's turn
        int choice = 0;
        boolean verifInput = false;
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
        }
    }

    private static void processDefSpell(AbstractSpell spell, Wizard player){
        if (spell.getCooldownRem() > 0) {
            System.out.println("Spell is on cooldown for " + spell.getCooldownRem() + " more rounds.");
        } else if (player.getMana() < spell.getMana()) {
            System.out.println("Not enough mana to cast " + spell.getName() + ".");
        } else {
            castDefSpell(spell, player);
        }
    }
}
