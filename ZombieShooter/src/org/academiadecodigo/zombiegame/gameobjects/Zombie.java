package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.MovePosition;
import org.academiadecodigo.zombiegame.Position;

public class Zombie {

    private Position pos;
    private MovePosition currentDirection;
    private int totalMove;
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

        System.out.println("Move Zombie");
        if(totalMove==0){
            currentDirection = MovePosition.getRandomDirection();
            totalMove=5;
        }
        else{
            totalMove--;
        }
        int currentCol = pos.getCol();
        int currentRow = pos.getRow();
        pos.move(this.currentDirection);
        int colDif = pos.getCol()-currentCol;
        int rowDif = pos.getRow()-currentRow;
        zombiePic.translate(colDif*Background.getCellSize(),rowDif*Background.getCellSize());
        System.out.println(colDif*Background.getCellSize());
        zombiePic.draw();
        zombiePic.fill();

    }

}
