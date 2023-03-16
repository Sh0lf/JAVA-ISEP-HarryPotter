package com.isep.hpah.core.character;

import lombok.Builder;

public class Boss extends AbstractEnemy {
    @Builder
    Boss(String name, String desc, int health, double exp, int att, int def, int dex) {
        super(name, "Enemy: Boss", desc, health, health, exp, att, def, dex, 10);
    }

    public static Boss troll = Boss.builder()
        .name("Troll")
        .desc("Huge brutal but stupid creature")
        .health(100)
        .exp(50)
        .att(20)
        .def(5)
        .dex(2)
        .build();
    public static Boss basilisk = Boss.builder()
        .name("Basilisk")
        .desc("Huge poisoned snake, that can kill you instantly !")
        .health(200)
        .exp(50)
        .att(40)
        .def(10)
        .dex(5)
        .build();
}
