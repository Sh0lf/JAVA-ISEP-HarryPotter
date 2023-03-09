package com.isep.hpah.core.spells;

public class ForbiddenSpell extends AbstractSpell{
    public ForbiddenSpell(String name, int num, String desc, int exp, int corruption, String type) {
        super(name, num, desc, exp, corruption, type);
    }

    @Override
    public void cast(Character target) {

    }

    public static ForbiddenSpell avadaKedavra = new ForbiddenSpell("Avada Kedavra", 10000,"Le fameux " +
            "sort qui vous tue d'un seul coup", 1000, 99, "DMG");
}
