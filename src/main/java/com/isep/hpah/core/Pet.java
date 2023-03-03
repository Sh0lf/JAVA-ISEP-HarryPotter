package com.isep.hpah.core;

import java.util.Random;

public enum Pet {
    OWL,
    RAT,
    TOAD,
    CAT,
    HIPPOGRIFF,
    DOG,
    SNAKE;

    public static Pet generateRandomPet() {
        Pet[] values = Pet.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
