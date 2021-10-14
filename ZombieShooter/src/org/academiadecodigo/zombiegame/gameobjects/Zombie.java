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

    public Zombie(Position pos, Position playerPos) {

        this.pos = pos;
        this.playerPos = playerPos;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = 3 * Background.getCellSize();
        int width = 3 * Background.getCellSize();

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

    public void setForbiddenRight(boolean forbiddenRight) {
        this.forbiddenRight = forbiddenRight;
    }

    public void setForbiddenLeft(boolean forbiddenLeft) {
        this.forbiddenLeft = forbiddenLeft;
    }

    public void setForbiddenUp(boolean forbiddenUp) {
        this.forbiddenUp = forbiddenUp;
    }

    public void setForbiddenDown(boolean forbiddenDown) {
        this.forbiddenDown = forbiddenDown;
    }

    public Direction getLastDirection() {
        return lastDirection;
    }

}
