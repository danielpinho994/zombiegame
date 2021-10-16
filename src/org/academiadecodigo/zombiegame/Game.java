package org.academiadecodigo.zombiegame;

import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.GameOver;
import org.academiadecodigo.zombiegame.gameobjects.CollisionDetector;
import org.academiadecodigo.zombiegame.gameobjects.GameObjectsFactory;
import org.academiadecodigo.zombiegame.gameobjects.Wall;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;
import org.academiadecodigo.zombiegame.gameobjects.player.Bullet;
import org.academiadecodigo.zombiegame.gameobjects.player.Player;

public class Game {

    private final static int ZOMBIES_NR = 20;
    private int wallNr = 25;

    private Zombie[] zombieHoard;
    private Bullet[] bulletsShot;
    private Wall[] walls;
    private Player player;

    private Background background;

    private CollisionDetector collisionDetector;

    public void init() {
        player = new Player();

        background = new Background();

        walls = new Wall[wallNr];

        zombieHoard = new Zombie[ZOMBIES_NR];

        bulletsShot = player.getBullets();

        for (int z = 0; z < zombieHoard.length; z++) {
            zombieHoard[z] = GameObjectsFactory.makeZombie(player.getPos());
        }

        for (int w = 0; w < walls.length; w++) {
            walls[w] = GameObjectsFactory.makeWall();
        }

        collisionDetector = new CollisionDetector(zombieHoard, player, bulletsShot, walls);

        player.setCollisionDetector(collisionDetector);

        //check zombies overlap
        for (Zombie z : zombieHoard) {
            collisionDetector.checkOverlap(z);
        }

    }

    public void start() throws InterruptedException {

        player.setKeys();

        while(true){
            Thread.sleep(17);
            if(player.getHealth()<=0){
                GameOver gameOver = new GameOver();
            }

            for (int i = 0; i < 4; i++) { //speed
                moveAllBullets();
            }

            for (int i = 0; i < 2; i++) { //speed
                player.move();
            }

            moveAllZombies();
        }

    }

    public void moveAllBullets(){
        for(Bullet b : bulletsShot) {
            if(b != null && !b.isImpacted()) {
                collisionDetector.checkBulletCollision(b);
                b.moveBullet();
            }
        }
    }

    public void moveAllZombies(){
            for (Zombie z : zombieHoard) {
                collisionDetector.checkZombieCollision(z);
                z.moveZombie();
            }
    }

}
