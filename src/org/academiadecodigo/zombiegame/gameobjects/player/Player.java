package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.zombiegame.field.*;
import org.academiadecodigo.zombiegame.gameobjects.CollisionDetector;
import org.academiadecodigo.zombiegame.gameobjects.Movable;

public class Player extends Movable implements KeyboardHandler {

    private Weapon weapon;
    private int health = 100;

    protected CollisionDetector collisionDetector;

    private Direction firstDirection;
    private Direction secDirection;
    private Direction lastDirection = Direction.RIGHT;

    public Player() {
        super(30, 30, Zones.E);

        this.weapon = new Weapon();

        //make random position in centre zone
        Zones z = Zones.E;
        pos = new Position(z.getFirstCol(), z.getLastCol(), z.getFirstRow(), z.getLastRow());

        super.setPosition(pos, "assets/SoldierTopDownView.png");

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

    public void move() {

        if (firstDirection != null) {
            lastDirection = firstDirection;
        } else if (secDirection != null) {
            lastDirection = secDirection;
        }

        resetForbidden();

        collisionDetector.checkPlayerCollision();

        if (firstDirection != null) {

            switch (firstDirection) {

                case UP:
                    if (firstRow > 0 && !forbiddenUp) {
                        super.moveObject(Direction.UP);
                    }
                    break;

                case LEFT:
                    if (firstCol > 0 && !forbiddenLeft) {
                        super.moveObject(Direction.LEFT);
                    }
                    break;

                case RIGHT:
                    if (lastCol < Background.getCols() && !forbiddenRight) {
                        super.moveObject(Direction.RIGHT);
                    }
                    break;

                case DOWN:
                    if (lastRow < Background.getRows() && !forbiddenDown) {
                        super.moveObject(Direction.DOWN);
                    }
            }
        }

        if (secDirection != null) {

            switch (secDirection) {
                case UP:
                    if (firstRow > 0 && !forbiddenUp) {
                        super.moveObject(Direction.UP);
                    }
                    break;

                case LEFT:
                    if (firstCol > 0 && !forbiddenLeft) {
                        super.moveObject(Direction.LEFT);
                    }
                    break;

                case RIGHT:
                    if (lastCol < Background.getCols() && !forbiddenRight) {
                        super.moveObject(Direction.RIGHT);
                    }
                    break;

                case DOWN:
                    if (lastRow < Background.getRows() && !forbiddenDown) {
                        super.moveObject(Direction.DOWN);
                    }
            }
        }
    }

    public void setKeys() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent wPressed = new KeyboardEvent();
        wPressed.setKey(KeyboardEvent.KEY_W);
        wPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent wReleased = new KeyboardEvent();
        wReleased.setKey(KeyboardEvent.KEY_W);
        wReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent aPressed = new KeyboardEvent();
        aPressed.setKey(KeyboardEvent.KEY_A);
        aPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent aReleased = new KeyboardEvent();
        aReleased.setKey(KeyboardEvent.KEY_A);
        aReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent sPressed = new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_S);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent sReleased = new KeyboardEvent();
        sReleased.setKey(KeyboardEvent.KEY_S);
        sReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent dPressed = new KeyboardEvent();
        dPressed.setKey(KeyboardEvent.KEY_D);
        dPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent dReleased = new KeyboardEvent();
        dReleased.setKey(KeyboardEvent.KEY_D);
        dReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(wPressed);
        kb.addEventListener(wReleased);

        kb.addEventListener(aPressed);
        kb.addEventListener(aReleased);

        kb.addEventListener(sPressed);
        kb.addEventListener(sReleased);

        kb.addEventListener(dPressed);
        kb.addEventListener(dReleased);

        kb.addEventListener(spacePressed);
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