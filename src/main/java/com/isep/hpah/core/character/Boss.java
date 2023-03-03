package com.isep.hpah.core.character;

public class Boss extends AbstractEnemy {
    public Boss(String name, String desc, int health, double exp, int att, int def, int dex) {
        super(name, "Ennemi: Boss", desc, health, exp, att, def, dex, 10, true);
    }
}
