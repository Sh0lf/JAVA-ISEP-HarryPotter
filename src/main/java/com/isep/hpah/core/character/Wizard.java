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


    @Builder
    Wizard(String name, String desc, int health, int exp, int att, int def, int dex, int level, Wand wand, Pet pet,
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

    public static Wizard voldemort = Wizard.builder()
        .name("Lord Voldemort")
        .desc("\"You - Know - Who\", \"He Who Must " +
        "Not Be Named\", or \"the Dark Lord\", one of the brightest Hogwarts have ever seen, but he's obsessed with " +
        "blood purity and he won't stop at anything to achieve it !")
        .health(1000)
        .exp(50)
        .att(50)
        .def(10)
        .dex(-50)
        .level(100)
        .wand(new Wand("Tom Jedusor's wand", 33.75))
        .pet(Pet.generateRandomPet())
        .house(House.SLYTHERIN)
        .knownSpells(AllSpellsFunction.voldemortSpells())
        .potionsOwned(AllPotionsFunction.empty())
        .corruptionGauge(0)
        .maxMana(300)
        .mana(300)
        .build();

    public static Wizard pettigrow = Wizard.builder()
        .name("Peter Pettigrew")
        .desc("Voldemort's best spy. An extremely smart individual, so beware !")
        .health(1000)
        .exp(50)
        .att(50)
        .def(10)
        .dex(-50)
        .level(50)
        .wand(new Wand("Chestnut", 23))
        .pet(Pet.generateRandomPet())
        .house(House.GRYFFINDOR)
        .knownSpells(AllSpellsFunction.pettigrowSpells())
        .potionsOwned(AllPotionsFunction.empty())
        .corruptionGauge(0)
        .maxMana(200)
        .mana(200)
        .build();

    public static Wizard umbridge = Wizard.builder()
        .name("Dolores Umbridge")
        .desc("An extremely cruel professor that's even capable of punishing violently and physically students !")
        .health(500)
        .exp(50)
        .att(25)
        .def(20)
        .dex(0)
        .level(50)
        .wand(new Wand("Umber", 34))
        .pet(Pet.generateRandomPet())
        .house(House.SLYTHERIN)
        .knownSpells(AllSpellsFunction.ombrageSpells())
        .potionsOwned(AllPotionsFunction.empty())
        .corruptionGauge(0)
        .maxMana(200)
        .mana(200)
        .build();

    public static Wizard bellatrix = Wizard.builder()
        .name("Bellatrix Lestrange")
        .desc("Voldemort's right hand servant, stronger than you think")
        .health(1000)
        .exp(50)
        .att(50)
        .def(10)
        .dex(-50)
        .level(50)
        .wand(new Wand("Walnut", 32))
        .pet(Pet.generateRandomPet())
        .house(House.SLYTHERIN)
        .knownSpells(AllSpellsFunction.voldemortSpells())
        .potionsOwned(AllPotionsFunction.empty())
        .corruptionGauge(0)
        .maxMana(200)
        .mana(200)
        .build();

    public static void castSpell()
}
