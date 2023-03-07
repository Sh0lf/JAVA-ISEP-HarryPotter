package com.isep.hpah.core.spells;

import java.util.ArrayList;
import java.util.List;

public class AllSpellsFunction {
    public static List<AbstractSpell> voldemortSpells(){
        List<AbstractSpell> voldemortSpells = new ArrayList<>();
        voldemortSpells.add(new ForbiddenSpell("Avada Kedavra", 10000,
                "Le fameux sort qui vous tue d'un seul coup", 1000, 99, "DMG"));
        voldemortSpells.add(new Spell("Fireball", 15, "Une puissante boule de feu ", 0, "DMG"));
        voldemortSpells.add(new Spell("lightning Bolt", 20, "Un éclair térrifiant", 0, "DMG"));
        return voldemortSpells;
    }

    public static List<AbstractSpell> pettigrowSpells(){
        List<AbstractSpell> pettigrowSpells = new ArrayList<>();
        pettigrowSpells.add(new Spell("Fireball", 15, "Une puissante boule de feu ", 0, "DMG"));
        pettigrowSpells.add(new Spell("lightning Bolt", 20, "Un éclair térrifiant", 0, "DMG"));
        return pettigrowSpells;
    }

    public static List<AbstractSpell> ombrageSpells(){
        List<AbstractSpell> ombrageSpells = new ArrayList<>();
        ombrageSpells.add(new Spell("Fireball", 15, "Une puissante boule de feu ", 0, "DMG"));
        ombrageSpells.add(new Spell("lightning Bolt", 20, "Un éclair térrifiant", 0, "DMG"));
        return ombrageSpells;
    }
}
