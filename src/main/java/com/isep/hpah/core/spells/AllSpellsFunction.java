package com.isep.hpah.core.spells;

import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.character.Character;
import com.isep.hpah.core.character.Wizard;

import java.util.List;

public class AllSpellsFunction {

    Game game = new Game();

    // Method to cast a spell
    public void castDmgSpell(AbstractSpell spell, Character player, Character enemy) {
        // Cast the attacking spell on the enemy
        int damage = spell.getNum();
        double hitChance = 0.7 + player.getDex();
        double rand = Math.random();
        if (rand > hitChance) {
            System.out.println(player.getName() + " missed the attack !");
            return;
        }
        int remainingHealth = enemy.getHealth() - damage;
        enemy.setHealth(remainingHealth);
        System.out.println(player.getName() + " hit " + enemy.getName() + " with " + spell.getName() + " for " + damage + " damage !");
        System.out.println(enemy.getName() + " has " + remainingHealth + " health points remaining.");
    }

    public void castDefSpell(AbstractSpell spell, Wizard player){
        int val = spell.getNum();
        player.setDefSpell(val);
        player.setDef(player.getDefSpell());
        System.out.println("You gained " + val + " defense for this turn and have now a total of " + player.getDef() + " defense !");
    }

    public void checkCooldown(List<AbstractSpell> spells){
        for (AbstractSpell spell : spells) {
            if (spell.getCooldownRem() > 0) {
                spell.setCooldown(spell.getCooldownRem() - 1);
            }
        }
    }

    public void checkUtlSpellUsage(AbstractSpell spell, Wizard player, List<Character> enemies, SafeScanner sc){
        //TODO : MAKE THE CHECK UTL SPELL USAGE SWITCH CASE BASED ON DUNGEON / ENEMY
        int targetIndex = game.chooseTarget(spell, enemies, sc);

        Character target = enemies.get(targetIndex);
        castUtlSpell(spell, player, target);

        spell.setCooldownRem(spell.getCooldown());
    }


    //Extremely long process; A switch case that checks what spell
    public void castUtlSpell(AbstractSpell spell, Wizard player, Character target) {
        switch(target.getName()) {
            case "Troll":
                //Make thing for Troll specifically
                break;
            case "Basilisk":
                //Make thing for basilisk specifically
                break;
            case "Dementor":
                //Make thing for dementor (dungeon) specifically
                break;
            case "Lord Voldemort":
                //Make thing for voldemort (dungeon) specifically
                break;
            case "Peter Pettigrew":
                //Make thing for Bellatrix (dungeon) specifically
                break;
            case "Dolores Umbridge":
                //Make thing for Dolores specifically
                break;
            case "Death Eater":
                //Make thing for Death Eater (dungeon) specifically
                break;
            case "Bellatrix Lestrange":
                //Make thing for Bellatrix (dungeon) specifically
                break;
            default:
                break;

                //TODO: ALL of this, maybe need to do 2 diff Voldemort since 2 occurences and 2 diff dungeons
        }
    }
}
