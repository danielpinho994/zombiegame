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


<<<<<<< HEAD
    public Bullet(int col, int row){
        pos = new Position(col, row);
        bulletPic = new Rectangle(col * Background.getCellSize() + Background.getPadding(), row * Background.getCellSize() + Background.getPadding(),
                Background.getCellSize(), Background.getCellSize());
=======
    public Bullet(Position bulletPos) {

        pos = bulletPos;
        bulletPic = new Rectangle(bulletPos.getCol() * Background.getCellSize() + Background.getPadding(), bulletPos.getRow() * Background.getCellSize() + Background.getPadding(), Background.getCellSize() *20, Background.getCellSize()*20);
>>>>>>> main

    }

    public void loadBullet(Direction direction) {

        bulletDirection = direction;

        bulletPic.draw();
        bulletPic.setColor(Color.GREEN);
        bulletPic.fill();

    }

    public void moveBullet() {

        switch (bulletDirection) {
            case LEFT:
                if (pos.getCol() <= 1) {
                    bulletPic.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                bulletPic.translate(-Background.getCellSize(), 0);
                pos.move(bulletDirection);
                break;
            case RIGHT:
                if (pos.getCol() >= Background.getCols() - 1) {
                    bulletPic.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                bulletPic.translate(Background.getCellSize(), 0);
                pos.move(bulletDirection);
                break;
            case UP:
                if (pos.getRow() <= 1) {
                    bulletPic.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                bulletPic.translate(0, -Background.getCellSize());
                pos.move(bulletDirection);
                break;
            case DOWN:
                if (pos.getRow() >= Background.getRows() - 1) {
                    bulletPic.delete();
                    isImpacted = true;
                    pos = null;
                    break;
                }
                bulletPic.translate(0, Background.getCellSize());
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