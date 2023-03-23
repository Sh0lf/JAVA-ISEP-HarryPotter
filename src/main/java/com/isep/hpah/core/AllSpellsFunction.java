package com.isep.hpah.core;

import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.constructors.House;
import com.isep.hpah.core.constructors.character.Character;
import com.isep.hpah.core.constructors.character.*;
import com.isep.hpah.core.constructors.spells.AbstractSpell;

import java.util.List;

//All directly related spell functions/methods, mostly casting methods and some checking methods
public class AllSpellsFunction {

    //This used to prevent StackOverflowError between file Game.java and this file as they are basically correlated
    private Game game;

    public AllSpellsFunction(Game game) {
        this.game = game;
    }

    //self explanatory
    public void manaReduce(AbstractSpell spell, Wizard player) {
        player.setMana(player.getMana() - spell.getMana());
    }

    // Method to cast a dmg spell, deal dmg
    public void castDmgSpell(AbstractSpell spell, Wizard player, Character enemy) {
        // Cast the attacking spell on the enemy
        double damage = spell.getNum();
        double hitChance = 0.7 + player.getDex();
        double rand = Math.random();
        if (rand > hitChance) {
            System.out.println(player.getName() + " missed the attack !");
            return;
        }

        if (player.getHouse().equals(House.SLYTHERIN)){
            damage = damage * 1.2;
            System.out.println("Since " + player.getName() +" is a Slytherin, you're more efficient with your spells !");
        }

        int remainingHealth = enemy.getHealth() - (int) damage;
        enemy.setHealth(remainingHealth);
        System.out.println(player.getName() + " hit " + enemy.getName() + " with " + spell.getName() + " for " + damage + " damage !");
        System.out.println(enemy.getName() + " has " + remainingHealth + " health points remaining.");
    }

    // Method for DEF spell, comparison based on a Wizard variable DefSpell.
    public void castDefSpell(AbstractSpell spell, Wizard player){
        double val = spell.getNum();

        if (player.getHouse().equals(House.SLYTHERIN)){
            val = val * 1.2;
            System.out.println("Since "+ player.getName() +" is a Slytherin, you're more efficient with your spells !");
        }
        player.setDefSpell((int) val);
        player.setDef(player.getDefSpell());
        System.out.println(player.getName() + " gained " + val + " defense for this turn and have now a total of " + player.getDef() + " defense !");
    }

    //Tricky part:
    //Checking if spell have cooldown in progress (cooldownrem)
    //Checking which spell have cooldown, in this case accio and expelliarmus as they make temporary debuff on dex or def
    //and that is based on 2 unique enemies: Bellatrix and Voldemort. if true reinstate original values
    //after this check: we reduce spell cooldown rem
    public void checkCooldown(List<AbstractSpell> spells, List<Character> enemies, int targetIndex){
        for (AbstractSpell spell : spells) {
            if (spell.getCooldownRem() > 0) {
                if (spell.getName().equals("Accio") && spell.getCooldownRem() == 2){
                    if ((enemies.get(targetIndex).getName().equals("Lord Voldemort") &&
                            enemies.get(targetIndex + 1).getName().equals("Bellatrix Lestrange")) ||
                            enemies.get(targetIndex).getName().equals("Bellatrix Lestrange")){
                        enemies.get(targetIndex).setDef(enemies.get(targetIndex).getDef() + 10);
                        System.out.println("The opponent has restored his stability and has recovered his defense !");
                    }
                } else if (spell.getName().equals("Expelliarmus") && spell.getCooldownRem() == 4){
                    if ((enemies.get(targetIndex).getName().equals("Lord Voldemort") &&
                            enemies.get(targetIndex + 1).getName().equals("Bellatrix Lestrange")) ||
                            enemies.get(targetIndex).getName().equals("Bellatrix Lestrange")) {
                        enemies.get(targetIndex).setDex(enemies.get(targetIndex).getDex() + spell.getNum());
                        System.out.println("The opponent has recovered his wand and can now attack ! Watch out !");
                    }
                }
                spell.setCooldownRem(spell.getCooldownRem() - 1);
            }
        }
    }

