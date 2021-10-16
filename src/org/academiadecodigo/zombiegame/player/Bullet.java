package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;

import java.beans.beancontext.BeanContext;

public class Bullet {

    private Picture bullet;
    private Position pos;
    private Rectangle bulletPic;
    private Direction bulletDirection;
    private boolean isImpacted;

    public Bullet(Position bulletPos) {
        pos = bulletPos;
        bulletPic = new Rectangle(bulletPos.getCol() * Background.getCellSize() + Background.getPadding(), bulletPos.getRow() * Background.getCellSize() + Background.getPadding(), Background.getCellSize() , Background.getCellSize());

    }

    public void loadBullet(Direction direction) {

        bulletDirection = direction;

        bulletPic.draw();
        bulletPic.setColor(Color.BLACK);
        bulletPic.fill();

    }

    public void moveBullet() {

        switch (bulletDirection) {
            case LEFT:
                if (pos.getCol() <= 0) {
                    destroyBullet();
                    break;
                }
                directBullet(bulletDirection);
                break;
            case RIGHT:
                if (pos.getCol() >= Background.getCols() - 1) {
                    destroyBullet();
                    break;
                }
                directBullet(bulletDirection);
                break;
            case UP:
                if (pos.getRow() <= 0) {
                    destroyBullet();
                    break;
                }
                directBullet(bulletDirection);
                break;
            case DOWN:
                if (pos.getRow() >= Background.getRows() - 1) {
                    destroyBullet();
                    break;
                }
                directBullet(bulletDirection);
                break;
        }

    }

    public boolean getImpact() {
        return isImpacted;
    }

    private void directBullet(Direction bulletDirection) {

        bulletPic.translate(Background.getCellSize() * bulletDirection.getXAxis(), Background.getCellSize() * bulletDirection.getYAxis());
        pos.move(bulletDirection);
    }

    private void destroyBullet() {
        bulletPic.delete();
        isImpacted = true;
        pos = null;
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

     //System.out.println("col: " + pos.getCol() + " : row: " + pos.getRow());
     //System.out.println("x: " + bulletPic.getX() + " : y: " + bulletPic.getY());

     */



}