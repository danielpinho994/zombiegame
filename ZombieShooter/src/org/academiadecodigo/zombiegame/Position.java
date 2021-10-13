package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;

public class Position {

    private int col;
    private int row;

    public void setPos(int col , int row){
        this.col = col;
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }


    //Zombie Position
    public Position (int[] zonePos){
           col = zonePos[0];
           row = zonePos[1];
    }


    //Player Position
    public Position(int col, int row) {

        this.col = col;
        this.row = row;
    }


    public void move(MovePosition direction) {

        switch (direction) {

            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }

    }

    private void moveUp(){
        setRow(getRow()-1);
    }

    private void moveDown(){
        setRow(getRow()+1);
    }

    private void moveLeft(){
        setCol(getCol()-1);
    }

    private void moveRight(){
        setCol(getCol()+1);
    }


    /*
    public Position(Background background) {

        this.background = background;

        col = ()
    }
    */


}
