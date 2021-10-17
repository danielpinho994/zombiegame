package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Zombie extends Movable {

    private Position playerPos;

    private String picturePath = "assets/zombies/zombieright.png";

    private Direction picToUseUpDown;
    private Direction picToUseLeftRight;
    private PictureDirections picdic;

    private int hitPoints = 3;

    private int health = 1;

    public Zombie(Position pos, Position playerPos, Zones spawnZone) {
        super(spawnZone);

        this.playerPos = playerPos;

        newPicture(pos, picturePath);

    }

    public String getPicturePath() {
        return picturePath;
    }

    @Override
    public void newPicture(Position pos, String picturePath) {

        super.newPicture(pos, picturePath);

        //used to readapt colliding position size [magic numbers]

        firstCol = pos.getCol() + 15;
        lastCol = pos.getCol() + posSizeX - 3;
        firstRow = pos.getRow() + 20;
        lastRow = pos.getRow() + posSizeY;

        //test size
        int x = firstCol / Background.getCellSize();
        int y = firstRow / Background.getCellSize();
        int width = lastCol / Background.getCellSize() - x;
        int height =  lastRow / Background.getCellSize() - y;

        Rectangle testRectangle = new Rectangle(x, y, width, height);
        testRectangle.draw();
        //

        if (lastCol >= Background.getCols()) {
            pos.setCol(Background.getCols() - posSizeX);
            firstCol = pos.getCol();
            lastCol = pos.getCol() + posSizeX;
        }

        if (lastRow >= Background.getRows()) {
            pos.setRow(Background.getRows() - posSizeY);
            firstRow = pos.getRow();
            lastRow = pos.getRow() + posSizeY;
        }
    }

    public void moveZombie() {

        picToUseLeftRight = null;
        picToUseUpDown = null;

        int targetCol = playerPos.getCol();
        int targetRow = playerPos.getRow();

        if (targetCol > pos.getCol() && !forbiddenRight) {
            super.moveObject(Direction.RIGHT);
            picToUseLeftRight = Direction.RIGHT;
        }

        if (targetCol < pos.getCol() && !forbiddenLeft) {
            super.moveObject(Direction.LEFT);
            picToUseLeftRight = Direction.LEFT;
        }

        if (targetRow < pos.getRow() && !forbiddenUp) {
            super.moveObject(Direction.UP);
            picToUseUpDown = Direction.UP;

        }

        if (targetRow > pos.getRow() && !forbiddenDown) {
            super.moveObject(Direction.DOWN);
            picToUseUpDown = Direction.DOWN;

        }



        if (picToUseUpDown == Direction.UP) {

            if (picToUseLeftRight == Direction.LEFT) {
                picture.load(picturePath);
                return;
            }
            if (picToUseLeftRight == Direction.RIGHT) {
                picture.load(picturePath);
                return;
            }

            picture.load(picturePath);
            return;
        }

        if (picToUseUpDown == Direction.DOWN) {

            if (picToUseLeftRight == Direction.LEFT) {
                picture.load(picturePath);
                return;
            }

            if (picToUseLeftRight == Direction.RIGHT) {
                picture.load(picturePath);
                return;
            }

            picture.load(picturePath);
            return;
        }

        if (picToUseLeftRight == Direction.LEFT) {
            picture.load(picturePath);
            return;
        }
        if (picToUseLeftRight == Direction.RIGHT) {
            picture.load(picturePath);
        }

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void hit() {
        this.health -= 1;
        if (health == 0) {
            this.picture.delete();
            Position newPos = new Position(-1, -1);
            this.newPicture(newPos, "assets/player/playerup.png");
        }
    }

    public int getHealth() {
        return health;
    }
}
