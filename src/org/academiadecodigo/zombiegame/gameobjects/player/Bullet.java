package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;
import org.academiadecodigo.zombiegame.gameobjects.Movable;

public class Bullet extends Movable {

    private Direction bulletDirection;
    private boolean isImpacted;

    public Bullet(Position bulletPos) {
        super(Zones.E); //zona é irrelevante neste gameObject

        newPicture(bulletPos, "assets/bullets/left-mid bullets.png");

    }

    @Override
    public void newPicture(Position pos, String picturePath) {

        super.newPicture(pos, picturePath);

        //used to readapt colliding position size [magic numbers]
        firstCol = pos.getCol() + 5;
        lastCol = pos.getCol() + posSizeX + 10;
        firstRow = pos.getRow() + 5;
        lastRow = pos.getRow() + posSizeY + 10;

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

    public void loadBullet(Direction direction) {

        bulletDirection = direction;

        picture.draw();
    }

    public void moveBullet() {

        switch (bulletDirection) {

            case LEFT:
                if (pos.getCol() <= 0) {
                    destroyBullet();
                    break;
                }
                super.moveObject(Direction.LEFT);
                break;

            case RIGHT:
                if (pos.getCol() >= Background.getCols() - 1) {
                    destroyBullet();
                    break;
                }
                super.moveObject(Direction.RIGHT);
                break;

            case UP:
                if (pos.getRow() <= 0) {
                    destroyBullet();
                    break;
                }
                super.moveObject(Direction.UP);
                break;

            case DOWN:
                if (pos.getRow() >= Background.getRows() - 1) {
                    destroyBullet();
                    break;
                }
                super.moveObject(Direction.DOWN);
        }

    }

    public boolean isImpacted() {
        return isImpacted;
    }

    public void destroyBullet() {
        picture.delete();
        isImpacted = true;
    }

    public Position getPos() {
        return pos;
    }

    /**
     *
     Bullet[] shotBullets = player.getBullets();

     for (Bullet b : shotBullets) {
     while (b != null && !b.getImpact()) {
     b.move();
     }
     }

     //System.out.println("col: " + pos.getCol() + " : row: " + pos.getRow());
     //System.out.println("x: " + bulletPic.getX() + " : y: " + bulletPic.getY());

     */



}