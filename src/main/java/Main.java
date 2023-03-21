import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.constructors.Dungeon;
import com.isep.hpah.core.constructors.character.Wizard;
import com.isep.hpah.core.Setup;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Setup stp = new Setup();
        SafeScanner sc = new SafeScanner(System.in);

        Wizard player = game.gamePres(sc);
        sc.pressEnterToContinue();

        List<Dungeon> dungeons = stp.allDungeon();

        sc.printHeader(dungeons.get(0).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(0).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(0).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(1).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(1).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(1).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(2).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(2).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(2).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(3).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(3).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(3).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(4).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(4).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(4).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(5).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(5).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(5).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(6).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(6).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(6).getEnemies(), player);
        sc.pressEnterToContinue();

        sc.printHeader(dungeons.get(7).getName());
        sc.pressEnterToContinue();

        sc.printHeading(dungeons.get(7).getDesc());
        sc.pressEnterToContinue();

        game.dungeonCombat(dungeons.get(7).getEnemies(), player);
        sc.pressEnterToContinue();
    }
}

