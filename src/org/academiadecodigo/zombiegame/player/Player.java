package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.zombiegame.field.*;

public class Player implements KeyboardHandler {

    private static Position pos;
    private Rectangle playerPic;
    private String lastDirection;

    private CollisionDetector collisionDetector;

    //number of rows and cols of rectangle
    private int posSize = 10;

    private int firstCol;
    private int lastCol;
    private int firstRow;
    private int lastRow;

    private boolean forbiddenRight;
    private boolean forbiddenLeft;
    private boolean forbiddenUp;
    private boolean forbiddenDown;

    private Weapon weapon;

    private String name;

    private int health = 100;

    public Player(String name){
        this.name = name;

        this.weapon = new Weapon();

        //make random position in centre zone
        Zones z = Zones.E;
        pos = new Position(z.getFirstCol(), z.getLastCol(), z.getFirstRow(), z.getLastRow());

        firstCol = pos.getCol();
        lastCol = pos.getCol() + posSize;
        firstRow = pos.getRow();
        lastRow = pos.getRow() + posSize;

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = posSize * Background.getCellSize();
        int width = posSize * Background.getCellSize();

        playerPic = new Rectangle(x, y, width, height); //width/2 e 3cols * cellsize
        playerPic.draw();
        playerPic.setColor(Color.BLUE);
        playerPic.fill();

    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void sufferHit(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public Position getPos() {
        return pos;
    }

    public Bullet[] getBullets() {
        return weapon.getBullets();
    }

    public void resetForbidden() {
        forbiddenDown = false;
        forbiddenLeft = false;
        forbiddenUp = false;
        forbiddenRight = false;
    }

    public void forbidRight() {
        forbiddenRight = true;
    }

    public void forbidLeft() {
        forbiddenLeft = true;
    }

    public void forbidUp() {
        forbiddenUp = true;
    }

    public void forbidDown() {
        forbiddenDown = true;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public int getLastCol() {
        return lastCol;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            collisionDetector.checkCollisionPlayer();
            moveLeft();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            collisionDetector.checkCollisionPlayer();
            moveRight();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            collisionDetector.checkCollisionPlayer();
            moveUp();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            collisionDetector.checkCollisionPlayer();
            moveDown();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            shoot();
        }

    }

    public void moveLeft() {
        if(forbiddenLeft) {
            return;
        }

        if (playerPic.getX() > Background.getPadding()) {
            playerPic.translate(-Background.getCellSize(), 0);
            lastDirection = "left";

            firstCol--;
            lastCol--;

            pos.move(Direction.LEFT);
        }
    }

    public void moveRight() {
        if (forbiddenRight) {
            return;
        }

        if (playerPic.getX() < Background.getWidth()) {
            playerPic.translate(Background.getCellSize(), 0);
            lastDirection = "right";

            firstCol++;
            lastCol++;

            pos.move(Direction.RIGHT);
        }
    }

    public void moveUp() {
        if (forbiddenUp) {
            return;
        }

        if (playerPic.getY() > Background.getPadding()) {
            playerPic.translate(0, -Background.getCellSize());
            lastDirection = "up";

            firstRow--;
            lastRow--;

            pos.move(Direction.UP);
        }
    }

    public void moveDown() {
        if (forbiddenDown) {
            return;
        }

        if (playerPic.getY() < Background.getHeight()) {
            playerPic.translate(0, Background.getCellSize());
            lastDirection = "down";

            firstRow++;
            lastRow++;

            pos.move(Direction.DOWN);
        }
    }

    public void shoot() {
        if (lastDirection == null) {
            weapon.shoot("right", playerPic.getX(), playerPic.getY());
            return;
        }
        if (playerPic.getX() > Background.getPadding()) {
            weapon.shoot(lastDirection, playerPic.getX(), playerPic.getY());
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}