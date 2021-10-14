package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.zombiegame.field.Direction;

public class Position {

    private int col;
    private int row;

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

    //Bullet Position
    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    //Player && GameObjects Position
    public Position(int minCol, int maxCol, int minRow, int maxRow) {

        this.col = minCol + (int)(Math.random() * ((maxCol - minCol) + 1));
        this.row = minRow + (int)(Math.random() * ((maxRow - minRow) + 1));

    }

    public void move(Direction direction) {

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

}
