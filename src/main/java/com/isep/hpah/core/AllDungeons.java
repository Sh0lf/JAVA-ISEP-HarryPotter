package com.isep.hpah.core;

import com.isep.hpah.core.character.ListofEnemiesPerDungeon;
import com.isep.hpah.core.spells.Spell;

import java.util.ArrayList;
import java.util.List;

public class AllDungeons {
    public static List<Dungeon> allDungeon(){
        //ArrayList creation for better organisation
        List<Dungeon> allDungeon = new ArrayList<>();
        //Dungeons Creation
        allDungeon.add(new Dungeon("The Philosopher's Stone", "Un troll se trouve dans les toilettes à coté du Donjon ! Vous devez le vaincre d'une manière !", ListofEnemiesPerDungeon.dungeon1()));
        allDungeon.add(new Dungeon());
        allDungeon.add(new Dungeon());
        allDungeon.add(new Dungeon());
        allDungeon.add(new Dungeon());
        allDungeon.add(new Dungeon());
        allDungeon.add(new Dungeon());

        return allDungeon;

        //TODO: Make all the Instances for the dungeons
    }


}
