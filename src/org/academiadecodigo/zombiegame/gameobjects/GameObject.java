package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Game;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public abstract class GameObject {
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

    public GameObject(Zones spawnZone) {

        this.spawnZone = spawnZone;
    }

    protected void newPicture(Position pos, String picturePath) {

        if (picture != null) {
            picture.delete();
        }

        this.pos = pos;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        picture = new Picture(x, y, picturePath);
        picture.draw();

        posSizeX = picture.getWidth() * Background.getCellSize();
        posSizeY = picture.getHeight() * Background.getCellSize();
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

    public Position getPos() {
        return pos;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public int getLastCol() {
        return lastCol;
    }


}
