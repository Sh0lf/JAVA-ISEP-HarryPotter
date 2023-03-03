package com.isep.hpah.core;

import lombok.*;
import java.util.Random;

@Getter
public class SortingHat {
    public static House assignHouse() {
        House[] values = House.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
