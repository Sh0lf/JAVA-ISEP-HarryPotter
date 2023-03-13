package com.isep.hpah.core.spells;

import java.io.*;
import java.util.*;

public class Spell extends AbstractSpell{
    public Spell(String name, int num, String desc, int exp, int cooldown, int mana, String type) {
        super(name, num, desc, exp, 0, cooldown, mana, type);
    }

    public static Spell fireball = new Spell("Fireball", 40, "A powerful ball of pure fire and heat",
            0, 2, 20,"DMG");
    public static Spell lightningBolt = new Spell("Lightning Bolt", 50, "Strike your enemies with " +
            "lightning", 0, 3, 30, "DMG");
    public static Spell wingardiumLeviosa = new Spell("Wingardium Leviosa",0, "Levitate objects with " +
            "this spell", 0, 0, 0,"UTL");
    public static Spell accio = new Spell ("Accio", 0, "Bring an object towards you", 50,
            0, 0,"UTL");
    public static Spell expectoPatronum = new Spell("Expecto Patronum", 1000, "Protect yourself with " +
            "the sacred Guardian of the forest", 100, 3, 40,"DEF");

    @Override
    public void cast(Character target) {

    }
}
