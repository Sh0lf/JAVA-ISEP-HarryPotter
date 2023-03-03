package com.isep.hpah.core;

import com.isep.hpah.core.*;
import lombok.*;
import java.util.Random;

public class Wand {
    @Setter @Getter
    private String name;
    @Setter @Getter
    private Core core;
    @Setter @Getter
    private double size;

    public Wand(String name, int size) {
        this.name = name;
        this.size = size;
        this.core = Core.generateRandomCore();
    }
}
