package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Zombie {

    private Position pos;
    private Position playerPos;
    private int hitPoints = 10;
    private int health;
    private Zones zone;

    private Direction lastDirection;

    private boolean forbiddenRight;
    private boolean forbiddenLeft;
    private boolean forbiddenUp;
    private boolean forbiddenDown;

    private Rectangle zombiePic;

    //number of rows and cols of rectangle
    public static final int POS_SIZE = 10;

    private int firstCol;
    private int lastCol;
    private int firstRow;
    private int lastRow;

    public Zombie(Position pos, Position playerPos, Zones zone) {

        this.playerPos = playerPos;
        this.zone = zone;

        setPosition(pos);
    }

    public void setPosition(Position pos) {
        this.pos = pos;

        firstCol = pos.getCol();
        lastCol = pos.getCol() + POS_SIZE;
        firstRow = pos.getRow();
        lastRow = pos.getRow() + POS_SIZE;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = POS_SIZE * Background.getCellSize();
        int width = POS_SIZE * Background.getCellSize();

        if (zombiePic != null) {
            zombiePic.delete();
        }

        zombiePic = new Rectangle(x, y, width, height);
        zombiePic.draw();
        zombiePic.fill();
    }

    public void moveZombie() {

        int targetCol = playerPos.getCol();
        int targetRow = playerPos.getRow();

        if (targetCol > pos.getCol()) {
            moveRight();
        }

        if (targetCol < pos.getCol()) {
            moveLeft();
        }

        if (targetRow < pos.getRow()) {
            moveUp();
        }

        if (targetRow > pos.getRow()) {
            moveDown();
        }

    }

    public void moveRight() {
        if (forbiddenRight) {
            return;
        }

        firstCol++;
        lastCol++;

        pos.move(Direction.RIGHT);
        zombiePic.translate(Background.getCellSize(), 0);

        lastDirection = Direction.RIGHT;
        return;
    }

    public void moveLeft() {
        if (forbiddenLeft) {
            return;
        }

        firstCol--;
        lastCol--;

        pos.move(Direction.LEFT);
        zombiePic.translate(-Background.getCellSize(), 0);

        lastDirection = Direction.LEFT;
        return;
    }

    public void moveUp() {
        if (forbiddenUp) {
            return;
        }

        firstRow--;
        lastRow--;

        pos.move(Direction.UP);
        zombiePic.translate(0, -Background.getCellSize());

        lastDirection = Direction.UP;
    }

    public void moveDown() {
        if (forbiddenDown) {
            return;
        }

        firstRow++;
        lastRow++;

        pos.move(Direction.DOWN);
        zombiePic.translate(0, Background.getCellSize());

        lastDirection = Direction.DOWN;
        return;
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

    public int getHitPoints() {
        return hitPoints;
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

    public Zones getZone() {
        return zone;
    }
}
