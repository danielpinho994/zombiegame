package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;
import org.academiadecodigo.zombiegame.gameobjects.GameObject;
import org.academiadecodigo.zombiegame.gameobjects.Movable;

public class Bullet extends Movable {

    private Direction bulletDirection;
    private boolean isImpacted;

    public Bullet(Position bulletPos) {
        super(Zones.E); //zona é irrelevante neste gameObject

        super.setPosition(bulletPos, "assets/Bullets/left-mid bullets.png");
        System.out.println("bullet : " + firstCol + " " + lastCol + " " + firstRow + " " + lastRow);

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