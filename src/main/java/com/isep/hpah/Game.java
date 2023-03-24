package com.isep.hpah;

import com.isep.hpah.core.*;
import com.isep.hpah.core.constructors.*;
import com.isep.hpah.core.constructors.character.Character; //Because of suspected ambiguity
import com.isep.hpah.core.constructors.character.*;
import com.isep.hpah.core.constructors.spells.*;

import java.util.*;

//for functions - the controller
public class Game {
    private final AllSpellsFunction spfnc;
    public Game() {
        spfnc = new AllSpellsFunction(this);
    }
    private final AllPotionsFunction popofnc = new AllPotionsFunction();
    private final EnemyGame engame = new EnemyGame();
    private final Setup stp = new Setup();
    private final SafeScanner sc = new SafeScanner(System.in);

    public void dungeonCombat(List<Character> enemies, Wizard player) {
        int round = 1;
        SafeScanner sc = new SafeScanner(System.in);
        List<AbstractSpell> spells = player.getKnownSpells();

        //If basilisk dungeon2 give gryffindor sword that doubles att
        gryffindorSword(player, enemies);

        // Loop until all enemies are defeated or the player dies
        while (!enemies.isEmpty() && player.getHealth() > 0) {
            //if def spell used etc.
            checkDefBoost(player);
            //checking what text to print based on enemy
            checkEnemiesText(enemies);
            //list all the enemies with their stats
            for (Character enemy : enemies) {
                System.out.println("\nEnemy: " + enemy.getName() + "\nHealth: " + enemy.getHealth() + "\n" + enemy.getType()+ "\n");
            }
            // presenting turn and returns choice
            int choice = presentingTurn(player, round, sc, enemies);

            int targetIndex = 0;
            if (choice == 1) {
                // normal attack
                attacking(enemies, player, sc);
            } else if (choice == 2) {
                // defend, temporary double the def
                System.out.println("You brace yourself for an attack and double your defense for this turn.");
                player.setDefending(true);
            } else if (choice == 3) {
                // use spells: check what spell to choose and check what type of spell then do effect
                int spellIndex = chooseSpell(spells, sc);
                AbstractSpell spell = spells.get(spellIndex);
                if (spell.getType().equals("DMG")) {
                    // DMG spell: simple
                    processDmgSpell(player, spell, enemies, sc);
                } else if (spell.getType().equals("DEF")) {
                    // DEF spell: simple
                    processDefSpell(spell, player, enemies);

                } else if (spell.getType().equals("UTL")) {
                    // DEX spell: most complicated, based on spell UTL + enemy
                    targetIndex = processUtlSpell(player, spell, enemies, sc);

                }
            } else if (choice == 4) {
                //Use popos, pretty simple
                int potionIndex = selectPotion(player);
                popofnc.usePotion(player, potionIndex);
            }

            allyDeathEater(player, enemies, choice);

            // Enemies' turn
            engame.enemiesTurn(enemies, player);
            // Dungeon2: checking if dead and then remove att boost
            removeGryffindorSword(player, enemies);
            checkLevelUp(player);
            spfnc.checkCooldown(spells, enemies, targetIndex);
            round++;

            // Remove defeated enemies
            enemies.removeIf(enemy -> enemy.getHealth() <= 0);
        }

        // Determine the outcome of the fight
        endDungeon(player);
        // Check through list of all the spells and gives spell if level corresponds
        giveNewSpell(player);
        // Gives random chance of dropping potions 20%
        giveNewPotions(player);
        // Remove all potion boosts from this combat
        checkPotionBoost(player);
    }

    private void checkEnemiesText(List<Character> enemies) {

        for (Character enemy : enemies) {
            if (enemy.getName().equals("Troll")) {
                System.out.println("\nYou see a boulder above the troll's head, what can you do with it ?\n");
            }
            else if (enemy.getName().equals("Basilisk")) {
                System.out.println("\nIt's a poisonous powerful snake, try to remove his fangs in a way or another !\n");
            }
            else if (enemy.getName().equals("Dementor")) {
                System.out.println("\nThere are too many dementors ! Scare them out with one of your spells ! They are scared of divine creatures !\n");
                break;
            }
            else if (enemy.getName().equals("Peter Pettigrew")) {
                System.out.println("\nYou cannot fight them ! Find a way to get closer to the Portkey as fast as you can !\n");
            }
            else if (enemy.getName().equals("Dolores Umbridge")) {
                System.out.println("\nTry to delay and waste time as much as you can !\n");
            }
            else if (enemy.getName().equals("Death Eater")) {
                System.out.println("\nThere are too many death eaters! Scare them out with one of your spells ! They do not like to suffer !\n");
                break;
            }
            else if (enemy.getName().equals("Lord Voldemort")) {
                System.out.println("\nHe can use Avada Kedavra ! Consider this possibility and protect yourself !\n");
                break;
            }
           else if (enemy.getName().equals("Bellatrix Lestrange")) {
                System.out.println("\nHe can use Avada Kedavra ! Consider this possibility and protect yourself !\n");
                break;
            }

        }
    }

