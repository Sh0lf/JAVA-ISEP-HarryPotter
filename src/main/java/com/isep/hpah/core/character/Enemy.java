package com.isep.hpah.core.character;

public class Enemy extends AbstractEnemy {
    public Enemy(String name, String desc, int health, double exp, int att, int def, int dex, int dangerLevel) {
        super(name, "Ennemi: Mob", desc, health, exp, att, def, dex, dangerLevel, true);
    }

    public static Enemy detraqueur = new Enemy("Détraqueur", "Une créature des ténèbres",
            100, 25, 10, 5, 5, 3);

    public static Enemy mangemort = new Enemy("Mangemort", "Un serviteur de Voldemort et un acolyte de la magie noire",
            150, 25, 10, 5, 5, 3);
}
