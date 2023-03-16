package com.isep.hpah.core.spells;

import lombok.Builder;

import java.io.*;
import java.util.*;

public class Spell extends AbstractSpell{
    @Builder
    public Spell(String name, int num, String desc, int level, int cooldown, int mana, String type) {
        super(name, num, desc, level, 0, cooldown, 0, mana, type);
    }

    public static Spell fireball = Spell.builder()
            .name("Fireball")
            .num(40)
            .desc("A powerful ball of pure fire and heat")
            .level(0)
            .cooldown(2)
            .mana(20)
            .type("DMG")
            .build();

    public static Spell lightningBolt = Spell.builder()
            .name("Lightning Bolt")
            .num(50)
            .desc("Strike your enemies with lightning")
            .level(0)
            .cooldown(3)
            .mana(30)
            .type("DMG")
            .build();
    public static Spell wingardiumLeviosa = Spell.builder()
            .name("Wingardium Leviosa")
            .num(0)
            .desc("Levitate objects with this spell")
            .level(0)
            .cooldown(0)
            .mana(0)
            .type("UTL")
            .build();
    public static Spell accio = Spell.builder()
            .name("Accio")
            .num(0)
            .desc("Bring an object towards you")
            .level(2)
            .cooldown(0)
            .type("UTL")
            .build();
    public static Spell expectoPatronum = Spell.builder()
            .name("Expecto Patronum")
            .num(1000)
            .desc("Protect yourself with the sacred Guardian of the forest")
            .level(3)
            .cooldown(3)
            .mana(40)
            .type("DEF")
            .build();

}
