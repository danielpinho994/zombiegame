package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.Position;

public class GameObjectsFactory {

    public static Zombie makeZombie() {
        return new Zombie(new Position());
    }

}
