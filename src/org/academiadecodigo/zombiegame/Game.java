package org.academiadecodigo.zombiegame;

import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.CollisionDetector;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.gameobjects.GameObjectsFactory;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;
import org.academiadecodigo.zombiegame.player.Bullet;
import org.academiadecodigo.zombiegame.player.Player;

public class Game {

    private int zombiesNr = 20;
    private Zombie[] zombieHoard;

    private Player player;

    private Background background;

    private CollisionDetector collisionDetector;

    public Game(Player player){
        this.player = player;
        background = new Background();
    }

    public void init() {
        background = new Background();

        zombieHoard = new Zombie[zombiesNr];

        for (int z = 0; z < zombieHoard.length; z++) {
            zombieHoard[z] = GameObjectsFactory.makeZombies(player.getPos());
        }

        collisionDetector = new CollisionDetector(zombieHoard);

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

            for (Zombie z : zombieHoard) {
                Thread.sleep(20);

                //collisionDetector.checkCollisionBullets(z);
                //collisionDetector.checkCollisionPlayer(z);
                collisionDetector.checkCollisionZombie(z);

                z.moveZombie();

                z.resetForbidden();
            }

    }

}
