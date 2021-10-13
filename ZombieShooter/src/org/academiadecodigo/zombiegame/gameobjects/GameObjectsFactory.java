package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.Position;
import org.academiadecodigo.zombiegame.Zones;

public class GameObjectsFactory {

    public static Zombie makeZombie() {
        return new Zombie(new Position(Zones.getZone()));
    }



}
