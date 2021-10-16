package org.academiadecodigo.zombiegame.field;

public class Position {

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    private int col;
    private int row;

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
                row--;
                break;
            case DOWN:
                row++;
                break;
            case LEFT:
                col--;
                break;
            case RIGHT:
                col++;
        }

    }

}
