package com.isep.hpah;

import com.isep.hpah.core.*;
import com.isep.hpah.core.character.Boss;
import com.isep.hpah.core.character.Character;
import com.isep.hpah.core.character.Wizard;
import com.isep.hpah.core.character.Enemy;
import com.isep.hpah.core.Dungeon;
import com.isep.hpah.core.spells.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Setter @Getter
public class Setup {

    public Core generateRandomCore() {
        Core[] values = Core.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }

    public Pet generateRandomPet() {
        Pet[] values = Pet.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }

    public Spell fireball = Spell.builder()
            .name("Fireball")
            .num(40)
            .desc("A powerful ball of pure fire and heat")
            .level(0)
            .cooldown(2)
            .mana(20)
            .type("DMG")
            .build();

    public Spell lightningBolt = Spell.builder()
            .name("Lightning Bolt")
            .num(50)
            .desc("Strike your enemies with lightning")
            .level(0)
            .cooldown(3)
            .mana(30)
            .type("DMG")
            .build();

    public Spell wingardiumLeviosa = Spell.builder()
            .name("Wingardium Leviosa")
            .num(0)
            .desc("Levitate objects with this spell")
            .level(0)
            .cooldown(0)
            .mana(0)
            .type("UTL")
            .build();

    public Spell accio = Spell.builder()
            .name("Accio")
            .num(0)
            .desc("Bring an object towards you")
            .level(2)
            .cooldown(0)
            .type("UTL")
            .build();
    public Spell expectoPatronum = Spell.builder()
            .name("Expecto Patronum")
            .num(1000)
            .desc("Protect yourself with the sacred Guardian of the forest")
            .level(3)
            .cooldown(3)
            .mana(40)
            .type("DEF")
            .build();

    public ForbiddenSpell avadaKedavra = ForbiddenSpell.builder()
            .name("Avada Kedavra")
            .num(10000)
            .desc("You ded")
            .level(1000)
            .corruption(99)
            .cooldown(6)
            .mana(200)
            .type("DMG")
            .build();

    public List<Potion> empty(){
        List<Potion> empty = new ArrayList<>();
        return empty;
    }

    public List<AbstractSpell> startingSpellList(){
        //creating arrayList for new wizard
        List<AbstractSpell> knownSpells = new ArrayList<>();
        //Known Spells that you start with
        knownSpells.add(fireball);
        knownSpells.add(lightningBolt);
        knownSpells.add(wingardiumLeviosa);

        return knownSpells;
    }

    public List<AbstractSpell> voldemortSpells(){
        List<AbstractSpell> voldemortSpells = new ArrayList<>();
        //list of spells that Voldemort knows
        voldemortSpells.add(avadaKedavra);
        voldemortSpells.add(fireball);
        voldemortSpells.add(lightningBolt);
        return voldemortSpells;
    }

    public List<AbstractSpell> pettigrowSpells(){
        List<AbstractSpell> pettigrowSpells = new ArrayList<>();
        //list of spells that Pettigrow knows
        pettigrowSpells.add(fireball);
        pettigrowSpells.add(lightningBolt);
        return pettigrowSpells;
    }

    public List<AbstractSpell> ombrageSpells(){
        List<AbstractSpell> ombrageSpells = new ArrayList<>();
        //list of spells that Ombrage knows
        ombrageSpells.add(fireball);
        ombrageSpells.add(lightningBolt);

        return ombrageSpells;
    }

    public Enemy dementor = Enemy.builder()
            .name("Dementor")
            .desc("One of the foulest Dark creatures")
            .health(100)
            .exp(25)
            .att(25)
            .def(5)
            .dex(5)
            .dangerLevel(3)
            .build();
    public Enemy deatheater = Enemy.builder()
            .name("Death Eater")
            .desc("The most ardent followers of Voldemort")
            .health(150)
            .exp(25)
            .att(25)
            .def(5)
            .dex(5)
            .dangerLevel(3)
            .build();

    public Boss troll = Boss.builder()
            .name("Troll")
            .desc("Huge brutal but stupid creature")
            .health(100)
            .exp(50)
            .att(20)
            .def(5)
            .dex(2)
            .build();
    public Boss basilisk = Boss.builder()
            .name("Basilisk")
            .desc("Huge poisoned snake, that can kill you instantly !")
            .health(200)
            .exp(50)
            .att(40)
            .def(10)
            .dex(5)
            .build();

    public Wizard voldemort = Wizard.builder()
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
            .pet(generateRandomPet())
            .house(House.SLYTHERIN)
            .knownSpells(voldemortSpells())
            .potionsOwned(empty())
            .corruptionGauge(0)
            .maxMana(300)
            .mana(300)
            .build();

    public Wizard pettigrow = Wizard.builder()
            .name("Peter Pettigrew")
            .desc("Voldemort's best spy. An extremely smart individual, so beware !")
            .health(1000)
            .exp(50)
            .att(50)
            .def(10)
            .dex(-50)
            .level(50)
            .wand(new Wand("Chestnut", 23))
            .pet(generateRandomPet())
            .house(House.GRYFFINDOR)
            .knownSpells(pettigrowSpells())
            .potionsOwned(empty())
            .corruptionGauge(0)
            .maxMana(200)
            .mana(200)
            .build();

    public Wizard umbridge = Wizard.builder()
            .name("Dolores Umbridge")
            .desc("An extremely cruel professor that's even capable of punishing violently and physically students !")
            .health(500)
            .exp(50)
            .att(25)
            .def(20)
            .dex(0)
            .level(50)
            .wand(new Wand("Umber", 34))
            .pet(generateRandomPet())
            .house(House.SLYTHERIN)
            .knownSpells(ombrageSpells())
            .potionsOwned(empty())
            .corruptionGauge(0)
            .maxMana(200)
            .mana(200)
            .build();

