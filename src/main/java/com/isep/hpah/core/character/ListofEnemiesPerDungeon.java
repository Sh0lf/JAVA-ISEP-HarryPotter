package com.isep.hpah.core.character;

import com.isep.hpah.core.spells.Spell;

import java.util.ArrayList;
import java.util.List;

public class ListofEnemiesPerDungeon {
    public static List<AbstractEnemy> dungeon1(){
        //creating arrayList
        List<AbstractEnemy> dungeon1 = new ArrayList<>();
        //mob creation per dungeon
        dungeon1.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50, 10, 5, 5));
        return dungeon1;
    }
    public static List<AbstractEnemy> dungeon2(){
        //creating arrayList
        List<AbstractEnemy> dungeon2 = new ArrayList<>();
        //mob creation per dungeon
        dungeon2.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50, 10, 5, 5));
        return dungeon2;
    }

    public static List<AbstractEnemy> dungeon3(){
        //creating arrayList
        List<AbstractEnemy> dungeon3 = new ArrayList<>();
        //mob creation per dungeon
        dungeon3.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50, 10, 5, 5));
        return dungeon3;
    }

    public static List<AbstractEnemy> dungeon4(){
        //creating arrayList
        List<AbstractEnemy> dungeon4 = new ArrayList<>();
        //mob creation per dungeon
        dungeon4.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50, 10, 5, 5));
        return dungeon4;
    }

    public static List<AbstractEnemy> dungeon5(){
        //creating arrayList
        List<AbstractEnemy> dungeon5 = new ArrayList<>();
        //mob creation per dungeon
        dungeon5.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50, 10, 5, 5));
        return dungeon5;
    }

    public static List<AbstractEnemy> dungeon6(){
        //creating arrayList
        List<AbstractEnemy> dungeon6 = new ArrayList<>();
        //mob creation per dungeon
        dungeon6.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50, 10, 5, 5));
        return dungeon6;
    }

    public static List<AbstractEnemy> dungeon7(){
        //creating arrayList
        List<AbstractEnemy> dungeon7 = new ArrayList<>();
        //mob creation per dungeon
        dungeon7.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50, 10, 5, 5));
        return dungeon7;
    }

    //TODO: Make all the dungeons and the mobs !
}
