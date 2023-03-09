package com.isep.hpah.core.spells;

import java.util.ArrayList;
import java.util.List;

import static com.isep.hpah.core.spells.Spell.*;
import static com.isep.hpah.core.spells.ForbiddenSpell.*;


public class AllSpellsFunction {
    public static List<AbstractSpell> voldemortSpells(){
        List<AbstractSpell> voldemortSpells = new ArrayList<>();
        //list of spells that Voldemort knows
        voldemortSpells.add(avadaKedavra);
        voldemortSpells.add(fireball);
        voldemortSpells.add(lightningBolt);
        return voldemortSpells;
    }

    public static List<AbstractSpell> pettigrowSpells(){
        List<AbstractSpell> pettigrowSpells = new ArrayList<>();
        //list of spells that Pettigrow knows
        pettigrowSpells.add(fireball);
        pettigrowSpells.add(lightningBolt);
        return pettigrowSpells;
    }

    public static List<AbstractSpell> ombrageSpells(){
        List<AbstractSpell> ombrageSpells = new ArrayList<>();
        //list of spells that Ombrage knows
        ombrageSpells.add(fireball);
        ombrageSpells.add(lightningBolt);

        return ombrageSpells;
    }

    public static List<AbstractSpell> startingSpellList(){
        //creating arrayList for new wizard
        List<AbstractSpell> knownSpells = new ArrayList<>();
        //Known Spells that you start with
        knownSpells.add(fireball);
        knownSpells.add(lightningBolt);
        knownSpells.add(wingardiumLeviosa);

        return knownSpells;
    }
}
