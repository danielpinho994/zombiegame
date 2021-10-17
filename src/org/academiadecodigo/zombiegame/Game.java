package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.GameOver;
import org.academiadecodigo.zombiegame.field.HealthBar;
import org.academiadecodigo.zombiegame.gameobjects.CollisionDetector;
import org.academiadecodigo.zombiegame.gameobjects.GameObjectsFactory;
import org.academiadecodigo.zombiegame.gameobjects.walls.Wall;
import org.academiadecodigo.zombiegame.gameobjects.zombies.Zombie;
import org.academiadecodigo.zombiegame.gameobjects.player.Bullet;
import org.academiadecodigo.zombiegame.gameobjects.player.Player;

public class Game {

    private final static int ZOMBIES_NR = 9;
    private int wallNr = 10;

    private Zombie[] zombieHoard;
    private Bullet[] bulletsShot;
    private Wall[] walls;
    private Player player;
    private Sound backgroundMusic = new Sound("sounds/backgroundMusic.wav");
    private HealthBar hpBar;
    private Menu menu;

    private Background background;

    private CollisionDetector collisionDetector;

    public Game() {
        this.player = new Player();
    }

    public void init() {

        Rectangle roundPic = new Rectangle();
        roundPic.draw();

        for (int i = 0; i < 1000; i ++) {
            if (i == 1000 - 1) {
                roundPic.delete();
            }
        }

        background = new Background();

        walls = new Wall[wallNr];

        zombieHoard = new Zombie[ZOMBIES_NR];

        bulletsShot = player.getBullets();

        for (int z = 0; z < ZOMBIES_NR; z++) {
            zombieHoard[z] = GameObjectsFactory.makeZombie(player.getPos());
        }

        for (int w = 0; w < wallNr; w++) {
            walls[w] = GameObjectsFactory.makeWall();
        }

        hpBar = new HealthBar();
        collisionDetector = new CollisionDetector(zombieHoard, player, bulletsShot, walls, hpBar);

        player.setCollisionDetector(collisionDetector);

        //check zombies overlap
        for (Zombie z : zombieHoard) {
            collisionDetector.checkOverlap(z);
        }

    }

    public void newRound() {
        /*
        background = null;
        walls = null;
        zombieHoard = null;
        bulletsShot = null;
        collisionDetector = null;

        init()*/
    }

    public void start() throws InterruptedException {
        player.setPlayerReady();
        backgroundMusic.play(true);

        while (true) {
            Thread.sleep(17);

            if (player.getHealth() <= 0) {
                GameOver gameOver = new GameOver();
                for(int i = 0 ; i<100 ; i++){
                    Thread.sleep(200);
                }
                menu = new Menu();
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

    public void moveAllBullets() {
        for (Bullet b : bulletsShot) {
            if (b != null && !b.isImpacted()) {
                collisionDetector.checkBulletCollision(b);
                b.moveBullet();
            }
        }
    }

    public void moveAllZombies() {
        int zombiesDead = 0;
        for (Zombie z : zombieHoard) {

            if (z.getHealth() == 0) {
                zombiesDead++;
                continue;
            }

            collisionDetector.checkZombieCollision(z);
            z.moveZombie();
        }
        if (zombiesDead == ZOMBIES_NR) {
            newRound();
        }
    }
}
