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
        dungeon2.add(basilic);
        return dungeon2;
    }

    public static List<Character> dungeon3(){
        //creating arrayList
        List<Character> dungeon3 = new ArrayList<>();
        //mob creation per dungeon
        dungeon3.add(detraqueur);
        dungeon3.add(detraqueur);
        dungeon3.add(detraqueur);
        dungeon3.add(detraqueur);

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
        dungeon5.add(ombrage);
        return dungeon5;
    }

    public static List<Character> dungeon6(){
        //creating arrayList
        List<Character> dungeon6 = new ArrayList<>();
        //mob creation per dungeon
        dungeon6.add(mangemort);
        dungeon6.add(mangemort);
        dungeon6.add(mangemort);
        dungeon6.add(mangemort);

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

    public static Dungeon philosopherStone = new Dungeon("The Philosopher's Stone",
            "Un troll se trouve dans les toilettes à coté du Donjon ! " +
                    "Vous devez le vaincre d'une manière !", dungeon1());
    public static Dungeon chamberofSecrets = new Dungeon("The Chamber of Secrets",
            "Vous êtes face au terrible basilic ! Arrachez un de ces crocs pour détruire le journal de Tom Jedusor ! "
                    + "Ou sinon, il y a une autre manière de le vaincre...", dungeon2());
    public static Dungeon prisonnerofAzkaban = new Dungeon("The Prisonner of Azkaban",
            "Les détraqueurs sont en libertés ! Pour les vaincre, apprenez un sort en passant au prochain " +
                    "niveau et utilisez le contre les détraqueurs !", dungeon3());
    public static Dungeon gobletofFire = new Dungeon("The Goblet of Fire",
            "Vous avez remporté le Tournoi des Trois Sorciers... et le droit de mourir. " +
                    "Vous trouvez Voldemort et Peter Pettigrew ! Fuyez de n'importe quelle manière !", dungeon4());
    public static Dungeon orderofPhoenix = new Dungeon("The Order of Phoenix",
            "C'est l'heure du BUSE (Brevet Universel de Sorcellerie Élémentaire) ! " +
                    "Dolores Ombrage veille sur vous. Votre objectif est de la distraire le temps " +
                    "que les feux d’artifice soient prêts à être utilisés.", dungeon5());
    public static Dungeon halfBloodedPrince = new Dungeon("The Half-Blood Prince",
            "Les Mangemorts attaquent Poudlard. Vous voulez les attaquer de face ou vous " +
                    "comptez faire une autre décision ?", dungeon6());
    public static Dungeon deathlyHallows = new Dungeon("The Deathly Hallows",
            "Il faut commencer à attaquer le problème à la source. " +
                    "Vous êtes face à Voldemort et à Bellatrix Lestrange ! " +
                    "Faites attention à Avada Kedavra !", dungeon7());

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
