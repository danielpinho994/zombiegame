package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;
import org.academiadecodigo.zombiegame.gameobjects.Movable;

public class Bullet extends Movable {

    private Direction bulletDirection = Direction.RIGHT;
    private boolean isImpacted;

    public Bullet(Position bulletPos, Direction direction) {
        super(Zones.E); //zona é irrelevante neste gameObject

        bulletDirection = direction;

        newPicture(bulletPos, "assets/bulletright.png");

    }

    @Override
    public void newPicture(Position pos, String picturePath) {

        if (picture != null) {
            picture.delete();
        }

        this.pos = pos;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();
        picture = new Picture(x, y, picturePath);

        if (bulletDirection == Direction.RIGHT) {
            pos.setCol(pos.getCol() + 50);
            pos.setRow(pos.getRow() + 42);

            x = pos.getCol() * Background.getCellSize() + Background.getPadding();
            y = pos.getRow() * Background.getCellSize() + Background.getPadding();

            picture = new Picture(x, y, "assets/bulletright.png");
        }

        if (bulletDirection == Direction.LEFT) {
            pos.setRow(pos.getRow() + 5);

            x = pos.getCol() * Background.getCellSize() + Background.getPadding();
            y = pos.getRow() * Background.getCellSize() + Background.getPadding();

            picture = new Picture(x, y, "assets/bulletleft.png");
        }

        if (bulletDirection == Direction.UP) {
            pos.setCol(pos.getCol() + 45);

            x = pos.getCol() * Background.getCellSize() + Background.getPadding();
            y = pos.getRow() * Background.getCellSize() + Background.getPadding();

            picture = new Picture(x, y, "assets/bulletup.png");
        }

        if (bulletDirection == Direction.DOWN) {
            pos.setCol(pos.getCol() + 3);
            pos.setRow(pos.getRow() + 42);

            x = pos.getCol() * Background.getCellSize() + Background.getPadding();
            y = pos.getRow() * Background.getCellSize() + Background.getPadding();

            picture = new Picture(x, y, picturePath);
            picture = new Picture(x, y, "assets/bulletdown.png");
        }

        posSizeX = picture.getWidth() * Background.getCellSize();
        posSizeY = picture.getHeight() * Background.getCellSize();

        picture.draw();

        //used to readapt colliding position size [magic numbers]
        firstCol = pos.getCol() - 5;
        lastCol = pos.getCol() + posSizeX + 10;
        firstRow = pos.getRow() - 5;
        lastRow = pos.getRow() + posSizeY + 10;

        posSizeX = lastCol - firstCol;
        posSizeY = lastRow - firstRow;

        /*
        //test size
        int width = lastCol / Background.getCellSize() - x;
        int height =  lastRow / Background.getCellSize() - y;

        Rectangle testRectangle = new Rectangle(x, y, width, height);
        testRectangle.draw();
        //

         */
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