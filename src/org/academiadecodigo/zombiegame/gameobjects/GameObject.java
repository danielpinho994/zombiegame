package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Game;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class GameObject {
    //number of rows and cols of rectangle
    protected Position pos;

    protected int posSizeX;
    protected int posSizeY;

    protected int firstCol;
    protected int lastCol;
    protected int firstRow;
    protected int lastRow;

    protected Zones spawnZone;

    protected Picture picture;
    protected String picturePath;

    public GameObject(int posSizeX, int posSizeY, Zones spawnZone) {
        this.posSizeX = posSizeX;
        this.posSizeY = posSizeY;

        this.spawnZone = spawnZone;
    }

    protected void setPosition(Position pos, String picturePath) {

        if (picture != null) {
            picture.delete();
        }

        this.pos = pos;

        firstCol = pos.getCol();
        lastCol = pos.getCol() + posSizeX;
        firstRow = pos.getRow();
        lastRow = pos.getRow() + posSizeY;

        if (lastCol >= Background.getCols()) {
            pos.setCol(Background.getCols() - posSizeX);
        }

        if (lastRow >= Background.getRows()) {
            pos.setRow(Background.getRows() - posSizeY);
        }

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = posSizeY * Background.getCellSize();
        int width = posSizeX * Background.getCellSize();

        picture = new Picture(x, y, picturePath);
        picture.draw();
    }

    public String getPicturePath() {
        return picturePath;
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

    public Zones getSpawnZone() {
        return spawnZone;
    }
}
