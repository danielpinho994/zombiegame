package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.Background;

public class GameObjectsFactory {

    public static Zombie makeZombie(Background background) {
        return new Zombie(background.makeGridPosition());
    }

}
