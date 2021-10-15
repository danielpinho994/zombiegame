package org.academiadecodigo.zombiegame;

import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.CollisionDetector;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.gameobjects.GameObjectsFactory;
import org.academiadecodigo.zombiegame.gameobjects.Wall;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;
import org.academiadecodigo.zombiegame.player.Bullet;
import org.academiadecodigo.zombiegame.player.Player;

public class Game {

    private int zombiesNr = 10;
    private int wallNr = 25;
    private Zombie[] zombieHoard;
    private Bullet[] bulletsShot;
    private Wall[] walls;
    private Player player;

    private Background background;

    private CollisionDetector collisionDetector;

    public Game(Player player){
        this.player = player;
        background = new Background();
    }

    public void init() {
        background = new Background();
        walls = new Wall[wallNr];

        zombieHoard = new Zombie[zombiesNr];
        bulletsShot = player.getBullets();

        for (int z = 0; z < zombieHoard.length; z++) {
            zombieHoard[z] = GameObjectsFactory.makeZombies(player.getPos());
        }
        for (int w = 0; w < walls.length; w++) {
            walls[w] = GameObjectsFactory.makeWall();
        }

        collisionDetector = new CollisionDetector(zombieHoard, player);
        player.setCollisionDetector(collisionDetector);

        //check zombies overlap
        for (Zombie z : zombieHoard) {
            collisionDetector.checkZombieOverlap(z);
        }

    }

    public void start() throws InterruptedException {

        while(true){
            Thread.sleep(200);
            moveAllZombies();
            moveAllBullets();

        }

    }

    public void moveAllBullets(){
        for(Bullet b : bulletsShot) {
            if(b != null) {
                while (!b.getImpact()) {
                    b.moveBullet();
                }
            }
        }

    }

    public void moveAllZombies(){

            for (Zombie z : zombieHoard) {

                collisionDetector.checkCollisionZombie(z);

                z.moveZombie();

            }

    }

}
