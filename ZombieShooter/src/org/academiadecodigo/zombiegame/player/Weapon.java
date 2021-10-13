package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.zombiegame.Position;

public class Weapon {

    private Position pos;
    private int magSize;
    private Bullet[] mag;

    public Weapon(){

        magSize=10;
        mag = new Bullet[magSize];
        for( int i = 0 ; i < magSize ; i++ ){

            mag[i] = new Bullet();

        }
    }

    public void Reload(){

    }
    public void shoot(){

        Bullet bullet = new Bullet();



    }

}
