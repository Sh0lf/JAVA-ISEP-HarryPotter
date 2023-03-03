package com.isep.hpah.core;

import com.isep.hpah.core.character.AbstractEnemy;
import lombok.*;
import java.util.List;

@Getter @Setter
public class Dungeon {
    private String name;
    private String desc;
    private List<AbstractEnemy> enemies;

    public Dungeon(String name, String desc, List<AbstractEnemy> enemies){
        this.name = name;
        this.desc = desc;
        this.enemies = enemies;
    }

    public void addEnemy(AbstractEnemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(AbstractEnemy enemy) {
        enemies.remove(enemy);
    }

}
