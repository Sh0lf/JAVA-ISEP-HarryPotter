package com.isep.hpah.core.spells;

import com.isep.hpah.core.character.Character;
import com.isep.hpah.core.character.Wizard;
import lombok.*;

@Setter @Getter
public abstract class AbstractSpell {
    //defining what a spell have:
    private String name;
    private int num;
    private String desc;
    private int exp;
    private int corruption;
    private int cooldown;
    private int mana;
    private String type;

    public AbstractSpell(String name, int num, String desc, int exp, int corruption, int cooldown, int mana ,String type) {
        this.name = name;
        this.num = num;
        this.desc = desc;
        this.exp = exp;
        this.corruption = corruption;
        this.cooldown = cooldown;
        this.mana = mana;
        this.type = type;
    }

    // Method to cast a spell
    public void castSpell(AbstractSpell spell, Character player, Character enemy) {
        // Check if the wizard has enough mana to cast the spell
        if (spell.getMana() > this.mana) {
            System.out.println("Not enough mana to cast " + spell.getName() + "!");
            return;
        }

        // Check if the spell is an attacking spell
        if (spell.getType() == "DMG") {
            // Cast the attacking spell on the enemy
            int damage = spell.getNum();
            double hitChance = 0.7 + player.getDex();
            double rand = Math.random();
            if (rand > hitChance) {
                System.out.println(this.name + " missed the attack !");
                return;
            }
            int remainingHealth = enemy.getHealth() - damage;
            enemy.setHealth(remainingHealth);
            System.out.println(player.getName() + " hit " + enemy.getName() + " with " + spell.getName() + " for " + damage + " damage !");
            System.out.println(enemy.getName() + " has " + remainingHealth + " health points remaining.");
        }

        if (spell.getType() == "DEF") {

        }
    }
}
