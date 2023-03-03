package com.isep.hpah.core;

import com.isep.hpah.core.character.AbstractEnemy;
import lombok.*;
import java.util.List;

@Getter @Setter
public class Dungeon {
    private String name;
    private String desc;
    private List<AbstractEnemy> enemies;

    public void addEnemy(AbstractEnemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(AbstractEnemy enemy) {
        enemies.remove(enemy);
    }

}
