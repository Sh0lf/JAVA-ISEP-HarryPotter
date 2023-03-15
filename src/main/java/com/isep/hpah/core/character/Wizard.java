package com.isep.hpah.core.character;
import com.isep.hpah.core.*;
import com.isep.hpah.core.potions.AllPotionsFunction;
import com.isep.hpah.core.potions.Potion;
import com.isep.hpah.core.spells.*;
import lombok.*;
import java.util.List;

@Setter @Getter
public class Wizard extends Character {
    private int level;
    private Pet pet;
    private Wand wand;
    private House house;
    private List<AbstractSpell> knownSpells;
    private List<Potion> potionsOwned;
    private int corruptionGauge;
    private int maxMana;
    private int mana;

    public Wizard(String name, String desc, int health, int exp, int att, int def, int dex, int level, Wand wand, Pet pet,
                  House house, List<AbstractSpell> knownSpells, List<Potion> potionsOwned, int corruptionGauge,
                  int maxMana, int mana) {
        super(name, "Wizard", desc, health, health, exp, att, def, dex);
        this.level = level;
        this.wand = wand;
        this.pet = Pet.generateRandomPet();
        this.house = house;
        this.knownSpells = knownSpells;
        this.potionsOwned = potionsOwned;
        this.corruptionGauge = corruptionGauge;
        this.maxMana = maxMana;
        this.mana = mana;
    }

    public static void checkLevelUp(Wizard player) {
        if (player.getExp() >= 50) {
            player.setLevel(player.getLevel() + 1);
            player.setExp(player.getExp()- 50);
            System.out.println("\nCongratulations! You have leveled up to level " + player.getLevel() + ".");

            player.setMaxHealth(player.getMaxHealth() + 20);
            player.setHealth(player.getMaxHealth());
            player.setMaxMana(player.getMana() + 20);
            player.setMana(player.getMaxMana());

            player.setAtt(player.getAtt() + 5);
            player.setDef(player.getDef() + 5);
            player.setDex(player.getDex() + 2);

            System.out.println("Your new stats: \nAtt: " + player.getAtt() + "\nDef: " +
                    player.getDef() + "\nDex: " + player.getDex());

        }
    }

    public static Wizard voldemort = new Wizard("Lord Voldemort", "\"You - Know - Who\", \"He Who Must " +
            "Not Be Named\", or \"the Dark Lord\", one of the brightest Hogwarts have ever seen, but he's obsessed with " +
            "blood purity and he won't stop at anything to achieve it !", 1000, 50, 50, 10, -50,
            100, new Wand("Tom Jedusor's wand", 33.75), Pet.generateRandomPet(), House.SLYTHERIN,
            AllSpellsFunction.voldemortSpells(), AllPotionsFunction.empty(), 0, 300, 300);

    public static Wizard pettigrow = new Wizard("Peter Pettigrew", "Voldemort's best spy." +
            "An extremely smart individual, so beware !", 1000, 50,
            50, 10, -50, 50, new Wand("Chestnut", 23), Pet.generateRandomPet(),
            House.GRYFFINDOR, AllSpellsFunction.pettigrowSpells(), AllPotionsFunction.empty(),0, 200, 200);

    public static Wizard umbridge = new Wizard("Dolores Umbridge",
            "An extremely cruel professor that's even capable of punishing violently and physically students !",
            500, 50, 25, 20, 0, 50, new Wand("Umber", 34),Pet.generateRandomPet(),
            House.SLYTHERIN, AllSpellsFunction.ombrageSpells(),AllPotionsFunction.empty(), 0, 200, 200);

    public static Wizard bellatrix = new Wizard("Bellatrix Lestrange", "Voldemort's right hand servant, " +
            "stronger than you think", 1000, 50, 50, 10, -50, 50,
            new Wand("Walnut", 32), Pet.generateRandomPet(), House.SLYTHERIN,
            AllSpellsFunction.voldemortSpells(), AllPotionsFunction.empty(), 0, 200, 200);
}
