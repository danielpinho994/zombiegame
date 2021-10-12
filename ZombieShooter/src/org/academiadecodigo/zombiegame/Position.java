package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;

public class Position {

    private int col;
    private int row;


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Position (){
        col = (int) Math.floor(Math.random() * Background.getCols());
        row = (int) Math.floor(Math.random() * Background.getRows());
    }

    public Position(int col, int row) {

        this.col = col;
        this.row = row;
    }

    public void move(Shape shape) {
        
        //shape.translate(10,0);
    }

    /*
    public Position(Background background) {

        this.background = background;

        col = ()
    }
    */


}
