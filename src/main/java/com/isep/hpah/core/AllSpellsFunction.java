package com.isep.hpah.core;

import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.constructors.character.Character;
import com.isep.hpah.core.constructors.character.Wizard;
import com.isep.hpah.core.constructors.spells.AbstractSpell;

import java.util.List;
import java.util.Objects;

public class AllSpellsFunction {
    private Game game;

    public AllSpellsFunction(Game game) {
        this.game = game;
    }


    public void manaReduce(AbstractSpell spell, Wizard player) {
        player.setMana(player.getMana() - spell.getMana());
    }

    // Method to cast a spell
    public void castDmgSpell(AbstractSpell spell, Character player, Character enemy) {
        // Cast the attacking spell on the enemy
        int damage = spell.getNum();
        double hitChance = 0.7 + player.getDex();
        double rand = Math.random();
        if (rand > hitChance) {
            System.out.println(player.getName() + " missed the attack !");
            return;
        }
        int remainingHealth = enemy.getHealth() - damage;
        enemy.setHealth(remainingHealth);
        System.out.println(player.getName() + " hit " + enemy.getName() + " with " + spell.getName() + " for " + damage + " damage !");
        System.out.println(enemy.getName() + " has " + remainingHealth + " health points remaining.");
    }

    public void castDefSpell(AbstractSpell spell, Wizard player){
        int val = spell.getNum();
        player.setDefSpell(val);
        player.setDef(player.getDefSpell());
        System.out.println("You gained " + val + " defense for this turn and have now a total of " + player.getDef() + " defense !");
    }

    public void checkCooldown(List<AbstractSpell> spells){
        for (AbstractSpell spell : spells) {
            if (spell.getCooldownRem() > 0) {
                spell.setCooldown(spell.getCooldownRem() - 1);
            }
        }
    }

    public void checkUtlSpellUsage(AbstractSpell spell, Wizard player, List<Character> enemies, SafeScanner sc){
        //TODO : MAKE THE CHECK UTL SPELL USAGE SWITCH CASE BASED ON DUNGEON / ENEMY
        int targetIndex = game.chooseTarget(spell, enemies, sc);

        Character target = enemies.get(targetIndex);
        castUtlSpell(spell, player, target, sc);
    }


    //Extremely long process; A switch case that checks what spell
    public void castUtlSpell(AbstractSpell spell, Wizard player, Character target, SafeScanner sc) {
        switch(target.getName()) {
            case "Troll":
                if (spell.getName().equals("Wingardium Leviosa")) {
                    target.setHealth(0);
                    System.out.println("You saw the boulder, you levitated it and you squished the troll !");
                }
                break;
            case "Basilisk":
                if (spell.getName().equals("Accio")) {
                    target.setHealth(target.getHealth()/3);
                    System.out.println("You successfully removed his fangs !");
                }
                break;
            case "Dementor":
                if (spell.getName().equals("Expecto Patronum")) {
                    //end the dungeon
                }
                break;
            case "Lord Voldemort":
                if (spell.getName().equals("Accio")) {
                    //Skip the dungeon
                }
                break;
            case "Peter Pettigrew":
                if (spell.getName().equals("Accio")) {
                    //Skip the dungeon
                }
                break;
            case "Death Eater":
                if (spell.getName().equals("Sectumsempra")) {
                    //end dungeon sale way as dementor but don't forget the house
                }
                break;
            default:
                //TODO All other use case on utility spells
                break;

                //TODO: ALL of this, maybe need to do 2 diff Voldemort since 2 occurences and 2 diff dungeons
        }
    }
}
