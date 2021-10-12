package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.Position;

public class Zombie {

    private Position pos;

    private int health;

    private Rectangle zombiePic;

    public Zombie(Position pos) {

        this.pos = pos;
        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();
        int height = 3 * Background.getCellSize() + Background.getPadding();
        int width = 3 * Background.getCellSize() + Background.getPadding();
        zombiePic = new Rectangle(x,y,width,height);
        zombiePic.draw();
        zombiePic.fill();
    }

    public void move() {
        pos.move(zombiePic);
    }

}
