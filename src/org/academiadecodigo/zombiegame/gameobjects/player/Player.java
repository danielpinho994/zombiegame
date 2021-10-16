package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.zombiegame.field.*;
import org.academiadecodigo.zombiegame.gameobjects.CollisionDetector;
import org.academiadecodigo.zombiegame.gameobjects.Movable;

public class Player extends Movable implements KeyboardHandler {

    private String name;

    private Weapon weapon;
    private int health = 100;

    protected CollisionDetector collisionDetector;

    private Direction firstDirection;
    private Direction secDirection;
    private Direction lastDirection = Direction.RIGHT;

    public Player(String name){
        super(30, Zones.E);

        this.name = name;

        this.weapon = new Weapon();

        //make random position in centre zone
        Zones z = Zones.E;
        pos = new Position(z.getFirstCol(), z.getLastCol(), z.getFirstRow(), z.getLastRow());

        super.setPosition(pos,"assets/SoldierTopDownView.png");

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

    public Bullet[] getBullets() {
        return weapon.getBullets();
    }

    public void shoot() {
        weapon.shoot(lastDirection, pos);
    }

    @Override
    public void moveLeft() {
        if (firstCol > 0) {
            super.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        if (lastCol < Background.getCols()) {
            super.moveRight();
        }
    }

    @Override
    public void moveUp() {
        if (firstRow > 0) {
            super.moveUp();
        }
    }

    @Override
    public void moveDown() {
        if (lastRow < Background.getRows()) {
            super.moveDown();
        }
    }

    public void move() {

        System.out.println("col: " + pos.getCol() + " : row: " + pos.getRow());
        System.out.println("x: " + picture.getX() + " : y: " + picture.getY());

        if (secDirection != null) {
            lastDirection = secDirection;
        } else if (firstDirection != null) {
            lastDirection = firstDirection;
        }

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