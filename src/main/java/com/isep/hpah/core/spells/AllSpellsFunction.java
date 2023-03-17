package com.isep.hpah.core.spells;

import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.character.Character;
import com.isep.hpah.core.character.Wizard;

import java.util.ArrayList;
import java.util.List;

import static com.isep.hpah.core.spells.Spell.*;
import static com.isep.hpah.core.spells.ForbiddenSpell.*;


public class AllSpellsFunction {
    public static List<AbstractSpell> voldemortSpells(){
        List<AbstractSpell> voldemortSpells = new ArrayList<>();
        //list of spells that Voldemort knows
        voldemortSpells.add(avadaKedavra);
        voldemortSpells.add(fireball);
        voldemortSpells.add(lightningBolt);
        return voldemortSpells;
    }

    public static List<AbstractSpell> pettigrowSpells(){
        List<AbstractSpell> pettigrowSpells = new ArrayList<>();
        //list of spells that Pettigrow knows
        pettigrowSpells.add(fireball);
        pettigrowSpells.add(lightningBolt);
        return pettigrowSpells;
    }

    public static List<AbstractSpell> ombrageSpells(){
        List<AbstractSpell> ombrageSpells = new ArrayList<>();
        //list of spells that Ombrage knows
        ombrageSpells.add(fireball);
        ombrageSpells.add(lightningBolt);

        return ombrageSpells;
    }

    public static List<AbstractSpell> startingSpellList(){
        //creating arrayList for new wizard
        List<AbstractSpell> knownSpells = new ArrayList<>();
        //Known Spells that you start with
        knownSpells.add(fireball);
        knownSpells.add(lightningBolt);
        knownSpells.add(wingardiumLeviosa);

        return knownSpells;
    }

    // Method to cast a spell
    public static void castDmgSpell(AbstractSpell spell, Character player, Character enemy) {
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

    public static void castDefSpell(AbstractSpell spell, Wizard player){
        int val = spell.getNum();
        player.setDefSpell(val);
        player.setDef(player.getDefSpell());
        System.out.println("You gained " + val + " defense for this turn and have now a total of " + player.getDef() + " defense !");
    }

    public static void checkCooldown(List<AbstractSpell> spells){
        for (AbstractSpell spell : spells) {
            if (spell.getCooldownRem() > 0) {
                spell.setCooldown(spell.getCooldownRem() - 1);
            }
        }
    }

    public static void checkUtlSpellUsage(AbstractSpell spell, Wizard player, List<Character> enemies, SafeScanner sc){
        //TODO : MAKE THE CHECK UTL SPELL USAGE SWITCH CASE BASED ON DUNGEON / ENEMY
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
        Character target = enemies.get(targetIndex);
        castUtlSpell(spell, player, target);

        spell.setCooldownRem(spell.getCooldown());
    }
}
