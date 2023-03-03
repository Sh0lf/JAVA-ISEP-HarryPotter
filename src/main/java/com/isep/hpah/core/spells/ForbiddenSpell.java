package com.isep.hpah.core.spells;

public class ForbiddenSpell extends AbstractSpell{
    public ForbiddenSpell(String name, double num, String desc, double exp, double corruption, String type) {
        super(name, num, desc, exp, corruption, type);
    }

    @Override
    public void cast(Character target) {
        // TODO: Implement spell casting logic for forbidden spells
    }
}
