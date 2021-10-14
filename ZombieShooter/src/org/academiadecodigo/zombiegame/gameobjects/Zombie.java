package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;

public class Zombie {

    private Position pos;
    private Position playerPos;
    private int health;

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
            pos.move(Direction.RIGHT);
            zombiePic.translate(Background.getCellSize(), 0);
            return;
        }

        if (targetCol < pos.getCol()) {
            pos.move(Direction.LEFT);
            zombiePic.translate(-Background.getCellSize(), 0);
            return;
        }

        if (targetRow < pos.getRow()) {
            pos.move(Direction.UP);
            zombiePic.translate(0, -Background.getCellSize());
            return;
        }

        if (targetRow > pos.getRow()) {
            pos.move(Direction.DOWN);
            zombiePic.translate(0, Background.getCellSize());
            return;
        }

    }

}
