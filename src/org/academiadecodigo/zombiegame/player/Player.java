package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.zombiegame.field.*;
import org.academiadecodigo.zombiegame.gameobjects.Zombie;

public class Player implements KeyboardHandler {

    private static Position pos;
    private Rectangle playerPic;
    private Direction lastDirection = Direction.RIGHT;

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

    private Direction firstDirection;
    private Direction secDirection;

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

        playerPic = new Rectangle(x, y, width, height);
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

    public void shoot() {
        //if (playerPic.getX() > Background.getPadding()) {
        weapon.shoot(lastDirection, pos.getCol(), pos.getRow());
        //}
    }

    public void moveLeft() {
        if (firstCol > 0) {
            playerPic.translate(-Background.getCellSize(), 0);
            lastDirection = Direction.LEFT;

            firstCol--;
            lastCol--;

            pos.move(Direction.LEFT);
        }
    }

    public void moveRight() {
        if (lastCol < Background.getCols()) {
            playerPic.translate(Background.getCellSize(), 0);
            lastDirection = Direction.RIGHT;

            firstCol++;
            lastCol++;

            pos.move(Direction.RIGHT);
        }
    }

    public void moveUp() {
        if (firstRow > 0) {
            System.out.println(-Background.getCellSize());
            playerPic.translate(0, -Background.getCellSize());
            lastDirection = Direction.UP;

            firstRow--;
            lastRow--;

            pos.move(Direction.UP);
        }
    }

    public void moveDown() {
        if (lastRow < Background.getRows()) {
            playerPic.translate(0, Background.getCellSize());
            lastDirection = Direction.DOWN;

            firstRow++;
            lastRow++;

            pos.move(Direction.DOWN);
        }
    }

<<<<<<< HEAD
    public void move() {

        resetForbidden();

        collisionDetector.checkCollisionPlayer();

        if (firstDirection != null) {

            switch (firstDirection) {
                case UP:
                    if (!forbiddenUp) {
                        moveUp();
                    }
                    break;
                case LEFT:
                    if (!forbiddenLeft) {
                        moveLeft();
                    }
                    break;
                case RIGHT:
                    if (!forbiddenRight) {
                        moveRight();
                    }
                    break;
                case DOWN:
                    if (!forbiddenDown) {
                        moveDown();
                    }
            }
        }

        if (secDirection != null) {

            switch (secDirection) {
                case UP:
                    if (!forbiddenUp) {
                        moveUp();
                    }
                    break;
                case LEFT:
                    if (!forbiddenLeft) {
                        moveLeft();
                    }
                    break;
                case RIGHT:
                    if (!forbiddenRight) {
                        moveRight();
                    }
                    break;
                case DOWN:
                    if (!forbiddenDown) {
                        moveDown();
                    }
            }
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            if (firstDirection == null) {
                firstDirection = Direction.UP;
                return;
            }
            secDirection = Direction.UP;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            if (firstDirection == null) {
                firstDirection = Direction.LEFT;
                return;
            }
            secDirection = Direction.LEFT;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            if (firstDirection == null) {
                firstDirection = Direction.RIGHT;
                return;
            }
            secDirection = Direction.RIGHT;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            if (firstDirection == null) {
                firstDirection = Direction.DOWN;
                return;
            }
            secDirection = Direction.DOWN;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            shoot();
=======
    public void shoot() {
        if (playerPic.getX() > Background.getPadding()) {
            weapon.shoot(lastDirection, pos);
>>>>>>> main
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            if (firstDirection == Direction.UP) {
                firstDirection = null;
            }
            if (secDirection == Direction.UP) {
                secDirection = null;
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            if (firstDirection == Direction.LEFT) {
                firstDirection = null;
            }
            if (secDirection == Direction.LEFT) {
                secDirection = null;
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            if (firstDirection == Direction.RIGHT) {
                firstDirection = null;
            }
            if (secDirection == Direction.RIGHT) {
                secDirection = null;
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            if (firstDirection == Direction.DOWN) {
                firstDirection = null;
            }
            if (secDirection == Direction.DOWN) {
                secDirection = null;
            }
        }
    }
}