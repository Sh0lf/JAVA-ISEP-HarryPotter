package com.isep.hpah.core.potions;

import lombok.*;

@Getter @Setter
public class Potion {
    private String name;
    private String desc;
    private double boost;

    public Potion(String name, String desc, int boost) {
        this.name = name;
        this.desc = desc;
        this.boost = boost;
    }
}
