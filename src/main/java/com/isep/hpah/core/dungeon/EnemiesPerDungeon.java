package com.isep.hpah.core.dungeon;

import com.isep.hpah.core.House;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.Wand;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.character.Character;
import com.isep.hpah.core.potions.*;
import com.isep.hpah.core.spells.*;

import java.util.ArrayList;
import java.util.List;

public class EnemiesPerDungeon {
    public static List<Character> dungeon1(){
        //creating arrayList
        List<Character> dungeon1 = new ArrayList<>();
        //mob creation per dungeon
        dungeon1.add(new Boss("Troll", "Un gros monstre, violent, brutal mais stupide.", 100, 50,
                10, 5, 2));
        return dungeon1;
    }
    public static List<Character> dungeon2(){
        //creating arrayList
        List<Character> dungeon2 = new ArrayList<>();
        //mob creation per dungeon
        dungeon2.add(new Boss("Basilic", "Un gros serpent empoisonné, qui vous tue d'un seul coup !.",
                200, 50, 20, 10, 5));
        return dungeon2;
    }

    public static List<Character> dungeon3(){
        //creating arrayList
        List<Character> dungeon3 = new ArrayList<>();
        //mob creation per dungeon
        dungeon3.add(new Enemy("Détraqueur", "Une créature des ténèbres",
                100, 25, 10, 5, 5, 3));
        dungeon3.add(new Enemy("Détraqueur", "Une créature des ténèbres",
                100, 25, 10, 5, 5, 3));
        dungeon3.add(new Enemy("Détraqueur", "Une créature des ténèbres",
                100, 25, 10, 5, 5, 3));
        dungeon3.add(new Enemy("Détraqueur", "Une créature des ténèbres",
                100, 25, 10, 5, 5, 3));
        return dungeon3;
    }

    public static List<Character> dungeon4(){
        //creating arrayList
        List<Character> dungeon4 = new ArrayList<>();
        //mob creation per dungeon
        dungeon4.add(new Wizard("Voldemort", "\"Le Seigneur des Ténèbres\", l'étudiant le plus plus " +
                "brilliant de Poudlard qui a vrillé dans le chaos et qui fait utilisation de la magie noire sans se " +
                "soucier des conséquences !", 1000, 50, 50, 10, -50,
                new Wand("La baguette de Tom Jedusor", 33.75), Pet.generateRandomPet(), House.SLYTHERIN,
                AllSpellsFunction.voldemortSpells(), AllPotionsFunction.empty(), 0));
        dungeon4.add(new Wizard("Peter Pettigrow", "Le serviteur de Voldemort." +
                "A s'en méfier toutefois ! Il n'est pas serviteur de Voldemort pour rien !", 1000, 50,
                50, 10, -50, new Wand("Chataigner", 23), Pet.generateRandomPet(),
                House.SLYTHERIN,AllSpellsFunction.pettigrowSpells(),AllPotionsFunction.empty(),0));
        return dungeon4;
    }

    public static List<Character> dungeon5(){
        //creating arrayList
        List<Character> dungeon5 = new ArrayList<>();
        //mob creation per dungeon
        dungeon5.add(new Wizard("Dolores Ombrage",
                "Une professeure pervers et violente capable de torturer ses élèves physiquement !",
                500, 50, 25, 20, 0, new Wand("Umber", 34),Pet.generateRandomPet(),
                House.SLYTHERIN, AllSpellsFunction.ombrageSpells(),AllPotionsFunction.empty(), 0));
        return dungeon5;
    }

    public static List<Character> dungeon6(){
        //creating arrayList
        List<Character> dungeon6 = new ArrayList<>();
        //mob creation per dungeon
        dungeon6.add(new Enemy("Mangemort", "Un serviteur de Voldemort et un acolyte de la magie noire",
                150, 25, 10, 5, 5, 3));
        dungeon6.add(new Enemy("Mangemort", "Un serviteur de Voldemort et un acolyte de la magie noire",
                150, 25, 10, 5, 5, 3));
        dungeon6.add(new Enemy("Mangemort", "Un serviteur de Voldemort et un acolyte de la magie noire",
                150, 25, 10, 5, 5, 3));
        dungeon6.add(new Enemy("Mangemort", "Un serviteur de Voldemort et un acolyte de la magie noire",
                150, 25, 10, 5, 5, 3));
        return dungeon6;
    }

    public static List<Character> dungeon7(){
        //creating arrayList
        List<Character> dungeon7 = new ArrayList<>();
        //mob creation per dungeon
        dungeon7.add(new Wizard("Voldemort", "\"Le Seigneur des Ténèbres\", l'étudiant le plus plus " +
                "brilliant de Poudlard qui a vrillé dans le chaos et qui fait utilisation de la magie noire sans se " +
                "soucier des conséquences !", 1000, 50, 50, 10, -50,
                new Wand("La baguette de Tom Jedusor", 33.75), Pet.generateRandomPet(), House.SLYTHERIN,
                AllSpellsFunction.voldemortSpells(), AllPotionsFunction.empty(), 0));
        dungeon7.add(new Wizard("Bellatrix Lestrange", "Le bras droit de Voldemort, fidèle depuis les " +
                "2 dernières guerres", 1000, 50, 50, 10, -50,
                new Wand("Noyer", 32), Pet.generateRandomPet(), House.SLYTHERIN,
                AllSpellsFunction.voldemortSpells(), AllPotionsFunction.empty(), 0));
        return dungeon7;
    }

    //TODO: Make all the dungeons and the mobs !
}