    public Wizard bellatrix = Wizard.builder()
            .name("Bellatrix Lestrange")
            .desc("Voldemort's right hand servant, stronger than you think")
            .health(1000)
            .exp(50)
            .att(50)
            .def(10)
            .dex(-50)
            .level(50)
            .wand(new Wand("Walnut", 32))
            .pet(generateRandomPet())
            .house(House.SLYTHERIN)
            .knownSpells(voldemortSpells())
            .potionsOwned(empty())
            .corruptionGauge(0)
            .maxMana(200)
            .mana(200)
            .build();

    public Wizard playerCreation (String name, Wand wand, Pet pet, House house) {
        int defaultDef = 10;
        int defaultDex = 10;

        if (house == House.GRYFFINDOR){
            defaultDef = 20;
        }

        if (house == House.RAVENCLAW){
            defaultDex = 15;
        }

        Wizard player = Wizard.builder()
                .name(name)
                .desc("The player")
                .health(200)
                .exp(0)
                .att(20)
                .def(defaultDef)
                .dex(defaultDex)
                .level(1)
                .wand(wand)
                .pet(pet)
                .house(house)
                .knownSpells(startingSpellList())
                .potionsOwned(empty())
                .corruptionGauge(0)
                .maxMana(100)
                .mana(100)
                .build();
        return player;
    }

    public List<Character> dungeon1(){
        //creating arrayList
        List<Character> dungeon1 = new ArrayList<>();
        //mob creation per dungeon
        dungeon1.add(troll);
        return dungeon1;
    }

    public List<Character> dungeon2(){
        //creating arrayList
        List<Character> dungeon2 = new ArrayList<>();
        //mob creation per dungeon
        dungeon2.add(basilisk);
        return dungeon2;
    }

    public List<Character> dungeon3(){
        //creating arrayList
        List<Character> dungeon3 = new ArrayList<>();
        //mob creation per dungeon
        dungeon3.add(dementor);
        dungeon3.add(dementor);
        dungeon3.add(dementor);
        dungeon3.add(dementor);

        return dungeon3;
    }

    public List<Character> dungeon4(){
        //creating arrayList
        List<Character> dungeon4 = new ArrayList<>();
        //mob creation per dungeon
        dungeon4.add(voldemort);
        dungeon4.add(pettigrow);
        return dungeon4;
    }

    public List<Character> dungeon5(){
        //creating arrayList
        List<Character> dungeon5 = new ArrayList<>();
        //mob creation per dungeon
        dungeon5.add(umbridge);
        return dungeon5;
    }

    public List<Character> dungeon6(){
        //creating arrayList
        List<Character> dungeon6 = new ArrayList<>();
        //mob creation per dungeon
        dungeon6.add(deatheater);
        dungeon6.add(deatheater);
        dungeon6.add(deatheater);
        dungeon6.add(deatheater);

        return dungeon6;
    }

    public List<Character> dungeon7(){
        //creating arrayList
        List<Character> dungeon7 = new ArrayList<>();
        //mob creation per dungeon
        dungeon7.add(voldemort);
        dungeon7.add(bellatrix);
        return dungeon7;
    }

    public Dungeon philosopherStone = Dungeon.builder()
            .name("The Philosopher's Stone")
            .desc("There's a troll right next to the toilets of the dungeon ! Beast him in a way or another !")
            .enemies(dungeon1())
            .build();
    public Dungeon chamberofSecrets = Dungeon.builder()
            .name("The Chamber of Secrets")
            .desc("You find yourself right in front of the mighty terrifying Basilisk ! Pull out one of these fangs to destroy Tom Riddle's journal ! Or maybe... there's another way...")
            .enemies(dungeon2())
            .build();
    public Dungeon prisonnerofAzkaban = Dungeon.builder()
            .name("The Prisonner of Azkaban")
            .desc("The dementors are on the loose! To defeat them, learn a spell by leveling up and use it against the dementors!")
            .enemies(dungeon3())
            .build();
    public Dungeon gobletofFire = Dungeon.builder()
            .name("The Goblet of Fire")
            .desc("You have won the Triwizard Tournament... and the right to die. You find Voldemort and Peter Pettigrew! Run away anyway!")
            .enemies(dungeon4())
            .build();
    public Dungeon orderofPhoenix = Dungeon.builder()
            .name("The Order of Phoenix")
            .desc("It's time for the OWL (Universal Certificate of Elementary Witchcraft)! Dolores Umbridge is watching over you. Your goal is to distract her until the fireworks are ready to go.")
            .enemies(dungeon5())
            .build();
    public Dungeon halfBloodedPrince = Dungeon.builder()
            .name("The Half-Blood Prince")
            .desc("The Death Eaters attack Hogwarts. Do you want to attack them from the front or do you plan to make another decision?")
            .enemies(dungeon6())
            .build();
    public Dungeon deathlyHallows = Dungeon.builder()
            .name("The Deathly Hallows")
            .desc("You have to start attacking the problem at the source. You are facing Voldemort and Bellatrix Lestrange! Pay attention to Avada Kedavra!")
            .enemies(dungeon7())
            .build();

    public List<Dungeon> allDungeon(){
        //ArrayList creation for better organisation
        List<Dungeon> allDungeon = new ArrayList<>();
        //Dungeons adding to list
        allDungeon.add(philosopherStone);
        allDungeon.add(chamberofSecrets);
        allDungeon.add(prisonnerofAzkaban);
        allDungeon.add(gobletofFire);
        allDungeon.add(orderofPhoenix);
        allDungeon.add(halfBloodedPrince);
        allDungeon.add(deathlyHallows);

        return allDungeon;
    }


}
