package com.isep.hpah;

import com.isep.hpah.controller.Game;
import com.isep.hpah.model.constructors.*;
import com.isep.hpah.model.constructors.character.Wizard;
import com.isep.hpah.controller.*;
import com.isep.hpah.views.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Setup stp = new Setup();
        SafeScanner sc = new SafeScanner(System.in);
        SortingHat sortHat = new SortingHat();
        SimpleOutput out = new SimpleOutput();
        WelcomeOutput welcome = new WelcomeOutput();
        House house;
        Pet pet;
        Wand wand;
        int res1;
        int res2;
        int finalRes;

        String name = welcome.name(sc);

        welcome.sortingHatIntro(name);

        res1 = welcome.sortingHatQuestion1(sc);

        res2 = welcome.sortingHatQuestion2(sc);

        finalRes = res1 + res2;

        house = sortHat.getResHouse(finalRes);

        pet = stp.generateRandomPet();

        welcome.sortingHatResponse(pet, house);

        wand = welcome.wand(sc);

        welcome.showWand(wand);

        Wizard player = stp.playerCreation(name, wand, pet, house);

        welcome.showPlayer(player);

        out.pressEnterToContinue();

        List<Dungeon> dungeons = stp.allDungeon();

        out.printHeader(dungeons.get(0).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(0).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(0).getEnemies(), player);
        out.pressEnterToContinue();

        out.printHeader(dungeons.get(1).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(1).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(1).getEnemies(), player);
        out.pressEnterToContinue();

        out.printHeader(dungeons.get(2).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(2).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(2).getEnemies(), player);
        out.pressEnterToContinue();

        out.printHeader(dungeons.get(3).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(3).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(3).getEnemies(), player);
        out.pressEnterToContinue();

        out.printHeader(dungeons.get(4).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(4).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(4).getEnemies(), player);
        out.pressEnterToContinue();

        out.printHeader(dungeons.get(5).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(5).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(5).getEnemies(), player);
        out.pressEnterToContinue();

        out.printHeader(dungeons.get(6).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(6).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(6).getEnemies(), player);
        out.pressEnterToContinue();

        out.printHeader(dungeons.get(7).getName());
        out.pressEnterToContinue();

        out.printHeading(dungeons.get(7).getDesc());
        out.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(7).getEnemies(), player);
    }
}

