package org.academiadecodigo.zombiegame;

import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.gameobjects.GameObjectsFactory;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;
import org.academiadecodigo.zombiegame.player.Player;

public class Game {

    private int zombiesNr = 8;
    private Zombie[] zombieHoard;

    private Player player;

    private Background background;

    public Game(Player player){
        this.player = player;
        background = new Background();
    }

    public void init() {
        Background background = new Background();

        zombieHoard = new Zombie[zombiesNr];

        for (int z = 0; z < zombieHoard.length; z++) {
            zombieHoard[z] = GameObjectsFactory.makeZombies(player.getPos());
        }

    }

    public void start() throws InterruptedException {
        while(true){
            moveAllZombies();
            moveAllBullets();
        }

    }

    public void moveAllBullets() {

    }

    public void moveAllZombies() throws InterruptedException {

        while (true) {

            for (Zombie z : zombieHoard) {
                Thread.sleep(20);

                z.moveZombie();
            }

        }
    }

}
