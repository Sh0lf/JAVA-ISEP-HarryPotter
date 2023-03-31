package com.isep.hpah.controller;

import com.isep.hpah.model.constructors.*;
import com.isep.hpah.model.constructors.character.Character;
import com.isep.hpah.model.constructors.character.Wizard;
import com.isep.hpah.views.DungeonOutput;
import com.isep.hpah.views.SafeScanner;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {

    private final GameLogic gameLogic = new GameLogic();
    private final GameEngine gameEngine = new GameEngine();
    private final AllSpellsFunction spfnc = new AllSpellsFunction();
    private final AllPotionsFunction popofnc = new AllPotionsFunction();
    private final Setup stp = new Setup();
    private final SafeScanner sc = new SafeScanner(System.in);
    private final DungeonOutput dngout = new DungeonOutput();

    @Test
    public void testCorruptionCheckWithCorruptedPlayer() {
        // Arrange
        Wizard player = Wizard.builder()
                .name("Test player")
                .desc("Test description")
                .health(100)
                .exp(0)
                .att(10)
                .def(10)
                .dex(10)
                .level(1)
                .wand(new Wand("Test wand", 10, Core.PHOENIX_FEATHER))
                .pet(Pet.CAT)
                .house(House.SLYTHERIN)
                .knownSpells(new ArrayList<>())
                .potionsOwned(new ArrayList<>())
                .corruptionGauge(100)
                .maxMana(100)
                .mana(100)
                .build();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        gameLogic.corruptionCheck(player);

        // Assert
        assertEquals(0, player.getHealth());
        assertTrue(outContent.toString().contains("You've casted too many forbidden spells and you're now consumed by the darkness"));
        assertTrue(outContent.toString().contains("You have been defeated."));
    }

    @Test
    public void testCorruptionCheckWithNonCorruptedPlayer() {
        // Arrange
        Wizard player = Wizard.builder()
                .name("Test player")
                .desc("Test description")
                .health(100)
                .exp(0)
                .att(10)
                .def(10)
                .dex(10)
                .level(1)
                .wand(new Wand("Test wand", 10, Core.PHOENIX_FEATHER))
                .pet(Pet.CAT)
                .house(House.SLYTHERIN)
                .knownSpells(new ArrayList<>())
                .potionsOwned(new ArrayList<>())
                .corruptionGauge(50)
                .maxMana(100)
                .mana(100)
                .build();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        gameLogic.corruptionCheck(player);

        // Assert
        assertEquals(100, player.getHealth());
        assertFalse(outContent.toString().contains("You've casted too many forbidden spells and you're now consumed by the darkness"));
        assertFalse(outContent.toString().contains("You have been defeated."));
    }

    @Test
    public void testCheckUmbridgeWinCon() {
        // create a new List of Characters with Umbridge as the first enemy
        List<Character> enemies = Arrays.asList(stp.getUmbridge());

        // redirect standard output to a stream we can check
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // run the method with round 10
        DungeonOutput dngout = new DungeonOutput();
        gameLogic.checkUmbridgeWinCon(enemies, 10);

        // check that the expected message was printed
        assertEquals("You survived long enough against Umbridge and you succeeded in tempoying her long enough to win !\n", outContent.toString());

        // check that Umbridge's health was set to 0
        assertEquals(0, enemies.get(0).getHealth());
    }

    @Test
    void reducingCorruption() {
    }

    @Test
    void basicChoice3() {
    }

    @Test
    void choice4() {
    }

    @Test
    void gryffindorSword() {
    }

    @Test
    void checkVoldemortCore() {
    }

    @Test
    void checkDefBoost() {
    }

    @Test
    void presentingTurn() {
    }

    @Test
    void attacking() {
    }

    @Test
    void chooseSpell() {
    }

    @Test
    void processDmgSpell() {
    }

    @Test
    void processDefSpell() {
    }

    @Test
    void processUtlSpell() {
    }

    @Test
    void selectPotion() {
    }

    @Test
    void allyDeathEater() {
    }

    @Test
    void endDungeon() {
    }

    @Test
    void removeGryffindorSword() {
    }

    @Test
    void checkLevelUp() {
    }

    @Test
    void giveNewSpell() {
    }

    @Test
    void giveNewPotions() {
    }

    @Test
    void checkPotionBoost() {
    }

    @Test
    void corruptionHalf() {
    }
}
