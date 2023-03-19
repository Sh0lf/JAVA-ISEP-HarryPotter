package com.isep.hpah.core.character;

import lombok.Builder;

public class Boss extends AbstractEnemy {
    @Builder
    Boss(String name, String desc, int health, double exp, int att, int def, int dex) {
        super(name, "Enemy: Boss", desc, health, health, exp, att, def, dex, 10);
    }
}
