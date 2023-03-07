package com.isep.hpah.core.dungeon;

import java.util.ArrayList;
import java.util.List;

public class AllDungeons {
    public static List<Dungeon> allDungeon(){
        //ArrayList creation for better organisation
        List<Dungeon> allDungeon = new ArrayList<>();
        //Dungeons Creation
        allDungeon.add(new Dungeon("The Philosopher's Stone", "Un troll se trouve dans les toilettes à coté du Donjon ! Vous devez le vaincre d'une manière !", EnemiesPerDungeon.dungeon1()));
        allDungeon.add(new Dungeon("The Chamber of Secrets", "Vous êtes face au terrible basilic ! Arrachez un de ces crocs pour détruire le journal de Tom Jedusor ! Ou sinon, il y a une autre manière de le vaincre...", EnemiesPerDungeon.dungeon2()));
        allDungeon.add(new Dungeon("The Prisonner of Azkaban", "Les détraqueurs sont en libertés ! Pour les vaincre, apprenez un sort en passant au prochain niveau et utilisez le contre les détraqueurs !", EnemiesPerDungeon.dungeon3()));
        allDungeon.add(new Dungeon("The Goblet of Fire", "Vous avez remporté le Tournoi des Trois Sorciers... et le droit de mourir. Vous trouvez Voldemort et Peter Pettigrew ! Fuyez de n'importe quelle manière !", EnemiesPerDungeon.dungeon4()));
        allDungeon.add(new Dungeon("The Order of Phoenix", "C'est l'heure du BUSE (Brevet Universel de Sorcellerie Élémentaire) ! Dolores Ombrage veille sur vous. Votre objectif est de la distraire le temps que les feux d’artifice soient prêts à être utilisés.", EnemiesPerDungeon.dungeon5()));
        allDungeon.add(new Dungeon("The Half-Blood Prince", "Les Mangemorts attaquent Poudlard. Vous voulez les attaquer de face ou vous comptez faire une autre décision ?", EnemiesPerDungeon.dungeon6()));
        allDungeon.add(new Dungeon("The Deathly Hallows", "Il faut commencer à attaquer le problème à la source. Vous êtes face à Voldemort et à Bellatrix Lestrange ! Faites attention à Avada Kedavra !", EnemiesPerDungeon.dungeon7()));

        return allDungeon;

        //TODO: DONE
    }


}
