package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.zombiegame.Position;

public class Weapon {

    private Position pos;
    private int magSize;
    private Bullet[] bullets;
    private int shotsFired;

    public Weapon() {

        magSize = 10;
        bullets = new Bullet[magSize];
        /**
        for( int i = 0 ; i < magSize ; i++ ){

            bullets[i] = new Bullet();
            shotsFired = 0;

        }
         */
    }

    public void Reload() {

    }
    public void shoot(String direction, int col, int row) {
        if (shotsFired <= magSize) {
            bullets[shotsFired] = new Bullet(col, row);
            bullets[shotsFired].move(direction);
            shotsFired++;
        }

    }

}

