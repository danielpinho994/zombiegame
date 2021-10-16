package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.gameobjects.player.Player;

public class CollisionDetector {

    private Zombie[] zombies;
    private Player player;

    public CollisionDetector(Zombie[] zombies, Player player) {

        this.zombies = zombies;
        this.player = player;

    }

    public void checkZombieOverlap(Zombie zombie) {

        for (Zombie z : zombies) {

            if (zombie.equals(z)) {
                continue;
            }

            if (zombie.getFirstCol() <= z.getLastCol() && zombie.getLastCol() >= z.getFirstCol() &&
                    zombie.getFirstRow() <= z.getLastRow() && zombie.getLastRow() >= z.getFirstRow()) {
                Position newPos = GameObjectsFactory.resetSpawnPos(zombie.getZone());
                zombie.setPosition(newPos);

                checkZombieOverlap(zombie);
            }
        }
    }

    public void checkCollisionPlayer() {
        player.resetForbidden();

        for (Zombie z : zombies) {
            if (z.getFirstCol() == player.getLastCol() && z.getFirstRow() <= player.getLastRow() && z.getLastRow() >= player.getFirstRow()) {
                player.forbidRight();
            }

            if (z.getLastCol() == player.getFirstCol() && z.getFirstRow() <= player.getLastRow() && z.getLastRow() >= player.getFirstRow()) {
                player.forbidLeft();
            }

            if (z.getFirstRow() == player.getLastRow() && z.getFirstCol() <= player.getLastCol() && z.getLastCol() >= player.getFirstCol()) {
                player.forbidDown();
            }

            if (z.getLastRow() == player.getFirstRow() && z.getFirstCol() <= player.getLastCol() && z.getLastCol() >= player.getFirstCol()) {
                player.forbidUp();
            }
        }
    }

    public void checkCollisionZombie(Zombie zombie) {

        zombie.resetForbidden();

        //Check zombie collision with player
        if (zombie.getFirstCol() == player.getLastCol() && zombie.getFirstRow() <= player.getLastRow() && zombie.getLastRow() >= player.getFirstRow()) {
            player.sufferHit(zombie.getHitPoints());
            zombie.forbidLeft();
        }

        if (zombie.getLastCol() == player.getFirstCol() && zombie.getFirstRow() <= player.getLastRow() && zombie.getLastRow() >= player.getFirstRow()) {
            player.sufferHit(zombie.getHitPoints());
            zombie.forbidRight();
        }

        if (zombie.getFirstRow() == player.getLastRow() && zombie.getFirstCol() <= player.getLastCol() && zombie.getLastCol() >= player.getFirstCol()) {
            player.sufferHit(zombie.getHitPoints());
            zombie.forbidUp();
        }

        if (zombie.getLastRow() == player.getFirstRow() && zombie.getFirstCol() <= player.getLastCol() && zombie.getLastCol() >= player.getFirstCol()) {
            player.sufferHit(zombie.getHitPoints());
            zombie.forbidDown();
        }

        //check zombie collision with other zombies
        for (Zombie z : zombies){

            if (zombie.equals(z)) {
                continue;
            }

            if (zombie.getFirstCol() == z.getLastCol() && zombie.getFirstRow() < z.getLastRow() && zombie.getLastRow() > z.getFirstRow()) {
                zombie.forbidLeft();
            }

            if (zombie.getLastCol() == z.getFirstCol() && zombie.getFirstRow() < z.getLastRow() && zombie.getLastRow() > z.getFirstRow()) {
                zombie.forbidRight();
            }

            if (zombie.getFirstRow() == z.getLastRow() && zombie.getFirstCol() < z.getLastCol() && zombie.getLastCol() > z.getFirstCol()) {
                zombie.forbidUp();
            }

            if (zombie.getLastRow() == z.getFirstRow() && zombie.getFirstCol() < z.getLastCol() && zombie.getLastCol() > z.getFirstCol()) {
                zombie.forbidDown();
            }
        }
    }
}
