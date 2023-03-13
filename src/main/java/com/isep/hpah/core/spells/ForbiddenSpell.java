package com.isep.hpah.core.spells;

public class ForbiddenSpell extends AbstractSpell{
    public ForbiddenSpell(String name, int num, String desc, int exp, int corruption, int cooldown, int mana, String type) {
        super(name, num, desc, exp, corruption, cooldown, mana, type);
    }

    @Override
    public void cast(Character target) {

    }

    public static ForbiddenSpell avadaKedavra = new ForbiddenSpell("Avada Kedavra", 10000,"You ded",
            1000, 99, 6, 200,"DMG");
}
