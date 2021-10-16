package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Zombie extends Movable{

    private Position playerPos;

    private String picturePath = " ";

    private int hitPoints = 10;

    public Zombie(Position pos, Position playerPos, Zones spawnZone) {
        super(30, 30, spawnZone);

        this.playerPos = playerPos;

        setPosition(pos, picturePath);
    }

    public void moveZombie() {

        int targetCol = playerPos.getCol();
        int targetRow = playerPos.getRow();

        if (targetCol > pos.getCol() && !forbiddenRight) {
            super.moveObject(Direction.RIGHT);
        }

        if (targetCol < pos.getCol() && !forbiddenLeft) {
            super.moveObject(Direction.LEFT);
        }

        if (targetRow < pos.getRow() && !forbiddenUp) {
            super.moveObject(Direction.UP);
        }

        if (targetRow > pos.getRow() && !forbiddenDown) {
            super.moveObject(Direction.DOWN);
        }

    }

    public int getHitPoints() {
        return hitPoints;
    }
}
