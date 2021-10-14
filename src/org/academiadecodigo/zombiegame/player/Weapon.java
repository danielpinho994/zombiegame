package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;

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

    public void shoot(Direction direction, int col, int row) {
        if (shotsFired < magSize) {
            bullets[shotsFired] = new Bullet(col, row);
            bullets[shotsFired].move(direction);
            shotsFired++;
        } else {
            return;
        }

    }

    public Bullet[] getBullets() {
        return bullets;
    }

}

