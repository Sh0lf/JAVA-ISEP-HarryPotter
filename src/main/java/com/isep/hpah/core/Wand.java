package com.isep.hpah.core;

import com.isep.hpah.core.*;
import lombok.*;
import java.util.Random;

@Getter @Setter
public class Wand {
    private String name;
    private Core core;
    private double size;

    public Wand(String name, int size) {
        this.name = name;
        this.size = size;
        this.core = Core.generateRandomCore();
    }
}
