package com.isep.hpah.core.spells;

import lombok.*;

@Setter @Getter
public abstract class AbstractSpell {
    //defining what a spell have:
    private String name;
    private double num;
    private String desc;
    private double exp;
    private double corruption;
    private String type;

    public AbstractSpell(String name, double num, String desc, double exp, double corruption, String type) {
        this.name = name;
        this.num = num;
        this.desc = desc;
        this.exp = exp;
        this.corruption = corruption;
        this.type = type;
    }

    // Abstract method for casting the spell
    public abstract void cast(Character target);


}
