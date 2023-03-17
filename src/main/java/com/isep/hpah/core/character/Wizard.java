package com.isep.hpah.core.character;
import com.isep.hpah.core.*;
import com.isep.hpah.core.potions.*;
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
    private int defSpell;

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
        this.defSpell = 0;
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
}
