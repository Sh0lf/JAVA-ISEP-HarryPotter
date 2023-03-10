import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.House;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.SortingHat;
import com.isep.hpah.core.Wand;

import java.util.Scanner;

import static com.isep.hpah.Game.*;
import static com.isep.hpah.core.Pet.*;
import static com.isep.hpah.core.SortingHat.*;

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

        System.out.println("Great ! Now let me put the mighty legendary Sorting Hat on your head, and let him do his " +
                "magic and allocate you to a house !");
        sc.pressEnterToContinue();

        printHeading("Sorting Hat : Student, before I rashly allocate you to a house, let me ask you some questions " +
                ": You come here with preferences and preconceptions - certain expectations. \n" +
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
                "[2] Ambition");

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
        printHeading("Sorting Hat : You belong to " + house + " ! Here's your pet ! It's a small but " +
                "fierce " + pet + " !\n Now, get me out of him, I despise people of this house !");
        sc.pressEnterToContinue();

        printHeader("Thank you Sorting Hat ! Don't mind him much, he can be mean but " +
                "he gets his job well done and ultimately he does care about the students ! Now let's get you wand ! " +
                "Of course you need one ! \n" +
                "First of all, how would you call your wand?");

        while(!verifInput) {
            try {
                wandName = sc.getString();
                System.out.println("And what size in cm would be ideal for you ?");
                wandSize = sc.getInt();
                verifInput = true;
            } catch (Exception e) {
                System.out.println("Please write an integer only !");
                verifInput = false;
            }
        }

        wand = new Wand(wandName, wandSize);

        printHeading("Great ! I found you a wand that looks perfect to you ! It has a " + wand.getCore() +
                " under the name of " + wand.getName() + " and the size is exactly what you wanted : " + wand.getSize());
        sc.pressEnterToContinue();

        playerCreation(name, wand, pet, house);

        printHeading("Now wizard, are you ready ?! You will start this story knowing a few spells: \n" +
                "Fireball: A damaging spell \n" +
                "Lightning Bolt: Another damaging spell, better than fireball but have a higher cooldown \n" +
                "And Wingardium Leviosa: Levitate objects with this spell\n\n" +
                "now, watch out during your journey, there's forbidden spells. If you ever use them, " +
                "you would raise your corruption gauge. Do not go beyond 100 !\n\n" +
                "Now, enough talking :");

        //TODO: ALL DESC IN ENGLISH (I suppose)

    }
}

