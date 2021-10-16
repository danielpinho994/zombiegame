package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Zones;

public class Movable extends GameObject {

    protected boolean forbiddenRight;
    protected boolean forbiddenLeft;
    protected boolean forbiddenUp;
    protected boolean forbiddenDown;

    public Movable(int posSize, Zones spawnZone) {
        super(posSize, posSize, spawnZone);
    }

    public void moveRight() {

        firstCol++;
        lastCol++;

        pos.move(Direction.RIGHT);
        picture.translate(Background.getCellSize(), 0);

    }

    public void moveLeft() {

        firstCol--;
        lastCol--;

        pos.move(Direction.LEFT);
        picture.translate(-Background.getCellSize(), 0);

    }

    public void moveUp() {

        firstRow--;
        lastRow--;

        pos.move(Direction.UP);
        picture.translate(0, -Background.getCellSize());

    }

    public void moveDown() {

        firstRow++;
        lastRow++;

        pos.move(Direction.DOWN);
        picture.translate(0, Background.getCellSize());

    }

    public void resetForbidden() {
        forbiddenDown = false;
        forbiddenLeft = false;
        forbiddenUp = false;
        forbiddenRight = false;
    }

    public void forbidRight() {
        forbiddenRight = true;
    }

    public void forbidLeft() {
        forbiddenLeft = true;
    }

    public void forbidUp() {
        forbiddenUp = true;
    }

    public void forbidDown() {
        forbiddenDown = true;
    }

}
