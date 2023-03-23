import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.constructors.*;
import com.isep.hpah.core.constructors.character.Wizard;
import com.isep.hpah.core.Setup;
import com.isep.hpah.core.constructors.spells.AbstractSpell;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Setup stp = new Setup();
        SafeScanner sc = new SafeScanner(System.in);
        SortingHat sortHat = new SortingHat();

        boolean verifInput = false;
        String name = "";
        House house;
        Pet pet;
        Wand wand;
        String wandName = "";
        int wandSize = 0;
        int res1 = 0;
        int res2 = 0;
        int finalRes = 0;

        sc.printHeading("Harry Potter RPG game, made by Yap Vincent");

        while (!verifInput) {
            try {
                System.out.println("WELCOME APPRENTICE ! What's your name ?");
                name = sc.getString();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid string, not an integer !");
                verifInput = false;
            }
        }

        verifInput = false;

        sc.printHeader("Welcome to Hogwarts, dear " + name + " ! Are you ready for a new adventure ?!");
        sc.pressEnterToContinue();

        sc.printHeading("Great ! Now let me put the mighty legendary Sorting Hat on your head, and let him do his " +
                "magic and allocate you to a house !");
        sc.pressEnterToContinue();

        sc.printHeading("Sorting Hat : Student, before I rashly allocate you to a house, let me ask you some questions " +
                ": \nYou come here with preferences and preconceptions - certain expectations. \n" +
                "[1] I can't wait to start classes. \n" +
                "[2] I can't wait to explore.");

        while(!verifInput) {
            try {
                int tempRes1 = sc.getInt();
                res1 = tempRes1 * 10;
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please select an answer by writing 1 or 2 !");
                verifInput = false;
            }
        }

        verifInput = false;

        sc.printHeading("Sorting Hat : I see... Hmm, I detect something in you. A certain sens of - hmm - " +
                "what is it ?\n" +
                "[1] Daring. \n" +
                "[2] Ambition.");

        while(!verifInput) {
            try {
                res2 = sc.getInt();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please select an answer by writing 1 or 2 !");
                verifInput = false;
            }
        }

        verifInput = false;

        finalRes = res1 + res2;
        house = sortHat.getResHouse(finalRes);

        pet = stp.generateRandomPet();
        sc.printHeading("Sorting Hat : You belong to " + house + " ! \nHere's your pet ! It's a small but " +
                "fierce " + pet + " !\nNow, get me out of him, I despise people of this house !");
        sc.pressEnterToContinue();

        sc.printHeader("Thank you Sorting Hat ! Don't mind him much, he can be mean but " +
                "he gets his job well done \nand ultimately he does care about the students ! \nNow let's get your wand ! \n" +
                "Of course you need one !");
        sc.pressEnterToContinue();

        while(!verifInput) {
            try {
                System.out.println("First of all, how would you call your wand?");
                wandName = sc.getString();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write valid content");
                verifInput = false;
            }
        }
        verifInput = false;

        while(!verifInput) {
            try {
                System.out.println("And what size in cm would be ideal for you ?");
                wandSize = sc.getInt();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write valid content");
                verifInput = false;
            }
        }

        wand = new Wand(wandName, wandSize, stp.generateRandomCore());

        sc.printHeading("Great ! I found you a wand that looks perfect to you ! It has a " + wand.getCore() +
                " under the name of " + wand.getName() + " and the size is exactly what you wanted : " + wand.getSize());

        sc.pressEnterToContinue();

        Wizard player = stp.playerCreation(name, wand, pet, house);

        sc.clearConsole();
        sc.printHeading("Now wizard, are you ready ?! You will start this story knowing a few spells:");

        for (AbstractSpell spell : player.getKnownSpells()) {
            // print out the name and description of the spell
            System.out.println(spell.getName() + " : " + spell.getDesc());
        }

        sc.printHeading("Now, watch out during your journey, there's forbidden spells. If you ever use them, " +
                "you would raise your corruption gauge. Do not go beyond 100 !\n\n" +
                "Your stats are:\nHealth: " + player.getHealth() + "\nAtt: " + player.getAtt() +
                "\nDef: " + player.getDef() + "\nDex: " + player.getDex() + "\nMana: " + player.getMana());

        if (player.getHouse().equals(House.GRYFFINDOR)){
            System.out.println("Since you're in Gryffindor, you have a defense bonus ! You start with 20 Def instead of 10 !");
        } else if (player.getHouse().equals(House.RAVENCLAW)){
            System.out.println("Since you're in Ravenclaw, you have a dexterity bonus ! You start with 15 Dex instead of 10 !");
        } else if (player.getHouse().equals(House.SLYTHERIN)){
            System.out.println("Since you're in Slytherin, all your spells are more efficient !");
        } else if (player.getHouse().equals(House.HUFFLEPUFF)){
            System.out.println("Since you're in Hufflepuff, all your potions are more efficient !");
        }

        sc.pressEnterToContinue();

        List<Dungeon> dungeons = stp.allDungeon();

        sc.printHeader(dungeons.get(0).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(0).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(0).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(1).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(1).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(1).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(2).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(2).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(2).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(3).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(3).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(3).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(4).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(4).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(4).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(5).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(5).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(5).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(6).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(6).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(6).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(7).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(7).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(7).getEnemies(), player);
        sc.pressEnterToContinue();
    }
}

