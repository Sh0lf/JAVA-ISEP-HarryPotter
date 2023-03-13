package com.isep.hpah.core.character;

import lombok.*;

@Setter @Getter
public abstract class Character {
    private String name;
    private String type;
    private String desc;
    private int health;
    private double exp;
    private int att;
    private int def;
    private int dex;

    public Character(String name, String type, String desc, int health, double exp, int att, int def, int dex) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.health = health;
        this.exp = exp;
        this.att = att;
        this.def = def;
        this.dex = dex;
    }

    public void normalAttack(Character enemy) {
        // implementation of normalAttack on enemy
        double hitChance = 0.7 + this.dex;
        double rand = Math.random();

        if (rand > hitChance) {
            System.out.println(this.name + " missed his attack !");
            return;
        }

        double damage = this.att - (enemy.getDef() / 2);
        if (damage <= 0) {
            System.out.println(this.name + " did no damage to " + enemy.getName() + "!");
            return;
        }

        // Reduce enemy's health by damage
        int remainingHealth = enemy.getHealth() - (int) damage;
        enemy.setHealth(remainingHealth);

        // Print out attack details
        System.out.println(this.name + " hit " + enemy.getName() + " for " + (int) damage + " damage !");
        System.out.println(enemy.getName() + " has " + remainingHealth + " health left.");
    }

    public void defend(Character enemy) {
        // implementation of defend
        // Calculate chance of attacker hitting based on their dexterity
        double hitChance = 0.7 + enemy.getDex();
        double rand = Math.random();
        if (rand > hitChance) {
            System.out.println(this.name + " dodged the attack");
            return;
        }

        // Calculate damage based on attacker's attack and defender's defense
        double damage = enemy.getAtt() - (2 * this.def);
        if (damage <= 0) {
            System.out.println(this.name + " blocked the attack without a single problem !");
            return;
        }

        // Reduce defender's health by damage
        int remainingHealth = this.health - (int) damage;
        this.health = remainingHealth;

        // Print out defense details
        System.out.println(this.name + " has defended, but still took " + (int) damage + " damage !");
        System.out.println(this.name + " has " + remainingHealth + " health remaining.");
    }
}
