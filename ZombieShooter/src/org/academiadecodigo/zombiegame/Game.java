package org.academiadecodigo.zombiegame;

import org.academiadecodigo.zombiegame.gameobjects.GameObjectsFactory;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;
import org.academiadecodigo.zombiegame.player.Player;

public class Game {

    private int zombiesNr = 5;
    private Zombie[] zombieHoard;

    private Player player;
    private Background background;

    public Game(Player player){
        this.player = player;
        background = new Background(10, 180, 90);
    }

    public void init() {
        Background background = new Background(10, 800, 800);

        zombieHoard = new Zombie[zombiesNr];

        for (int z = 0; z < zombieHoard.length; z++) {
            zombieHoard[z] = GameObjectsFactory.makeZombie();
        }

    }

    public void start() throws InterruptedException {
        while(true){
        moveAllZombies();
        moveAllBullets();
        Thread.sleep(200);
        }

    }

    public void moveAllBullets() {

    }

    public void moveAllZombies() {

        for (Zombie z : zombieHoard) {

            z.moveZombie();
        }

    }

}
