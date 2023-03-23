package com.isep.hpah.core.constructors.character;

import com.isep.hpah.core.constructors.*;
import com.isep.hpah.core.constructors.spells.*;
import lombok.*;
import java.util.List;

@Setter @Getter
public class Wizard extends Character {
    private int level;
    private Pet pet;
    private Wand wand;
    private House house;
    private List<AbstractSpell> knownSpells;
    private List<Potion> potionsOwned;
    private int corruptionGauge;
    private int maxMana;
    private int mana;
    private int defSpell;
    private int potionDefBoost;
    private int potionDexBoost;

    @Builder
    public Wizard(String name, String desc, int health, int exp, int att, int def, int dex, int level, Wand wand, Pet pet,
                  House house, List<AbstractSpell> knownSpells, List<Potion> potionsOwned, int corruptionGauge,
                  int maxMana, int mana) {
        super(name, "Wizard", desc, health, health, exp, att, def, dex);
        this.level = level;
        this.wand = wand;
        this.pet = pet;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potionsOwned = potionsOwned;
        this.corruptionGauge = corruptionGauge;
        this.maxMana = maxMana;
        this.mana = mana;
        this.defSpell = 0;
        this.potionDefBoost = 0;
        this.potionDexBoost = 0;
    }

    public void manaReduce(AbstractSpell spell, Wizard player) {
        player.setMana(player.getMana() - spell.getMana());
    }

    // Method to cast a dmg spell, deal dmg
    public void castDmgSpell(AbstractSpell spell, Wizard player ,Character enemy) {
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
            System.out.println("Since " + player.getName() + " is a Slytherin, you're more efficient with your spells !");
        }

        int remainingHealth = enemy.getHealth() - (int) damage;
        enemy.setHealth(remainingHealth);
        System.out.println(player.getName() + " hit " + enemy.getName() + " with " + spell.getName() + " for " + damage + " damage !");
        System.out.println(enemy.getName() + " has " + remainingHealth + " health points remaining.");
    }

    // Method for DEF spell, comparison based on a Wizard variable DefSpell.
    public void castDefSpell(AbstractSpell spell, Wizard player){
        double val = spell.getNum();

        if (this.house.equals(House.SLYTHERIN)){
            val = val * 1.2;
            System.out.println("Since you're a Slytherin, you're more efficient with your spells !");
        }
        player.setDefSpell((int) val);
        player.setDef(player.getDefSpell());
        System.out.println("You gained " + val + " defense for this turn and have now a total of " + player.getDef() + " defense !");
    }
}
