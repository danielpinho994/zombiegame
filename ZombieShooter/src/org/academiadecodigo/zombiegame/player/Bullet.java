package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Position;

public class Bullet {

    private Picture bullet;
    private Position pos;
    private Position target;
    private Rectangle bulletPic;

    public Bullet(){
        pos = new Position();
        bulletPic = new Rectangle(40 / 2, 40 / 2, 3 * 5, 3 * 5);
        bulletPic.draw();
        bulletPic.setColor(Color.GREEN);
        bulletPic.fill();

    }



}
