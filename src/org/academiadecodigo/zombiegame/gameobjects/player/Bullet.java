package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.gameobjects.GameObjects;

public class Bullet extends GameObjects {

    private Direction bulletDirection;
    private boolean isImpacted;

    public Bullet(Position bulletPos) {
        super(1);

        pos = bulletPos;
        picture = new Rectangle(bulletPos.getCol() * Background.getCellSize() + Background.getPadding(), bulletPos.getRow() * Background.getCellSize() + Background.getPadding(), Background.getCellSize() , Background.getCellSize());

    }

    public void loadBullet(Direction direction) {

        bulletDirection = direction;

        picture.draw();
        picture.setColor(Color.BLACK);
        picture.fill();

    }

    public void moveBullet() {

        switch (bulletDirection) {
            case LEFT:
                if (pos.getCol() <= 1) {
                    picture.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                picture.translate(-Background.getCellSize(), 0);
                pos.move(bulletDirection);
                //System.out.println("col: " + pos.getCol() + " : row: " + pos.getRow());
                //System.out.println("x: " + bulletPic.getX() + " : y: " + bulletPic.getY());
                break;
            case RIGHT:
                if (pos.getCol() >= Background.getCols() - 1) {
                    picture.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                picture.translate(Background.getCellSize(), 0);
                pos.move(bulletDirection);
                break;
            case UP:
                if (pos.getRow() <= 1) {
                    picture.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                picture.translate(0, -Background.getCellSize());
                pos.move(bulletDirection);
                break;
            case DOWN:
                if (pos.getRow() >= Background.getRows() - 1) {
                    picture.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                picture.translate(0, Background.getCellSize());
                pos.move(bulletDirection);
                break;
        }

    }

    public boolean getImpact() {
        return isImpacted;
    }

    public void setImpacted() {
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

     */



}