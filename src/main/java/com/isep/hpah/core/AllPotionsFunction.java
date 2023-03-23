package com.isep.hpah.core;

import com.isep.hpah.core.constructors.House;
import com.isep.hpah.core.constructors.Potion;
import com.isep.hpah.core.constructors.character.*;

public class AllPotionsFunction {
    public void usePotion(Wizard player, int potionIndex){
        Potion potion = player.getPotionsOwned().get(potionIndex);
        double boost = 0;

        switch (potion.getType()){
            case "HP":
                boost = checkHouseBuff(player, potion);
                player.setHealth(player.getHealth() + (int) boost);
                System.out.println(player.getName() + " gained " + (int) boost + " Health !");
                break;
            case "DEF":
                boost = checkHouseBuff(player, potion);
                player.setDef(player.getDef() + (int) boost);
                player.setPotionDefBoost(player.getPotionDefBoost() + (int) boost);
                System.out.println(player.getName() + " gained " + (int) boost + " Defense for this battle for a total of "
                        + player.getPotionDefBoost() + " bonus defense !");
                break;
            case "DEX":
                boost = checkHouseBuff(player, potion);
                player.setDex(player.getDex() + (int) boost);
                player.setPotionDexBoost(player.getPotionDexBoost() + (int) boost);
                System.out.println(player.getName() + " gained " + (int) boost + " Dexterity for this battle for a total of "
                        + player.getPotionDexBoost() + " bonus dexterity !");
                break;
            default:
                break;
        }
    }

    private double checkHouseBuff(Wizard player, Potion potion){
            double boost = potion.getBoost();
            if (player.getHouse().equals(House.HUFFLEPUFF)) {
                boost = boost * 1.2;
                System.out.println("\n Since " + player.getName() + " is from Hufflepuff, the potions are more efficient !");
            }
            return boost;
    }
}
