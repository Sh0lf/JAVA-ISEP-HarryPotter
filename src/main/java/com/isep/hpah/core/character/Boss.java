package com.isep.hpah.core.character;

public class Boss extends AbstractEnemy {
    public Boss(String name, String desc, int health, double exp, int att, int def, int dex) {
        super(name, "Enemy: Boss", desc, health, exp, att, def, dex, 10, true);
    }

    public static Boss troll = new Boss("Troll", "Huge brutal but stupid creature", 100, 50,
            10, 5, 2);
    public static Boss basilisk = new Boss("Basilisk", "Huge poisoned snake, that can kill you instantly !",
            200, 50, 20, 10, 5);
}
