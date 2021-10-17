package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.gameobjects.player.Bullet;
import org.academiadecodigo.zombiegame.gameobjects.player.Player;
import org.academiadecodigo.zombiegame.gameobjects.walls.Wall;
import org.academiadecodigo.zombiegame.gameobjects.zombies.Zombie;

public class CollisionDetector{

    private GameObject[] allZombiesAndWalls;

    private Zombie[] zombies;
    private Player player;
    private Bullet[] bullets;
    private Wall[] walls;

    public CollisionDetector(Zombie[] zombies, Player player, Bullet[] bullets, Wall[] walls) {

        this.zombies = zombies;
        this.player = player;
        this.bullets = bullets;
        this.walls = walls;

        int length = zombies.length + walls.length;
        allZombiesAndWalls = new GameObject[length];

        for (int i = 0; i < zombies.length; i++) {
            allZombiesAndWalls[i] = zombies[i];
        }

        int j = 0;
        for (int i = zombies.length; i < zombies.length + walls.length; i++) {
            allZombiesAndWalls[i] = walls[j];
            j++;
        }



    }

    public void checkOverlap(Zombie zombie) {

        for (GameObject obj : allZombiesAndWalls) {

            if (zombie.equals(obj)) {
                continue;
            }

            if (zombie.getFirstCol() <= obj.getLastCol() && zombie.getLastCol() >= obj.getFirstCol() &&
                    zombie.getFirstRow() <= obj.getLastRow() && zombie.getLastRow() >= obj.getFirstRow()) {

                Position newPos = GameObjectsFactory.resetSpawn(zombie.getSpawnZone());

                zombie.newPicture(newPos, zombie.getPicturePath());

                checkOverlap(zombie);
            }
        }
    }

    public void checkBulletCollision(Bullet bullet) {

        //check bullet collision with zombies and walls
        for (GameObject obj : allZombiesAndWalls) {

            if (bullet.getFirstCol() <= obj.getLastCol() && bullet.getLastCol() >= obj.getFirstCol() &&
                    bullet.getFirstRow() <= obj.getLastRow() && bullet.getLastRow() >= obj.getFirstRow()) {

                bullet.destroyBullet();

                if (obj instanceof Zombie) {
                    ((Zombie) obj).hit();
                }
            }
        }

    }

    public void checkPlayerCollision() {
        player.resetForbidden();

        //check player collision with zombies and walls

        for (GameObject obj : allZombiesAndWalls) {
            if (obj.getFirstCol() == player.getLastCol() && obj.getFirstRow() <= player.getLastRow() && obj.getLastRow() >= player.getFirstRow()) {
                player.forbidRight();
            }

            if (obj.getLastCol() == player.getFirstCol() && obj.getFirstRow() <= player.getLastRow() && obj.getLastRow() >= player.getFirstRow()) {
                player.forbidRight();
            }

            if (obj.getFirstRow() == player.getLastRow() && obj.getFirstCol() <= player.getLastCol() && obj.getLastCol() >= player.getFirstCol()) {
                player.forbidDown();
            }

            if (obj.getLastRow() == player.getFirstRow() && obj.getFirstCol() <= player.getLastCol() && obj.getLastCol() >= player.getFirstCol()) {
                player.forbidUp();
            }
        }
    }

    public void checkZombieCollision(Zombie zombie) {

        zombie.resetForbidden();

        //Check zombie collision with player
        if (zombie.getFirstCol() == player.getLastCol() && zombie.getFirstRow() <= player.getLastRow() && zombie.getLastRow() >= player.getFirstRow()) {
            player.sufferHit(zombie.getHitPoints());

            System.out.println("right hit");

            zombie.forbidLeft();
        }

        if (zombie.getLastCol() == player.getFirstCol() && zombie.getFirstRow() <= player.getLastRow() && zombie.getLastRow() >= player.getFirstRow()) {
            player.sufferHit(zombie.getHitPoints());

            System.out.println("left hit");

            zombie.forbidRight();
        }

        if (zombie.getFirstRow() == player.getLastRow() && zombie.getFirstCol() <= player.getLastCol() && zombie.getLastCol() >= player.getFirstCol()) {
            player.sufferHit(zombie.getHitPoints());

            System.out.println("down hit");

            zombie.forbidUp();
        }

        if (zombie.getLastRow() == player.getFirstRow() && zombie.getFirstCol() <= player.getLastCol() && zombie.getLastCol() >= player.getFirstCol()) {
            player.sufferHit(zombie.getHitPoints());

            System.out.println("up hit");

            zombie.forbidDown();
        }

        //check zombie collision with zombies and walls
        for (GameObject obj : allZombiesAndWalls){

            if (zombie.equals(obj)) {
                continue;
            }

            if (zombie.getFirstCol() == obj.getLastCol() && zombie.getFirstRow() < obj.getLastRow() && zombie.getLastRow() > obj.getFirstRow()) {
                zombie.forbidLeft();
            }

            if (zombie.getLastCol() == obj.getFirstCol() && zombie.getFirstRow() < obj.getLastRow() && zombie.getLastRow() > obj.getFirstRow()) {
                zombie.forbidRight();
            }

            if (zombie.getFirstRow() == obj.getLastRow() && zombie.getFirstCol() < obj.getLastCol() && zombie.getLastCol() > obj.getFirstCol()) {
                zombie.forbidUp();
            }

            if (zombie.getLastRow() == obj.getFirstRow() && zombie.getFirstCol() < obj.getLastCol() && zombie.getLastCol() > obj.getFirstCol()) {
                zombie.forbidDown();
            }
        }
    }
}
