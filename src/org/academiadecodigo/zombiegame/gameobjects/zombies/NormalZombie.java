package org.academiadecodigo.zombiegame.gameobjects.zombies;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.Sound;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class NormalZombie extends Zombie{
    private String picturePath = "assets/zombies/zombieright.png";
    private Sound zombieKilledSound = new Sound("sounds/zombieKilledSound.wav");

    private int hitPoints = 3;

    private int health = 1;


    public NormalZombie(Position pos, Position playerPos, Zones spawnZone) {
        super(pos, playerPos, spawnZone);

        newPicture(pos, picturePath);
    }
    @Override
    public void newPicture(Position pos, String picturePath) {

        super.newPicture(pos, picturePath);

        //used to readapt colliding position size [magic numbers]

        firstCol = pos.getCol() + 15;
        lastCol = pos.getCol() + posSizeX - 3;
        firstRow = pos.getRow() + 20;
        lastRow = pos.getRow() + posSizeY;

        posSizeX = lastCol - firstCol;
        posSizeY = lastRow - firstRow;

        //test size
        int x = firstCol * Background.getCellSize() + Background.getPadding();
        int y = firstRow * Background.getCellSize() + Background.getPadding();
        int width = lastCol * Background.getCellSize() - x;
        int height =  lastRow * Background.getCellSize() - y;

        Rectangle testRectangle = new Rectangle(x, y, width, height);
        testRectangle.draw();
        //

        if (lastCol > Background.getCols()) {
            pos.setCol(Background.getCols() - picture.getWidth() - 5);

            newPicture(pos, picturePath);
        }

        if (lastRow > Background.getRows()) {
            pos.setRow(Background.getRows() - picture.getHeight() - 5);

            newPicture(pos, picturePath);
        }
    }

    @Override
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

    @Override
    public String getPicturePath() {
        return picturePath;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void hit() {
        health -= 1;
        if (health == 0) {
            this.picture.delete();
            Position newPos = new Position(0, 0);
            firstRow = 1;
            lastRow = 1;
            firstCol = 1;
            lastCol = 1;
            this.newPicture(newPos, "assets/player/playerup.png");
            zombieKilledSound.play(true);
        }
    }
}
