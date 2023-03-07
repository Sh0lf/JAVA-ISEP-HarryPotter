package com.isep.hpah.core.spells;

public class ForbiddenSpell extends AbstractSpell{
    public ForbiddenSpell(String name, int num, String desc, int exp, int corruption, String type) {
        super(name, num, desc, exp, corruption, type);
    }

    @Override
    public void cast(Character target) {
        // TODO: Implement spell casting logic for forbidden spells
    }
}
