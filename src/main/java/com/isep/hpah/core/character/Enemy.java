package com.isep.hpah.core.character;

import lombok.Builder;

public class Enemy extends AbstractEnemy {

    @Builder
    Enemy(String name, String desc, int health, double exp, int att, int def, int dex, int dangerLevel) {
        super(name, "Enemy: Mob", desc, health, health, exp, att, def, dex, dangerLevel);
    }

    public static Enemy dementor = Enemy.builder()
        .name("Dementor")
        .desc("One of the foulest Dark creatures")
        .health(100)
        .exp(25)
        .att(25)
        .def(5)
        .dex(5)
        .dangerLevel(3)
        .build();

    public static Enemy deatheater = Enemy.builder()
        .name("Death Eater")
        .desc("The most ardent followers of Voldemort")
        .health(150)
        .exp(25)
        .att(25)
        .def(5)
        .dex(5)
        .dangerLevel(3)
        .build();
}