    private void gryffindorSword(Wizard player, List<Character> enemies){
            if (player.getHouse().equals(House.GRYFFINDOR) && enemies.get(0).getName().equals("Basilisk")){
                player.setAtt(player.getAtt() * 2);
                System.out.println("Since you're a gryffindor, you have the sword of Gryffindor against the basilisk !\n" +
                        "You deal double damage with your basic attacks !");
            }
    }

    private int presentingTurn(Wizard player, int round, SafeScanner sc, List<Character> enemies){
        sc.printHeading("Health: " + player.getHealth() + "\nMana: " + player.getMana() + "\nAtt: " + player.getAtt()
                + "\nDef: " + player.getDef() + "\nCorruption: " + player.getCorruptionGauge());
        player.setDefending(false);
        System.out.println("\nRound " + round + " begins.");
        // Player's turn
        int choice = 0;
        boolean verifInput = false;
        if (player.getHouse().equals(House.SLYTHERIN) && enemies.get(0).getName().equals("Death Eater")) {
            System.out.println("\nSince you're a slytherin, you can ally yourself with the Death eaters !\n");
            while (!verifInput) {
                try {
                    sc.printHeading("It's your turn to attack. What do you want to do? " +
                            "\n1. Attack\n2. Defend\n3. Use spells\n4. Use items\n5. Ally with the Death Eaters");
                    choice = sc.getInt();
                    verifInput = true;
                } catch (Exception e) {
                    System.out.println("Please write valid content");
                    verifInput = false;
                }
            }
        } else {
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
        }
        return choice;
    }

