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

    public GameObject(Zones spawnZone) {

        this.spawnZone = spawnZone;
    }

    public void changePic(String picturePath) {
        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        picture.delete();
        picture = new Picture(x, y, picturePath);
        picture.draw();
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

    protected void newPicture(Position pos, String picturePath) {

        if (picture != null) {
            picture.delete();
        }

        this.pos = pos;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        picture = new Picture(x, y, picturePath);

        posSizeX = picture.getWidth() * Background.getCellSize();
        posSizeY = picture.getHeight() * Background.getCellSize();

        picture.draw();
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
