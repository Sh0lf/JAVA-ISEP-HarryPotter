import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.Dungeon;
import com.isep.hpah.core.character.Wizard;
import com.isep.hpah.Setup;

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
    }
}

