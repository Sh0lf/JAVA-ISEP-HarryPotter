package com.isep.hpah.core.spells;
import java.util.ArrayList;
import java.util.List;

public class StartingSpellList {
    public static List<AbstractSpell> startingSpellList(){
        //creating arrayList for new wizard
        List<AbstractSpell> knownSpells = new ArrayList<>();

        //Known Spells that you start with
        knownSpells.add(new Spell("Fireball", 15, "Une puissante boule de feu ", 0, "DMG"));
        knownSpells.add(new Spell("lightning Bolt", 20, "Un éclair térrifiant", 0, "DMG"));
        knownSpells.add(new Spell("Fireball", 15, "Une boule de feu puissante", 0, "DMG"));
        knownSpells.add(new Spell("Fireball", 15, "Une boule de feu puissante", 0, "DMG"));
        knownSpells.add(new Spell("Fireball", 15, "Une boule de feu puissante", 0, "DMG"));

        return knownSpells;
    }
}
