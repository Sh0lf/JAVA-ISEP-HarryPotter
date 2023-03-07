package com.isep.hpah.core.spells;

import java.io.*;
import java.util.*;

public class Spell extends AbstractSpell{
    public Spell(String name, int num, String desc, int exp, String type) {
        super(name, num, desc, exp, 0, type);
    }

    @Override
    public void cast(Character target) {
        //TODO: Implement spell casting logic for normal spells
    }

}
