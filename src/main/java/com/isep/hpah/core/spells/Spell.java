package com.isep.hpah.core.spells;

import java.io.*;
import java.util.*;

public class Spell extends AbstractSpell{
    public Spell(String name, int num, String desc, int exp, String type) {
        super(name, num, desc, exp, 0, type);
    }

    public static Spell fireball = new Spell("Fireball", 40, "Une puissante boule de feu ", 0, "DMG");
    public static Spell lightningBolt = new Spell("Lightning Bolt", 50, "Un éclair térrifiant", 0, "DMG");
    public static Spell wingardiumLeviosa = new Spell("Wingardium Leviosa",0, "Lévitez des objets avec ce sort", 0, "UTL");
    public static Spell accio = new Spell ("Accio", 0, "Attirez un objet vers vous", 50,"UTL");
    public static Spell expectoPatronum = new Spell("Expecto Patronum", 1000, "Protégez-vous avec le " +
            "gardien sacré", 100, "DEF");

    @Override
    public void cast(Character target) {

    }
}
