package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Zones;

public class Movable extends GameObject {

    protected boolean forbiddenRight;
    protected boolean forbiddenLeft;
    protected boolean forbiddenUp;
    protected boolean forbiddenDown;

    public Movable( Zones spawnZone) {
        super(spawnZone);
    }

    protected void moveObject(Direction direction) {

        super.firstCol += Background.getCellSize() * direction.getXAxis();
        super.lastCol += Background.getCellSize() * direction.getXAxis();
        super.firstRow += Background.getCellSize() * direction.getYAxis();
        super.lastRow += Background.getCellSize() * direction.getYAxis();

        picture.translate(Background.getCellSize() * direction.getXAxis(), Background.getCellSize() * direction.getYAxis());
        pos.move(direction);
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
