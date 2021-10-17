package org.academiadecodigo.zombiegame.gameobjects.zombies;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;
import org.academiadecodigo.zombiegame.gameobjects.Movable;

public abstract class Zombie extends Movable {

    protected Position playerPos;

    protected Direction picToUseUpDown;
    protected Direction picToUseLeftRight;

    public Zombie(Position pos, Position playerPos, Zones spawnZone) {
        super(spawnZone);

        this.playerPos = playerPos;
    }

    public abstract int getHitPoints();

    public abstract void hit();

    public abstract void moveZombie();

    public abstract int getHealth();

    public abstract String getPicturePath();
}
