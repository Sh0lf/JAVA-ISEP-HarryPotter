package com.isep.hpah.core;

import com.isep.hpah.Setup;
import lombok.*;

@Getter @Setter
public class Wand {
    private String name;
    private Core core;
    private double size;

    Setup stp = new Setup();

    public Wand(String name, double size) {
        this.name = name;
        this.size = size;
        this.core = stp.generateRandomCore();
    }
}
