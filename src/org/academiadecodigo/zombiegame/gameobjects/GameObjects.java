package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.Game;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Position;

public class GameObjects{
    //number of rows and cols of rectangle
    protected Position pos;
    protected int posSize;
    protected int firstCol;
    protected int lastCol;
    protected int firstRow;
    protected int lastRow;

    protected Rectangle picture;

    public GameObjects(int posSize) {
        this.posSize = posSize;
    }

    protected void positionAndPicture(String picturePath) {

        firstCol = pos.getCol();
        lastCol = pos.getCol() + posSize;
        firstRow = pos.getRow();
        lastRow = pos.getRow() + posSize;

        if (lastCol >= Background.getCols()) {
            pos.setCol(Background.getCols() - posSize);
        }

        if (lastRow >= Background.getRows()) {
            pos.setRow(Background.getRows() - posSize);
        }

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = posSize * Background.getCellSize();
        int width = posSize * Background.getCellSize();

        picture = new Rectangle(x, y, width, height);
        picture.draw();
        picture.setColor(Color.BLUE);
        picture.fill();
    }

    public Position getPos() {
        return pos;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public int getLastCol() {
        return lastCol;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

}
