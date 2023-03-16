package com.isep.hpah.core.character;

import lombok.*;


public abstract class Character {
    @Setter @Getter
    private String name;
    @Setter @Getter
    private String type;
    @Setter @Getter
    private String desc;
    @Setter @Getter
    private int maxHealth;
    @Setter @Getter
    private int health;
    @Setter @Getter
    private double exp;
    @Setter @Getter
    private int att;
    @Setter
    private int def;
    @Setter @Getter
    private int dex;
    @Setter @Getter
    private boolean isDefending = false;

    public Character(String name, String type, String desc, int maxHealth, int health, double exp, int att, int def, int dex) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.maxHealth = maxHealth;
        this.health = health;
        this.exp = exp;
        this.att = att;
        this.def = def;
        this.dex = dex;
    }

    public int getDef() {
        if (isDefending) {
            return def * 2;
        } else {
            return def;
        }
    }

    public void normalAttack(Character enemy) {
        // implementation of normalAttack on enemy
        double hitChance = 0.7 + this.dex;
        double rand = Math.random();

        if (rand > hitChance) {
            System.out.println(this.name + " missed his attack !");
            return;
        }

        double damage = this.att - (enemy.getDef());
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

    /* Not used for the moment but can be interesting to look at
    public void defendedAttack(Character enemy) {
        // implementation of defended attack (means the one receiving the attack has defended)
        // Calculate chance of attacker hitting based on their dexterity
        double hitChance = 0.7 + this.dex;
        double rand = Math.random();
        if (rand > hitChance) {
            System.out.println(enemy.getName() + " dodged the attack");
            return;
        }

        // Calculate damage based on attacker's attack and defender's defense
        double damage = enemy.getAtt() - this.def;
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
    } */
}
