package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.MovePosition;
import org.academiadecodigo.zombiegame.Position;
import org.academiadecodigo.zombiegame.player.Player;

public class Zombie {

    private Position pos;
    private Position playerPos = Player.getPos();
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

    public void moveZombie() {

        int currentCol = pos.getCol();
        int currentRow = pos.getRow();

        int playerCol = playerPos.getCol();
        int playerRow = playerPos.getRow();

        pos.move(MovePosition.RIGHT);

        int colDif = pos.getCol()-currentCol;
        int rowDif = pos.getRow()-currentRow;

        zombiePic.translate(colDif*Background.getCellSize(),rowDif*Background.getCellSize());
        zombiePic.draw();
        zombiePic.fill();

    }

}
