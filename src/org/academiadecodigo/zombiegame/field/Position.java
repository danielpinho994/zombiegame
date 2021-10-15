package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.zombiegame.field.Direction;
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

    //Bullet Position
    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    //Player && GameObjects Position
    public Position(int minCol, int maxCol, int minRow, int maxRow) {

        this.col = minCol + (int)(Math.random() * ((maxCol - minCol) + 1));
        this.row = minRow + (int)(Math.random() * ((maxRow - minRow) + 1));

        if (col >= Background.getCols() - Zombie.POS_SIZE) {
            col = Background.getCols() - Zombie.POS_SIZE;
        }

        if (row >= Background.getRows() - Zombie.POS_SIZE) {
            row = Background.getRows() - Zombie.POS_SIZE;
        }

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
