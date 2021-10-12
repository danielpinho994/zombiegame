package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;

public class Position {

    private int col;



    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    private int row;

    public Position(int col, int row) {

        this.col = col;
        this.row = row;
    }

    public void move(Shape shape) {
        
        shape.translate(10,0);
    }

    /*
    public Position(Background background) {

        this.background = background;

        col = ()
    }
    */


}
