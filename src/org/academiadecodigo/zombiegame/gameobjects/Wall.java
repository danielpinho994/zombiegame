package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Wall extends GameObject{

    private Rectangle wall;

    public Wall(Position pos,   Zones zone ){
        super(1, 1, zone);

        super.pos = pos;

        getRandomSize();
        setPosition(pos,"picture path");

    }

    private void getRandomSize(){

        int random = (int) Math.floor(Math.random()*2);

        switch(random){

            case 0:
                super.posSizeX = 4;
                super.posSizeY = (int) (Math.random()*30) + 10;
                break;
            case 1:
                super.posSizeX = (int) (Math.random()*30) + 10;
                super.posSizeY = 4;
                break;
        }
        lastCol = pos.getCol() + posSizeX;
        lastRow = pos.getRow() + posSizeY;
    }
}
