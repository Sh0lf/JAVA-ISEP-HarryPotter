package com.isep.hpah.core.spells;

import lombok.*;

public class ForbiddenSpell extends AbstractSpell{
    @Builder
    public ForbiddenSpell(String name, int num, String desc, int level, int corruption, int cooldown, int mana, String type) {
        super(name, num, desc, level, corruption, cooldown, 0, mana, type);
    }


    public static ForbiddenSpell avadaKedavra = ForbiddenSpell.builder()
        .name("Avada Kedavra")
        .num(10000)
        .desc("You ded")
        .level(1000)
        .corruption(99)
        .cooldown(6)
        .mana(200)
        .type("DMG")
        .build();
}
