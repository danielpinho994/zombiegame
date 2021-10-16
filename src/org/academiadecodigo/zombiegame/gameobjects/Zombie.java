package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Zombie extends Movable{

    private Position playerPos;

    private String picturePath = " ";

    private int hitPoints = 10;

    public Zombie(Position pos, Position playerPos, Zones spawnZone) {
        super(30, spawnZone);

        this.playerPos = playerPos;

        setPosition(pos, picturePath);
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
}
