package com.isep.hpah.core.character;
import com.isep.hpah.core.*;
import com.isep.hpah.core.potions.AllPotionsFunction;
import com.isep.hpah.core.potions.Potion;
import com.isep.hpah.core.spells.*;
import lombok.*;
import java.util.List;

@Setter @Getter
public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private List<AbstractSpell> knownSpells;
    private List<Potion> potionsOwned;
    private double corruptionGauge;

    public Wizard(String name, String desc, int health, int exp, int att, int def, int dex, Wand wand, Pet pet,
                  House house, List<AbstractSpell> knownSpells, List<Potion> potionsOwned, int corruptionGauge) {
        super(name, "Sorcier", desc, health, exp, att, def, dex);
        this.wand = wand;
        this.pet = Pet.generateRandomPet();
        this.house = SortingHat.assignHouse();
        this.knownSpells = knownSpells;
        this.potionsOwned = potionsOwned;
        this.corruptionGauge = corruptionGauge;
    }

    public static Wizard voldemort = new Wizard("Voldemort", "\"Le Seigneur des Ténèbres\", l'étudiant le plus plus " +
            "brilliant de Poudlard qui a vrillé dans le chaos et qui fait utilisation de la magie noire sans se " +
            "soucier des conséquences !", 1000, 50, 50, 10, -50,
            new Wand("La baguette de Tom Jedusor", 33.75), Pet.generateRandomPet(), House.SLYTHERIN,
            AllSpellsFunction.voldemortSpells(), AllPotionsFunction.empty(), 0);

    public static Wizard pettigrow = new Wizard("Peter Pettigrow", "Le serviteur de Voldemort." +
            "A s'en méfier toutefois ! Il n'est pas serviteur de Voldemort pour rien !", 1000, 50,
            50, 10, -50, new Wand("Chataigner", 23), Pet.generateRandomPet(),
            House.SLYTHERIN, AllSpellsFunction.pettigrowSpells(), AllPotionsFunction.empty(),0);

    public static Wizard ombrage = new Wizard("Dolores Ombrage",
            "Une professeure pervers et violente capable de torturer ses élèves physiquement !",
            500, 50, 25, 20, 0, new Wand("Umber", 34),Pet.generateRandomPet(),
            House.SLYTHERIN, AllSpellsFunction.ombrageSpells(),AllPotionsFunction.empty(), 0);

    public static Wizard bellatrix = new Wizard("Bellatrix Lestrange", "Le bras droit de Voldemort, fidèle depuis les " +
            "2 dernières guerres", 1000, 50, 50, 10, -50,
            new Wand("Noyer", 32), Pet.generateRandomPet(), House.SLYTHERIN,
            AllSpellsFunction.voldemortSpells(), AllPotionsFunction.empty(), 0);
}
