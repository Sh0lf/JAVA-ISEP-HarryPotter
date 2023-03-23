package com.isep.hpah;

import com.isep.hpah.core.*;
import com.isep.hpah.core.constructors.*;
import com.isep.hpah.core.constructors.character.*;
import com.isep.hpah.core.constructors.character.Character;
import com.isep.hpah.core.constructors.spells.*;

import java.util.List;
import java.util.Random;

public class EnemyGame {

    AllSpellsFunction spfnc = new AllSpellsFunction(new Game());
    AllPotionsFunction popofnc = new AllPotionsFunction();

    public void enemiesTurn(List<Character> enemies, Wizard player){
        for (Character enemy : enemies) {
            enemy.setDefending(false);
            if (enemy.getHealth() > 0) {
                if (enemy instanceof Boss || enemy instanceof Enemy) {
                    commonEnemySys(enemy, player);
                } else if (enemy instanceof Wizard) {
                    wizardEnemySys((Wizard) enemy, player);
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

    private void commonEnemySys(Character enemy, Wizard player) {
        double rand = Math.random();
        if (rand <= 0.8) {
            enemy.normalAttack(player);
        } else {
            enemy.setDefending(true);
            System.out.println(enemy.getName() + " has decided to defend");
        }
    }

    private void wizardEnemySys(Wizard enemy, Wizard player){
        double rand = Math.random();
        if (rand <= 0.5) {
            enemy.normalAttack(player);
        } else if (0.5 < rand && rand <= 0.7){
            enemy.setDefending(true);
            System.out.println(enemy.getName() + " has decided to defend");
        } else if ( 0.7 < rand && rand <= 0.9) {
            List<AbstractSpell> enemySpell = ((Wizard) enemy).getKnownSpells();
            // initializing random class
            Random random = new Random();
            // loop for generation random number
            int index = 0;
            for (int i = 0; i < enemySpell.size(); i++) {
                index = random.nextInt(enemySpell.size());
            }
            AbstractSpell spell = enemySpell.get(index);
            if (spell.getType().equals("DMG")) {
                spfnc.castDmgSpell(spell, enemy, player);
                spell.setCooldownRem(spell.getCooldown());
                spfnc.manaReduce(spell, player);
            } else if (spell.getType().equals("DEF")) {
                spfnc.castDefSpell(spell, player);
                spell.setCooldownRem(spell.getCooldown());
                spfnc.manaReduce(spell, player);
            }
        } else if (0.9 < rand && rand <= 1){
            List<Potion> allPotion = ((Wizard) enemy).getPotionsOwned();
            // initializing random class
            Random random = new Random();
            // loop for generation random number
            int index = 0;
            for (int i = 0; i < allPotion.size(); i++) {
                    index = random.nextInt(allPotion.size());
            }
            popofnc.usePotion(enemy, index);
        }
    }
}