    private void attacking(List<Character> enemies, Wizard player, SafeScanner sc){
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

    private int chooseSpell(List<AbstractSpell> spells, SafeScanner sc) {
        int spellIndex = 0;
        boolean verifInput = false;
        while (!verifInput) {
            try {
                System.out.println("Select a spell to cast:");
                for (int i = 0; i < spells.size(); i++) {
                    System.out.println((i + 1) + ". " + spells.get(i).getName() + " (Type: " + spells.get(i).getType()
                            + ", Mana Cost: " + spells.get(i).getMana() + ", Cooldown: " + spells.get(i).getCooldown()
                            + ", Cooldown remaining: " + spells.get(i).getCooldownRem());
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

    private void processDmgSpell(Wizard player, AbstractSpell spell, List<Character> enemies, SafeScanner sc) {
        if (spell.getCooldownRem() > 0) {
            System.out.println("Spell is on cooldown for " + spell.getCooldownRem() + " more rounds.");
        } else if (player.getMana() < spell.getMana()) {
            System.out.println("Not enough mana to cast " + spell.getName() + ".");
        } else {
            if (spell.getName().equals("Sectumsempra")){
                if (enemies.get(0).getName().equals("Death Eater")){
                    System.out.println("You mercilessly killed one of the Death Eater ! They all got scared and they all left !");
                    for (Character enemy : enemies) {
                        enemy.setHealth(0);
                    }
                }
            } else {
                int targetIndex = chooseTarget(spell, enemies, sc);

                Character target = enemies.get(targetIndex);
                spfnc.castDmgSpell(spell, player, target);

                spell.setCooldownRem(spell.getCooldown());

                spfnc.manaReduce(spell, player);
            }
        }
    }

    private void processDefSpell(AbstractSpell spell, Wizard player, List<Character> enemies){
        if (spell.getCooldownRem() > 0) {
            System.out.println("Spell is on cooldown for " + spell.getCooldownRem() + " more rounds.");
        } else if (player.getMana() < spell.getMana()) {
            System.out.println("Not enough mana to cast " + spell.getName() + ".");
        } else {
            if (spell.getName().equals("Expecto Patronum")){
                if (enemies.get(0).getName().equals("Dementor")){
                    for (Character enemy : enemies) {
                        enemy.setHealth(0);
                    }
                    System.out.println("They've seen what divine beast you're capable of summoning, they got scared and they all left !");
                }
            } else {
                spfnc.castDefSpell(spell, player);

                spell.setCooldownRem(spell.getCooldown());

                spfnc.manaReduce(spell, player);
            }
        }
    }

    private int processUtlSpell(Wizard player, AbstractSpell spell, List<Character> enemies, SafeScanner sc){
        if (spell.getCooldownRem() > 0) {
            System.out.println("Spell is on cooldown for " + spell.getCooldownRem() + " more rounds.");
        } else if (player.getMana() < spell.getMana()) {
            System.out.println("Not enough mana to cast " + spell.getName() + ".");
        } else {

            int targetIndex = spfnc.checkUtlSpellUsage(spell, enemies, sc);

            spell.setCooldownRem(spell.getCooldown());

            spfnc.manaReduce(spell, player);

            return targetIndex;
        }
        return 0;
    }

    private int selectPotion(Wizard player){
        int potionIndex = 0;
        List<Potion> potions = player.getPotionsOwned();
        boolean verifInput = false;
        while (!verifInput) {
            try {
                System.out.println("Select a potion to use:");
                for (int i = 0; i < potions.size(); i++) {
                    System.out.println((i + 1) + ". " + potions.get(i).getName() + ", boost: "
                            + potions.get(i).getBoost() +", type: " + potions.get(i).getType());
                }
                potionIndex = sc.getInt() - 1;
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write valid content");
                verifInput = false;
            }
        }
        return potionIndex;
    }

    private void allyDeathEater(Wizard player, List<Character> enemies, int choice){
        if (player.getHouse().equals(House.SLYTHERIN) && enemies.get(0).getName().equals("Death Eater")){
            if (choice == 5) {
                for (Character enemy : enemies) {
                    enemy.setHealth(0);
                }
                player.getKnownSpells().add(stp.deathEaterGroup);

                System.out.println("You've decided to ally with the death eaters !\nAnd you obtained a new spell:\n" +
                        stp.deathEaterGroup.getName() + ", type: " + stp.deathEaterGroup.getType() + ", dmg: "
                        + stp.deathEaterGroup.getNum() + ", corruption: " + stp.deathEaterGroup.getCorruption());
            }
        }
    }

    private void endDungeon(Wizard player){
        // Determine the outcome of the fight
        if (player.getHealth() <= 0) {
            System.out.println("\nYou have been defeated.");
        } else {
            System.out.println("\nYou are victorious!");
        }
    }

    private void checkDefBoost(Wizard player){
        if (player.getDefSpell() != 0) {
            player.setDef(player.getDef() - player.getDefSpell());
            player.setDefSpell(0);
        }
    }

    public int chooseTarget(AbstractSpell spell, List<Character> enemies, SafeScanner sc) {
        boolean verifInput = false;
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
        return targetIndex;
    }

    private void removeGryffindorSword(Wizard player, List<Character> enemies){
        if (enemies.get(0).getName().equals("Basilisk") && enemies.get(0).getHealth() == 0) {
            player.setAtt(player.getAtt() / 2);
            System.out.println("You've defeated the basilisk, and can no longer use the gryffindor sword. " +
                    "You attack normally.");
        }
    }

    private void checkLevelUp(Wizard player) {
        while (player.getExp() >= 50) {
            player.setLevel(player.getLevel() + 1);
            player.setExp(player.getExp()- 50);
            sc.printHeading("\nCongratulations! You have leveled up to level " + player.getLevel() + ".");

            player.setMaxHealth(player.getMaxHealth() + 20);
            player.setHealth(player.getMaxHealth());
            player.setMaxMana(player.getMana() + 20);
            player.setMana(player.getMaxMana());

            player.setAtt(player.getAtt() + 5);
            player.setDef(player.getDef() + 5);
            player.setDex(player.getDex() + 2);

            sc.printHeading("Your new stats: \nAtt: " + player.getAtt() + "\nDef: " +
                    player.getDef() + "\nDex: " + player.getDex());

        }
    }

    private void giveNewSpell(Wizard player) {
        List<AbstractSpell> obtainableSpells = stp.allObtainableSpells();

        for (AbstractSpell spell : obtainableSpells){
            if (player.getLevel() == spell.getLevel()){
                player.getKnownSpells().add(spell);
                sc.printHeading("\nYou know a new spell: \n" + spell.getName() + ", " + spell.getDesc() +
                        "\nMana: " + spell.getMana() + " and Cooldown: " + spell.getCooldown());
            }
        }
    }

    private void giveNewPotions(Wizard player){
        List<Potion> allPotions = stp.allPotions();
        double rand = Math.random();

        for (Potion potion : allPotions){
            if (rand > 0.20){
                player.getPotionsOwned().add(potion);
                sc.printHeading("\nYou own a new potion: \n" + potion.getName() + ", " + potion.getDesc() +
                        ", gives: " + potion.getBoost() + potion.getType());
            }
        }
    }

    private void checkPotionBoost(Wizard player) {
        if (player.getPotionDefBoost() != 0){
            player.setDef(player.getDef() - player.getPotionDefBoost());
            player.setPotionDefBoost(0);
            System.out.println("\nYour defense went back to normal: it is now" + player.getDef());
        }
        if (player.getPotionDexBoost() != 0){
            player.setDex(player.getDex() - player.getPotionDexBoost());
            player.setPotionDexBoost(0);
            System.out.println("\nYour dexterity went back to normal: it is now" + player.getDex());
        }
    }
}