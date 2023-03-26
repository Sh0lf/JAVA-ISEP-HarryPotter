package com.isep.hpah.controller;

import com.isep.hpah.model.constructors.Core;
import com.isep.hpah.model.constructors.House;
import com.isep.hpah.model.constructors.Potion;
import com.isep.hpah.model.constructors.character.Wizard;
import com.isep.hpah.model.constructors.spells.AbstractSpell;
import com.isep.hpah.views.DungeonOutput;

import com.isep.hpah.views.SafeScanner;
import com.isep.hpah.model.constructors.character.Character; //Because of suspected ambiguity

import java.util.*;

//for functions - the controller
public class Game {
    private final AllSpellsFunction spfnc = new AllSpellsFunction();
    private final AllPotionsFunction popofnc = new AllPotionsFunction();
    private final EnemyGame engame = new EnemyGame();
    private final Setup stp = new Setup();
    private final SafeScanner sc = new SafeScanner(System.in);
    private final DungeonOutput dngout = new DungeonOutput();

    public void dungeonCombat(List<Character> enemies, Wizard player) {
        int round = 1;
        SafeScanner sc = new SafeScanner(System.in);
        List<AbstractSpell> spells = player.getKnownSpells();

        //If basilisk dungeon2 give gryffindor sword that doubles att
        gryffindorSword(player, enemies);

        // Loop until all enemies are defeated or the player dies
        while (!enemies.isEmpty() && player.getHealth() > 0) {
            //dungeon7: voldemort core if same does something
            checkVoldemortCore(player, enemies);
            //if def spell used etc.
            checkDefBoost(player);
            //checking what text to print based on enemy
            dngout.checkEnemiesText(enemies);
            //list all the enemies with their stats
            dngout.listEnemies(enemies);
            // presenting turn and returns choice
            boolean check = false;
            int targetIndex = 0;
            while (!check) {
                int choice = presentingTurn(player, round, sc, enemies);
                targetIndex = 0;
                if (choice == 1) {
                    // normal attack
                    attacking(enemies, player, sc);
                    check = true;
                } else if (choice == 2) {
                    // defend, temporary double the def
                    dngout.isDefending(player);
                    player.setDefending(true);
                    check = true;
                } else if (choice == 3) {
                    // use spells: check what spell to choose and check what type of spell then do effect
                    int spellIndex = chooseSpell(spells, sc);
                    AbstractSpell spell = spells.get(spellIndex);
                    switch (spell.getType()) {
                        case "DMG" -> {
                            // DMG spell: simple
                            if (processDmgSpell(player, spell, enemies, sc)) {
                                check = true;
                            }
                        }
                        case "DEF" -> {
                            // DEF spell: simple
                            if (processDefSpell(spell, player, enemies)) {
                                check = true;
                            }
                        }
                        case "UTL" -> {
                            // DEX spell: most complicated, based on spell UTL + enemy
                            targetIndex = processUtlSpell(player, spell, enemies, sc);
                            if (targetIndex != 100) {
                                check = true;
                            }
                        }
                    }
                } else if (choice == 4) {
                    //Use popos, pretty simple
                    int potionIndex = selectPotion(player);
                    popofnc.usePotion(player, potionIndex);
                    check = true;
                } if (allyDeathEater(player, enemies, choice)){
                    check = true;
                }
            }

            // Enemies' turn
            engame.enemiesTurn(enemies, player);
            // Dungeon2: checking if dead and then remove att boost
            removeGryffindorSword(player, enemies);
            // checking player exp
            checkLevelUp(player);
            // reduce cooldown to spells
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

    private void gryffindorSword(Wizard player, List<Character> enemies){
        if (player.getHouse().equals(House.GRYFFINDOR) && enemies.get(0).getName().equals("Basilisk")){
            player.setAtt(player.getAtt() * 2);
            dngout.gryffindorSwordTxt();
        }
    }

    private void checkVoldemortCore(Wizard player, List<Character> enemies){
        if(enemies.get(0).getName().equals("Lord Voldemort") &&
                player.getWand().getCore().equals(Core.PHOENIX_FEATHER)){
            double rand = Math.random();

            if (rand <= 0.5){
                player.setHealth(player.getHealth() - 20);
                dngout.voldemortCoreTxt(rand);
            }
            else if ((0.5 < rand) && (rand <= 0.8)){
                player.setPotionDefBoost(player.getPotionDefBoost() - 10);
                player.setDef(player.getDef() - 10);
                dngout.voldemortCoreTxt(rand);
            }
            else if ((0.8 < rand) && (rand <= 1)){
                player.setPotionDexBoost(player.getPotionDexBoost() - 5);
                player.setDex(player.getDex() - 5);
                dngout.voldemortCoreTxt(rand);
            }
        }
    }

    private void checkDefBoost(Wizard player){
        if (player.getDefSpell() != 0) {
            player.setDef(player.getDef() - player.getDefSpell());
            player.setDefSpell(0);
        }
    }

    private int presentingTurn(Wizard player, int round, SafeScanner sc, List<Character> enemies){
        int i = 1;
        i = dngout.presentingTurnTxt(i, round, player, enemies, sc);
        player.setDefending(false);
        i = dngout.presentingTurnTxt(i, round, player, enemies, sc);
        // Player's turn
        return dngout.presentingTurnTxt(i, round, player, enemies, sc);
    }

    private void attacking(List<Character> enemies, Wizard player, SafeScanner sc){
        int targetIndex = dngout.chooseTarget(enemies, sc);
        Character target = enemies.get(targetIndex);
        player.normalAttack(target);
    }

    private int chooseSpell(List<AbstractSpell> spells, SafeScanner sc) {
        return dngout.chooseSpell(spells, sc);
    }

    private boolean processDmgSpell(Wizard player, AbstractSpell spell, List<Character> enemies, SafeScanner sc) {
        if (spell.getCooldownRem() > 0) {
            dngout.inCooldown(spell);
            return false;
        } else if (player.getMana() < spell.getMana()) {
            dngout.noMana(spell);
            return false;
        } else {
            if (spell.getName().equals("Sectumsempra")){
                if (enemies.get(0).getName().equals("Death Eater")){
                    dngout.exceptionDeathEater();
                    for (Character enemy : enemies) {
                        enemy.setHealth(0);
                    }
                }
            } else {
                int targetIndex = dngout.chooseTarget(enemies, sc);

                Character target = enemies.get(targetIndex);
                spfnc.castDmgSpell(spell, player, target);

                spell.setCooldownRem(spell.getCooldown());

                spfnc.manaReduce(spell, player);
                return true;
            }
        }
        return false;
    }

    private boolean processDefSpell(AbstractSpell spell, Wizard player, List<Character> enemies){
        if (spell.getCooldownRem() > 0) {
            dngout.inCooldown(spell);
            return false;
        } else if (player.getMana() < spell.getMana()) {
            dngout.noMana(spell);
            return false;
        } else {
            if (spell.getName().equals("Expecto Patronum")){
                if (enemies.get(0).getName().equals("Dementor")){
                    dngout.exceptionDementor();
                    for (Character enemy : enemies) {
                        enemy.setHealth(0);
                    }
                }
            } else {
                spfnc.castDefSpell(spell, player);

                spell.setCooldownRem(spell.getCooldown());

                spfnc.manaReduce(spell, player);

                return true;
            }
        } return false;
    }

    private int processUtlSpell(Wizard player, AbstractSpell spell, List<Character> enemies, SafeScanner sc){
        if (spell.getCooldownRem() > 0) {
            dngout.inCooldown(spell);
            return 100;
        } else if (player.getMana() < spell.getMana()) {
            dngout.noMana(spell);
            return 100;
        } else {

            int targetIndex = spfnc.checkUtlSpellUsage(spell, enemies, sc);

            spell.setCooldownRem(spell.getCooldown());

            spfnc.manaReduce(spell, player);

            return targetIndex;
        }
    }

    private int selectPotion(Wizard player){
        List<Potion> potions = player.getPotionsOwned();
        return dngout.selectPotionTxt(potions, sc);
    }

    private boolean allyDeathEater(Wizard player, List<Character> enemies, int choice){
        if (player.getHouse().equals(House.SLYTHERIN) && enemies.get(0).getName().equals("Death Eater")){
            if (choice == 5) {
                for (Character enemy : enemies) {
                    enemy.setHealth(0);
                }
                player.getKnownSpells().add(stp.deathEaterGroup);

                dngout.deathEaterSpell(stp.deathEaterGroup);
            }
        }
        return true;
    }

    private void endDungeon(Wizard player){
        // Determine the outcome of the fight
        if (player.getHealth() <= 0) {
            dngout.loss();
        } else {
            dngout.victory();
        }
    }

    private void removeGryffindorSword(Wizard player, List<Character> enemies){
        if (enemies.get(0).getName().equals("Basilisk") && enemies.get(0).getHealth() == 0) {
            player.setAtt(player.getAtt() / 2);
            dngout.gryffindorSwordEnd();
        }
    }

    private void checkLevelUp(Wizard player) {
        while (player.getExp() >= 50) {
            int i = 0;
            player.setLevel(player.getLevel() + 1);
            player.setExp(player.getExp()- 50);
            i = dngout.lvlup(i, player);

            player.setMaxHealth(player.getMaxHealth() + 20);
            player.setHealth(player.getMaxHealth());
            player.setMaxMana(player.getMana() + 20);
            player.setMana(player.getMaxMana());

            player.setAtt(player.getAtt() + 5);
            player.setDef(player.getDef() + 5);
            player.setDex(player.getDex() + 2);

            i = dngout.lvlup(i, player);
        }
    }

    private void giveNewSpell(Wizard player) {
        List<AbstractSpell> obtainableSpells = stp.allObtainableSpells();

        for (AbstractSpell spell : obtainableSpells){
            if (player.getLevel() == spell.getLevel()){
                player.getKnownSpells().add(spell);
                dngout.newSpell(spell);
            }
        }
    }

    private void giveNewPotions(Wizard player){
        List<Potion> allPotions = stp.allPotions();
        double rand = Math.random();

        for (Potion potion : allPotions){
            if (rand > 0.20){
                player.getPotionsOwned().add(potion);
                dngout.newPotion(potion);
            }
        }
    }

    private void checkPotionBoost(Wizard player) {
        if (player.getPotionDefBoost() != 0){
            player.setDef(player.getDef() - player.getPotionDefBoost());
            player.setPotionDefBoost(0);
            dngout.defPotionBonus(player);
        }
        if (player.getPotionDexBoost() != 0){
            player.setDex(player.getDex() - player.getPotionDexBoost());
            player.setPotionDexBoost(0);
            dngout.dexPotionBonus(player);
        }
    }
}