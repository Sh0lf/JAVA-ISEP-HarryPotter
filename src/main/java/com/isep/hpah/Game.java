package com.isep.hpah;
import com.isep.hpah.core.*;
import com.isep.hpah.core.character.*;
import com.isep.hpah.core.potions.AllPotionsFunction;
import com.isep.hpah.core.spells.*;
import java.util.Scanner;
import static com.isep.hpah.core.Pet.*;
import static com.isep.hpah.core.SortingHat.*;

//for functions - the controller
public class Game {

    //function to clear console (technically skipping / doing empty lines)
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //function for separator
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //function to print a heading
    public static void printHeading(String title) {
        printSeparator(title.length());
        System.out.println(title);
        printSeparator(title.length());
    }

    public static void printHeader(String title){
        clearConsole();
        printSeparator(title.length());
        System.out.println(title);
        printSeparator(title.length());
    }

    public static Wizard playerCreation (String name, Wand wand, Pet pet, House house){
        Wizard player = new Wizard(name, "The player",200, 0, 20, 20,20,
                wand, pet, house, AllSpellsFunction.startingSpellList(), AllPotionsFunction.empty(), 0);

        return player;
    }

}
