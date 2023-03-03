package com.isep.hpah.core;
import java.util.Random;

public enum Core {
    PHOENIX_FEATHER,
    DRAGON_HEARTSTRING,
    UNICORN_HAIR,
    VEELA_HAIR,
    THESTRAL_TAIL;

    public static Core generateRandomCore() {
        Core[] values = Core.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}


