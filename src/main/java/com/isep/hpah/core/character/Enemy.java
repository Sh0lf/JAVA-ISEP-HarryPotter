package com.isep.hpah.core.character;

public class Enemy extends AbstractEnemy {
    public Enemy(String name, String desc, int health, double exp, int att, int def, int dex, int dangerLevel) {
        super(name, "Ennemi: Mob", desc, health, exp, att, def, dex, dangerLevel, true);
    }
}
