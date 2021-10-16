package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Zombie extends Movable{

    private Position playerPos;
    private int hitPoints = 10;
    private Zones zone;

    public Zombie(Position pos, Position playerPos, Zones zone) {
        super(10);

        this.playerPos = playerPos;
        this.zone = zone;

        setPosition(pos);
    }

    public void setPosition(Position pos) {
        this.pos = pos;

        firstCol = pos.getCol();
        lastCol = pos.getCol() + posSize;
        firstRow = pos.getRow();
        lastRow = pos.getRow() + posSize;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = posSize * Background.getCellSize();
        int width = posSize * Background.getCellSize();

        if (picture != null) {
            picture.delete();
        }

        picture = new Rectangle(x, y, width, height);
        picture.draw();
        picture.fill();
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

    @Override
    public void moveRight() {
        if (forbiddenRight) {
            return;
        }

        super.moveRight();

    }

    @Override
    public void moveLeft() {
        if (forbiddenLeft) {
            return;
        }

        super.moveLeft();

    }

    @Override
    public void moveUp() {
        if (forbiddenUp) {
            return;
        }

        super.moveUp();

    }

    @Override
    public void moveDown() {
        if (forbiddenDown) {
            return;
        }

        super.moveDown();

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public Zones getZone() {
        return zone;
    }
}
