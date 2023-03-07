package com.isep.hpah.core.spells;

import lombok.*;

@Setter @Getter
public abstract class AbstractSpell {
    //defining what a spell have:
    private String name;
    private int num;
    private String desc;
    private int exp;
    private int corruption;
    private String type;

    public AbstractSpell(String name, int num, String desc, int exp, int corruption, String type) {
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
