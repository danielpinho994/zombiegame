package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.zombiegame.Position;

public class Weapon {

    private Position pos;
    private int magSize;
    private Bullet[] bullets;

    public Weapon(){

        magSize=10;
        bullets = new Bullet[magSize];
        for( int i = 0 ; i < magSize ; i++ ){

            bullets[i] = new Bullet();

        }
    }

    public void Reload(){

    }
    public void shoot(){

        Bullet bullet = new Bullet();




    }

}
