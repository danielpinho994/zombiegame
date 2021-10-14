package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;

public class Bullet {

    private Picture bullet;
    private Position pos;
    private Rectangle bulletPic;
    private Direction bulletDirection;
    private boolean isImpacted;


    public Bullet(int col, int row){
        pos = new Position(col, row);
        bulletPic = new Rectangle(col * Background.getCellSize() + Background.getPadding(), row * Background.getCellSize() + Background.getPadding(), 3, 3);

    }

    public void move(Direction direction) {

        bulletDirection = direction;

        bulletPic.draw();
        bulletPic.setColor(Color.GREEN);
        bulletPic.fill();

        switch (direction) {
            case LEFT:
                bulletPic.translate(-Background.getCellSize(), 0);
                pos.move(bulletDirection);
                break;
            case RIGHT:
                if (bulletPic.getX() == Background.getCols() * Background.getCellSize() + Background.getPadding()) {
                    bulletPic.delete();
                }
                bulletPic.translate(Background.getCellSize(), 0);
                pos.move(bulletDirection);
                break;
            case UP:
                bulletPic.translate(0, -Background.getCellSize());
                pos.move(bulletDirection);
                break;
            case DOWN:
                bulletPic.translate(0, Background.getCellSize());
                pos.move(bulletDirection);
                break;
        }
    }

    public void moveBullet() {
        this.move(bulletDirection);
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