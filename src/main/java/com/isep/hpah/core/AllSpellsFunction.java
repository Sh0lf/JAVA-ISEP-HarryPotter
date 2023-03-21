package com.isep.hpah.core;

import com.isep.hpah.Game;
import com.isep.hpah.SafeScanner;
import com.isep.hpah.core.constructors.character.Character;
import com.isep.hpah.core.constructors.character.Wizard;
import com.isep.hpah.core.constructors.spells.AbstractSpell;

import java.util.List;

public class AllSpellsFunction {
    private Game game;

    public AllSpellsFunction(Game game) {
        this.game = game;
    }

    public void manaReduce(AbstractSpell spell, Wizard player) {
        player.setMana(player.getMana() - spell.getMana());
    }

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

    public void checkCooldown(List<AbstractSpell> spells, List<Character> enemies, int targetIndex){
        for (AbstractSpell spell : spells) {
            if (spell.getCooldownRem() > 0) {
                if (spell.getName().equals("Accio") && spell.getCooldownRem() == 2){
                    if ((enemies.get(targetIndex).getName().equals("Lord Voldemort") &&
                            enemies.get(targetIndex + 1).getName().equals("Bellatrix Lestrange")) ||
                            enemies.get(targetIndex).getName().equals("Bellatrix Lestrange")){
                        enemies.get(targetIndex).setDef(enemies.get(targetIndex).getDef() + 10);
                        System.out.println("The opponent has restored his stability and has recovered his defense !");
                    }
                } else if (spell.getName().equals("Expelliarmus") && spell.getCooldownRem() == 4){
                    if ((enemies.get(targetIndex).getName().equals("Lord Voldemort") &&
                            enemies.get(targetIndex + 1).getName().equals("Bellatrix Lestrange")) ||
                            enemies.get(targetIndex).getName().equals("Bellatrix Lestrange")) {
                        enemies.get(targetIndex).setDex(enemies.get(targetIndex).getDex() + spell.getNum());
                        System.out.println("The opponent has recovered his wand and can now attack ! Watch out !");
                    }
                }
                spell.setCooldown(spell.getCooldownRem() - 1);
            }
        }
    }

    public int checkUtlSpellUsage(AbstractSpell spell, List<Character> enemies, SafeScanner sc){
        //TODO : Made spells exception per dungeon; now need to do all the possibilities.
        int targetIndex = game.chooseTarget(spell, enemies, sc);

        Character target = enemies.get(targetIndex);

        switch (target.getName()) {
            case "Troll":
                if (spell.getName().equals("Wingardium Leviosa")) {
                    target.setHealth(0);
                    System.out.println("You saw the boulder, you levitated it and you squished the troll !");
                }
                break;
            case "Basilisk":
                if (spell.getName().equals("Wingardium Leviosa")) {
                    target.setHealth(target.getHealth() - 40);
                    System.out.println("You saw a barrel, you levitated it and you threw it towards the basilisk !");
                    System.out.println("You dealt 40 damage !");
                } else if (spell.getName().equals("Accio")) {
                    target.setHealth(target.getHealth() / 3);
                    System.out.println("You successfully removed one of his fangs ! You just removed 1/3rd of his health !");
                }
                break;
            case "Dementor":
                if (spell.getName().equals("Wingardium Leviosa") || spell.getName().equals("Accio")) {
                    System.out.println("You tried to throw something at them, but they are not physical entities ! There's no effect !");
                }
                break;
            case "Lord Voldemort":
                if (spell.getName().equals("Accio")) {
                    if (enemies.get(1).getName().equals("Peter Pettigrew")) {
                        for (Character enemy : enemies) {
                            enemy.setHealth(0);
                        }
                        System.out.println("You successfully teleported out to safety !");
                    } else {
                        target.setDef(target.getDef() - 10);
                        System.out.println("You summoned a rock, destabilizing him and showing his weak points !");
                        System.out.println("You reduced his defense by 10 !");
                    }
                } else if (spell.getName().equals("Wingardium Leviosa")) {
                    target.setHealth(target.getHealth() - 100);
                    System.out.println("You saw a big rook, you levitated it and you threw it towards Voldemort !");
                    System.out.println("You dealt 100 damage !");
                } else if (spell.getName().equals("Expelliarmus")) {
                    if (enemies.get(1).getName().equals("Bellatrix Lestrange")) {
                        target.setDex(target.getDex() - spell.getNum());
                        System.out.println("You successfully threw away Voldemort's wand and will miss his next move !");
                        System.out.println("You reduced his dexterity by 20 !");
                    }
                }
                break;
            case "Peter Pettigrew":
                if (spell.getName().equals("Accio")) {
                    for (Character enemy : enemies) {
                        enemy.setHealth(0);
                    }
                    System.out.println("You successfully teleported out to safety !");
                } else if (spell.getName().equals("Wingardium Leviosa")) {
                    target.setHealth(target.getHealth() - 100);
                    System.out.println("You saw a big rook, you levitated it and you threw it towards Pettigrew !");
                    System.out.println("You dealt 100 damage !");
                }
                break;
            case "Bellatrix Lestrange":
                if (spell.getName().equals("Expelliarmus")) {
                    target.setDex(target.getDex() - spell.getNum());
                    System.out.println("You successfully threw away Bellatrix's wand and will miss his next move !");
                    System.out.println("You reduced his dexterity by 20 !");
                } else if (spell.getName().equals("Accio")) {
                    target.setDef(target.getDef() - 10);
                    System.out.println("You summoned a rock, destabilizing him and showing his weak points !");
                    System.out.println("You reduced his defense by 10 !");
                } else if (spell.getName().equals("Wingardium Leviosa")) {
                    target.setHealth(target.getHealth() - 100);
                    System.out.println("You saw a big rook, you levitated it and you threw it towards Bellatrix !");
                    System.out.println("You dealt 100 damage !");
                }
                break;
            default:
                break;
        }
        return targetIndex;
    }
}


