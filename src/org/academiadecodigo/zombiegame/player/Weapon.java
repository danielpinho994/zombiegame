package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.gameobjects.GameObjectsFactory;

public class Weapon {

    private Position pos;
    private int magSize;
    private Bullet[] bullets;
    private int shotsFired;

    public Weapon() {

        magSize = 10;
        bullets = new Bullet[magSize];
        shotsFired = 0;
    }

    public void Reload() {

    }

    public void shoot(Direction direction, Position playerPos) {
        if (shotsFired < magSize) {
            bullets[shotsFired] = GameObjectsFactory.makeBullets(playerPos);
            bullets[shotsFired].loadBullet(direction);
            shotsFired++;
        } else {
            return;
        }

    }

    public Bullet[] getBullets() {
        return bullets;
    }

}

