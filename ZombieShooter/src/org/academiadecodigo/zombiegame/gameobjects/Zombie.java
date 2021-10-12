package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.Position;

public class Zombie {

    private Position pos;

    private int health;

    private Picture zombiePic;

    public Zombie(Position pos) {

        this.pos = pos;

        zombiePic = new Picture(pos.getCol() * Background.getCellSize(), pos.getRow() * Background.getCellSize(), "src/org/academiadecodigo/zombiegame/zombieTopDown.png");
    }

    public void move() {
        pos.move(zombiePic);
    }

}
