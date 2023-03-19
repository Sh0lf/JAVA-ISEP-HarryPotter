package com.isep.hpah.core;

import com.isep.hpah.core.character.Character;
import lombok.*;
import java.util.List;

@Getter @Setter @Builder
public class Dungeon {
    private String name;
    private String desc;
    private List<Character> enemies;

    public Dungeon(String name, String desc, List<Character> enemies){
        this.name = name;
        this.desc = desc;
        this.enemies = enemies;
    }
}