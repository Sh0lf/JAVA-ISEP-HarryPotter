import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.*;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.character.Wizard;
import com.isep.hpah.core.dungeon.Dungeon;
import com.isep.hpah.core.spells.AbstractSpell;
import com.isep.hpah.core.spells.Spell;

import java.util.List;
import java.util.Scanner;

import static com.isep.hpah.Game.*;
import static com.isep.hpah.SafeScanner.*;
import static com.isep.hpah.core.Pet.*;
import static com.isep.hpah.core.SortingHat.*;
import static com.isep.hpah.core.dungeon.AllDungeonsFunction.allDungeon;

public class Main {

    public static void main(String[] args) {
        SafeScanner sc = new SafeScanner(System.in);
        Wizard player = gamePres(sc);
        sc.pressEnterToContinue();

        List<Dungeon> dungeons = allDungeon();

        sc.printHeader(dungeons.get(0).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(0).getDesc());
        sc.pressEnterToContinue();

        dungeonCombat(dungeons.get(0).getEnemies(), player);
    }
}

