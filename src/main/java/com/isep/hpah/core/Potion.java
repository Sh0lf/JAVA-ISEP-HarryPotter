package com.isep.hpah.core;

import lombok.*;

public class Potion {
    @Setter @Getter
    private String name;
    @Setter @Getter
    private String desc;
    @Setter @Getter
    private double boost;

    public Potion(String name, String desc, int boost) {
        this.name = name;
        this.desc = desc;
        this.boost = boost;
    }
}
