package com.isep.hpah.core.character;

public class Enemy extends AbstractEnemy {
    public Enemy(String name, String desc, int health, double exp, int att, int def, int dex, int dangerLevel) {
        super(name, "Enemy: Mob", desc, health, exp, att, def, dex, dangerLevel, true);
    }

    public static Enemy dementor = new Enemy("Dementor", "One of the foulest Dark creatures",
            100, 25, 10, 5, 5, 3);

    public static Enemy deatheater = new Enemy("Death Eater", "The most ardent followers of Voldemort",
            150, 25, 10, 5, 5, 3);
}
