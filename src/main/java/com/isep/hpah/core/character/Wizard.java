package com.isep.hpah.core.character;
import com.isep.hpah.core.*;
import com.isep.hpah.core.spells.*;
import lombok.*;
import java.util.List;

@Setter @Getter
public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potionsOwned;
    private double corruptionGauge;

    public Wizard(String name, String desc, int health, int exp, int att, int def, int dex, Wand wand, Pet pet, House house, List<Spell> knownSpells, List<Potion> potionsOwned, int corruptionGauge) {
        super(name, "Sorcier", desc, health, exp, att, def, dex);
        this.wand = wand;
        this.pet = Pet.generateRandomPet();
        this.house = SortingHat.assignHouse();
        this.knownSpells = knownSpells;
        this.potionsOwned = potionsOwned;
        this.corruptionGauge = corruptionGauge;
    }

}
