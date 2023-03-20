package com.isep.hpah.core.constructors;

import com.isep.hpah.core.Setup;
import lombok.*;

@Getter @Setter
public class Wand {
    private String name;
    private Core core;
    private double size;

    public Wand(String name, double size, Core core) {
        this.name = name;
        this.size = size;
        this.core = core;
    }
}
