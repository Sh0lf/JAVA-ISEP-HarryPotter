package com.isep.hpah.core.character;

public class Boss extends AbstractEnemy {
    public Boss(String name, String desc, int health, double exp, int att, int def, int dex) {
        super(name, "Ennemi: Boss", desc, health, exp, att, def, dex, 10, true);
    }

    public static Boss troll = new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50,
            10, 5, 2);
    public static Boss basilic = new Boss("Basilic", "Un gros serpent empoisonné, qui vous tue d'un seul coup !.",
            200, 50, 20, 10, 5);
}
