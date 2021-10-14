package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;

public class Zombie {

    private Position pos;
    private Position playerPos;
    private int health;

    private Direction lastDirection;

    private boolean forbiddenRight;
    private boolean forbiddenLeft;
    private boolean forbiddenUp;
    private boolean forbiddenDown;

    private Rectangle zombiePic;

    //number of rows and cols of rectangle
    private int posSize = 3;

    private int firstCol;
    private int lastCol;
    private int firstRow;
    private int lastRow;

    public Zombie(Position pos, Position playerPos) {

        this.pos = pos;
        this.playerPos = playerPos;

        firstCol = pos.getCol();
        lastCol = pos.getCol() + posSize;
        firstRow = pos.getRow();
        lastRow = pos.getRow() + posSize;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = posSize * Background.getCellSize();
        int width = posSize * Background.getCellSize();

        zombiePic = new Rectangle(x, y, width, height);
        zombiePic.draw();
        zombiePic.fill();
    }

    public void moveZombie() {

        int targetCol = playerPos.getCol();
        int targetRow = playerPos.getRow();

        if (targetCol > pos.getCol()) {
            if (forbiddenRight) {
                return;
            }

            pos.move(Direction.RIGHT);
            zombiePic.translate(Background.getCellSize(), 0);

            lastDirection = Direction.RIGHT;
            return;
        }

        if (targetCol < pos.getCol()) {
            if (forbiddenLeft) {
                return;
            }

            pos.move(Direction.LEFT);
            zombiePic.translate(-Background.getCellSize(), 0);

            lastDirection = Direction.LEFT;
            return;
        }

        if (targetRow < pos.getRow()) {
            if (forbiddenUp) {
                return;
            }

            pos.move(Direction.UP);
            zombiePic.translate(0, -Background.getCellSize());

            lastDirection = Direction.UP;
            return;
        }

        if (targetRow > pos.getRow()) {
            if (forbiddenDown) {
                return;
            }

            pos.move(Direction.DOWN);
            zombiePic.translate(0, Background.getCellSize());

            lastDirection = Direction.DOWN;
            return;
        }

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