    //Switch case for UTL Spell usage based on enemy. Deeply developed (Should be considered exception)
    public int checkUtlSpellUsage(AbstractSpell spell, List<Character> enemies, SafeScanner sc){
        int targetIndex = game.chooseTarget(spell, enemies, sc);

        Character target = enemies.get(targetIndex);

        switch (target.getName()) {
            case "Troll":
                trollCase(target, spell);
                break;
            case "Basilisk":
                basiliskCase(target, spell);
                break;
            case "Dementor":
                dementorCase(spell);
                break;
            case "Lord Voldemort":
                voldemortCase(enemies, target, spell);
                break;
            case "Peter Pettigrew":
                pettigrewCase(enemies, target , spell);
                break;
            case "Bellatrix Lestrange":
                bellatrixCase(spell, target);
                break;
            default:
                break;
        }
        return targetIndex;
    }

    private void trollCase(Character target, AbstractSpell spell){
        if (spell.getName().equals("Wingardium Leviosa")) {
            target.setHealth(target.getHealth() - 50);
            System.out.println("You saw the boulder, you levitated it and you squished the troll !");
        }
    }

    private void basiliskCase(Character target, AbstractSpell spell){
        if (spell.getName().equals("Wingardium Leviosa")) {
            target.setHealth(target.getHealth() - 40);
            System.out.println("You saw a barrel, you levitated it and you threw it towards the basilisk !");
            System.out.println("You dealt 40 damage !");
        } else if (spell.getName().equals("Accio")) {
            target.setHealth(target.getHealth() / 3);
            System.out.println("You successfully removed one of his fangs ! You just removed 1/3rd of his health !");
        }
    }

    private void dementorCase(AbstractSpell spell){
        if (spell.getName().equals("Wingardium Leviosa") || spell.getName().equals("Accio")) {
            System.out.println("You tried to throw something at them, but they are not physical entities ! There's no effect !");
        }
    }

    private void voldemortCase(List<Character> enemies, Character target, AbstractSpell spell){
        if (spell.getName().equals("Accio")) {
            if (enemies.get(1).getName().equals("Peter Pettigrew")) {
                for (Character enemy : enemies) {
                    enemy.setHealth(0);
                }
                System.out.println("You successfully teleported out to safety !");
            } else {
                target.setDef(target.getDef() - 10);
                System.out.println("You summoned a rock, destabilizing him and showing his weak points !");
                System.out.println("You reduced his defense by 10 !");
            }
        } else if (spell.getName().equals("Wingardium Leviosa")) {
            target.setHealth(target.getHealth() - 100);
            System.out.println("You saw a big rook, you levitated it and you threw it towards Voldemort !");
            System.out.println("You dealt 100 damage !");
        } else if (spell.getName().equals("Expelliarmus")) {
            if (enemies.get(1).getName().equals("Bellatrix Lestrange")) {
                target.setDex(target.getDex() - spell.getNum());
                System.out.println("You successfully threw away Voldemort's wand and will miss his next move !");
                System.out.println("You reduced his dexterity by 20 !");
            }
        }
    }

    private void pettigrewCase(List<Character> enemies, Character target, AbstractSpell spell){
        if (spell.getName().equals("Accio")) {
            for (Character enemy : enemies) {
                enemy.setHealth(0);
            }
            System.out.println("You successfully teleported out to safety !");
        } else if (spell.getName().equals("Wingardium Leviosa")) {
            target.setHealth(target.getHealth() - 100);
            System.out.println("You saw a big rook, you levitated it and you threw it towards Pettigrew !");
            System.out.println("You dealt 100 damage !");
        }
    }

    private void bellatrixCase(AbstractSpell spell, Character target){
        if (spell.getName().equals("Expelliarmus")) {
            target.setDex(target.getDex() - spell.getNum());
            System.out.println("You successfully threw away Bellatrix's wand and will miss his next move !");
            System.out.println("You reduced his dexterity by 20 !");
        } else if (spell.getName().equals("Accio")) {
            target.setDef(target.getDef() - 10);
            System.out.println("You summoned a rock, destabilizing him and showing his weak points !");
            System.out.println("You reduced his defense by 10 !");
        } else if (spell.getName().equals("Wingardium Leviosa")) {
            target.setHealth(target.getHealth() - 100);
            System.out.println("You saw a big rook, you levitated it and you threw it towards Bellatrix !");
            System.out.println("You dealt 100 damage !");
        }
    }
}


