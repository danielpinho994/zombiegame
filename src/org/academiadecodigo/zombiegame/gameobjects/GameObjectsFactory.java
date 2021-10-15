package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public abstract class GameObjectsFactory {

    private static int zombieCounter;

    public static Zombie makeZombies(Position playerPos) {

        //Select zone
        Zones z = Zones.values()[zombieCounter];
        //change zone if centre
        if (z == Zones.E) {
            zombieCounter++;
            z = Zones.values()[zombieCounter];
        }
        //Add counter for next zone
        zombieCounter++;
        if (zombieCounter == Zones.values().length) {
            zombieCounter = 0;
        }

        //Create zombie random position in selected zone
        Position zombiePos = new Position(z.getFirstCol(), z.getLastCol(), z.getFirstRow(), z.getLastRow());

        return new Zombie(zombiePos, playerPos);

    }

}
