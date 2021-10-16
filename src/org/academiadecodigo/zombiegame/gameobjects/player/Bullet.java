package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;
import org.academiadecodigo.zombiegame.gameobjects.GameObject;

public class Bullet extends GameObject {

    private Direction bulletDirection;
    private boolean isImpacted;

    public Bullet(Position bulletPos) {
        super(1, 1, Zones.E); //zona é irrelevante neste gameObject

        super.setPosition(bulletPos, "assets/bullet.png");

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
        }

    }

    public boolean getImpact() {
        return isImpacted;
    }

    private void directBullet(Direction bulletDirection) {

        picture.translate(Background.getCellSize() * bulletDirection.getXAxis(), Background.getCellSize() * bulletDirection.getYAxis());
        pos.move(bulletDirection);
    }

    private void destroyBullet() {
        picture.delete();
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