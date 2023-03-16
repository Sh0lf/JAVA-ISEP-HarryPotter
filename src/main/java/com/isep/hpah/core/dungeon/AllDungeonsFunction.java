package com.isep.hpah.core.dungeon;

import com.isep.hpah.core.character.Character;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

import static com.isep.hpah.core.character.Boss.*;
import static com.isep.hpah.core.character.Enemy.*;
import static com.isep.hpah.core.character.Wizard.*;

@Setter @Getter
public class AllDungeonsFunction {

    public static List<Character> dungeon1(){
        //creating arrayList
        List<Character> dungeon1 = new ArrayList<>();
        //mob creation per dungeon
        dungeon1.add(troll);
        return dungeon1;
    }

    public static List<Character> dungeon2(){
        //creating arrayList
        List<Character> dungeon2 = new ArrayList<>();
        //mob creation per dungeon
        dungeon2.add(basilisk);
        return dungeon2;
    }

    public static List<Character> dungeon3(){
        //creating arrayList
        List<Character> dungeon3 = new ArrayList<>();
        //mob creation per dungeon
        dungeon3.add(dementor);
        dungeon3.add(dementor);
        dungeon3.add(dementor);
        dungeon3.add(dementor);

        return dungeon3;
    }

    public static List<Character> dungeon4(){
        //creating arrayList
        List<Character> dungeon4 = new ArrayList<>();
        //mob creation per dungeon
        dungeon4.add(voldemort);
        dungeon4.add(pettigrow);
        return dungeon4;
    }

    public static List<Character> dungeon5(){
        //creating arrayList
        List<Character> dungeon5 = new ArrayList<>();
        //mob creation per dungeon
        dungeon5.add(umbridge);
        return dungeon5;
    }

    public static List<Character> dungeon6(){
        //creating arrayList
        List<Character> dungeon6 = new ArrayList<>();
        //mob creation per dungeon
        dungeon6.add(deatheater);
        dungeon6.add(deatheater);
        dungeon6.add(deatheater);
        dungeon6.add(deatheater);

        return dungeon6;
    }

    public static List<Character> dungeon7(){
        //creating arrayList
        List<Character> dungeon7 = new ArrayList<>();
        //mob creation per dungeon
        dungeon7.add(voldemort);
        dungeon7.add(bellatrix);
        return dungeon7;
    }

    public static Dungeon philosopherStone = Dungeon.builder()
            .name("The Philosopher's Stone")
            .desc("There's a troll right next to the toilets of the dungeon ! Beast him in a way or another !")
            .enemies(dungeon1())
            .build();
    public static Dungeon chamberofSecrets = Dungeon.builder()
            .name("The Chamber of Secrets")
            .desc("You find yourself right in front of the mighty terrifying Basilisk ! Pull out one of these fangs to destroy Tom Riddle's journal ! Or maybe... there's another way...")
            .enemies(dungeon2())
            .build();
    public static Dungeon prisonnerofAzkaban = Dungeon.builder()
            .name("The Prisonner of Azkaban")
            .desc("The dementors are on the loose! To defeat them, learn a spell by leveling up and use it against the dementors!")
            .enemies(dungeon3())
            .build();
    public static Dungeon gobletofFire = Dungeon.builder()
            .name("The Goblet of Fire")
            .desc("You have won the Triwizard Tournament... and the right to die. You find Voldemort and Peter Pettigrew! Run away anyway!")
            .enemies(dungeon4())
            .build();
    public static Dungeon orderofPhoenix = Dungeon.builder()
            .name("The Order of Phoenix")
            .desc("It's time for the OWL (Universal Certificate of Elementary Witchcraft)! Dolores Umbridge is watching over you. Your goal is to distract her until the fireworks are ready to go.")
            .enemies(dungeon5())
            .build();
    public static Dungeon halfBloodedPrince = Dungeon.builder()
            .name("The Half-Blood Prince")
            .desc("The Death Eaters attack Hogwarts. Do you want to attack them from the front or do you plan to make another decision?")
            .enemies(dungeon6())
            .build();
    public static Dungeon deathlyHallows = Dungeon.builder()
            .name("The Deathly Hallows")
            .desc("You have to start attacking the problem at the source. You are facing Voldemort and Bellatrix Lestrange! Pay attention to Avada Kedavra!")
            .enemies(dungeon7())
            .build();

    public static List<Dungeon> allDungeon(){
        //ArrayList creation for better organisation
        List<Dungeon> allDungeon = new ArrayList<>();
        //Dungeons adding to list
        allDungeon.add(philosopherStone);
        allDungeon.add(chamberofSecrets);
        allDungeon.add(prisonnerofAzkaban);
        allDungeon.add(gobletofFire);
        allDungeon.add(orderofPhoenix);
        allDungeon.add(halfBloodedPrince);
        allDungeon.add(deathlyHallows);

        return allDungeon;
    }


}
