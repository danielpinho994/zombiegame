package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Position;

public class Bullet {

    private Picture bullet;
    private Position pos;
    private Rectangle bulletPic;
    private boolean isImpacted;


    public Bullet(int col, int row){
        pos = new Position(col, row);
        bulletPic = new Rectangle(col, row, 3, 3);

    }

    public void move(String direction) {

        bulletPic.draw();
        bulletPic.setColor(Color.GREEN);
        bulletPic.fill();

        switch (direction) {
            case "left":
                bulletPic.translate(-10, 0);
                break;
            case "right":
                bulletPic.translate(10, 0);
                break;
            case "up":
                bulletPic.translate(0, -10);
                break;
            case "down":
                bulletPic.translate(0, 10);
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