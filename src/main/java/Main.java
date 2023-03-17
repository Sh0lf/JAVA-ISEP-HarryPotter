import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.*;
import com.isep.hpah.core.Pet;
import com.isep.hpah.core.character.Wizard;
import com.isep.hpah.core.dungeon.AllDungeonsFunction;
import com.isep.hpah.core.dungeon.*;
import com.isep.hpah.core.spells.AbstractSpell;
import com.isep.hpah.core.spells.Spell;

import java.util.List;
import java.util.Scanner;

import static com.isep.hpah.Game.*;
import static com.isep.hpah.SafeScanner.*;
import static com.isep.hpah.core.Pet.*;
import static com.isep.hpah.core.SortingHat.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        AllDungeonsFunction dngfnc = new AllDungeonsFunction();
        SafeScanner sc = new SafeScanner(System.in);
        Wizard player = game.gamePres(sc);
        sc.pressEnterToContinue();

        List<Dungeon> dungeons = dngfnc.allDungeon();

        sc.printHeader(dungeons.get(0).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(0).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(0).getEnemies(), player);
    }
}

