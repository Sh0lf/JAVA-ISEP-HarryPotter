package com.isep.hpah.core.character;
import lombok.*;

@Setter @Getter
public abstract class AbstractEnemy extends Character{
    private int dangerLevel;
    private boolean isAlive = true;

    public AbstractEnemy(String name, String type, String desc, int maxHealth, int health, double exp, int att, int def, int dex, int dangerLevel, boolean isAlive) {
        super(name, type, desc, maxHealth, health, exp, att, def, dex);
        this.dangerLevel = dangerLevel;
        this.isAlive = isAlive;
    }

    public void aliveOrDead(){
        if (getHealth() <= 0){
            setAlive(false);
        }
    }
}
