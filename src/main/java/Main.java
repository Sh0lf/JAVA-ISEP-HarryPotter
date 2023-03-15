import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.*;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.character.Wizard;
import com.isep.hpah.core.dungeon.Dungeon;
import com.isep.hpah.core.spells.AbstractSpell;
import com.isep.hpah.core.spells.Spell;

import java.util.List;
import java.util.Scanner;

import static com.isep.hpah.Game.*;
import static com.isep.hpah.core.Pet.*;
import static com.isep.hpah.core.SortingHat.*;
import static com.isep.hpah.core.dungeon.AllDungeonsFunction.allDungeon;

public class Main {

    public static void main(String[] args) {
        boolean verifInput = false;
        SafeScanner sc = new SafeScanner(System.in);
        String name = "";
        House house;
        Pet pet;
        Wand wand;
        String wandName = "";
        int wandSize = 0;
        int res1 = 0;
        int res2 = 0;
        int finalRes = 0;

        printHeading("Harry Potter RPG game, made by Yap Vincent");

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

        printHeader("Welcome to Hogwarts, dear " + name + " ! Are you ready for a new adventure ?!");
        sc.pressEnterToContinue();

        printHeading("Great ! Now let me put the mighty legendary Sorting Hat on your head, and let him do his " +
                "magic and allocate you to a house !");
        sc.pressEnterToContinue();

        printHeading("Sorting Hat : Student, before I rashly allocate you to a house, let me ask you some questions " +
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

        printHeading("Sorting Hat : I see... Hmm, I detect something in you. A certain sens of - hmm - " +
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
        house = getResHouse(finalRes);

        pet = generateRandomPet();
        printHeading("Sorting Hat : You belong to " + house + " ! \nHere's your pet ! It's a small but " +
                "fierce " + pet + " !\nNow, get me out of him, I despise people of this house !");
        sc.pressEnterToContinue();

        printHeader("Thank you Sorting Hat ! Don't mind him much, he can be mean but " +
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

        wand = new Wand(wandName, wandSize);

        printHeading("Great ! I found you a wand that looks perfect to you ! It has a " + wand.getCore() +
                " under the name of " + wand.getName() + " and the size is exactly what you wanted : " + wand.getSize());

        sc.pressEnterToContinue();

        Wizard player = playerCreation(name, wand, pet, house);

        clearConsole();
        printHeading("Now wizard, are you ready ?! You will start this story knowing a few spells:");

        for (AbstractSpell spell : player.getKnownSpells()) {
            // print out the name and description of the spell
            System.out.println(spell.getName() + " : " + spell.getDesc());
        }

        printHeading("Now, watch out during your journey, there's forbidden spells. If you ever use them, " +
                "you would raise your corruption gauge. Do not go beyond 100 !\n\n" +
                "Your stats are:\nHealth: " + player.getHealth() + "\nAtt: " + player.getAtt() +
                "\nDef: " + player.getDef() + "\nDex: " + player.getDex() + "\nMana: " + player.getMana() +
                "\n\nNow, enough talking, your first quest :");
        sc.pressEnterToContinue();

        List<Dungeon> dungeons = allDungeon();

        printHeader(dungeons.get(0).getName());
        sc.pressEnterToContinue();

        printHeading(dungeons.get(0).getDesc());
        sc.pressEnterToContinue();

        dungeonCombat(dungeons.get(0).getEnemies(), player);
    }
}

