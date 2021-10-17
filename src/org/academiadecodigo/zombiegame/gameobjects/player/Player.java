package org.academiadecodigo.zombiegame.gameobjects.player;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.zombiegame.field.*;
import org.academiadecodigo.zombiegame.gameobjects.CollisionDetector;
import org.academiadecodigo.zombiegame.gameobjects.Movable;

public class Player extends Movable{

    private boolean playerReady;

    private movementKeys keys;

    private Weapon weapon;
    private int health = 100;

    private CollisionDetector collisionDetector;

    private Direction lastDirection = Direction.RIGHT;

    public Player() {
        super( Zones.E);

        this.weapon = new Weapon();

        //make random position in centre zone
        Zones z = Zones.E;
        pos = new Position(z.getFirstCol(), z.getLastCol(), z.getFirstRow(), z.getLastRow());

        newPicture(pos,"assets/player/playerup.png");

        keys = new movementKeys(this);

    }

    public void move() {
        keys.move();
    }

    @Override
    public void newPicture(Position pos, String picturePath) {

        super.newPicture(pos, picturePath);

        //used to readapt colliding position size [magic numbers]
        firstCol = pos.getCol() + 15;
        lastCol = pos.getCol() + posSizeX + 10;
        firstRow = pos.getRow() + 20;
        lastRow = pos.getRow() + posSizeY + 10;

        //test size
        int x = firstCol / Background.getCellSize();
        int y = firstRow / Background.getCellSize();
        int width = lastCol / Background.getCellSize() - x;
        int height =  lastRow / Background.getCellSize() - y;

        Rectangle testRectangle = new Rectangle(x, y, width, height);
        testRectangle.draw();
        //

        if (lastCol >= Background.getCols()) {
            pos.setCol(Background.getCols() - posSizeX);
            firstCol = pos.getCol();
            lastCol = pos.getCol() + posSizeX;
        }

        if (lastRow >= Background.getRows()) {
            pos.setRow(Background.getRows() - posSizeY);
            firstRow = pos.getRow();
            lastRow = pos.getRow() + posSizeY;
        }
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


    public boolean isPlayerReady() {
        return playerReady;
    }

    public void setPlayerReady() {
        playerReady = true;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }


    private class movementKeys implements KeyboardHandler {

        private Player player;

        private boolean w;
        private boolean a;
        private boolean s;
        private boolean d;

        public movementKeys(Player player) {
            this.player = player;
            setKeys();
        }

        public void move() {

            player.resetForbidden();

            player.getCollisionDetector().checkPlayerCollision();

            if (w && firstRow > 0 && !forbiddenUp && a && firstCol > 0 && !forbiddenLeft) {
                moveObject(Direction.UP);
                moveObject(Direction.LEFT);
                picture.load("assets/player/playerupleft.png");
                return;
            }

            if (w && firstRow > 0 && d && !forbiddenUp && d && lastCol < Background.getCols() && !forbiddenRight) {
                moveObject(Direction.UP);
                moveObject(Direction.RIGHT);
                picture.load("assets/player/playerupright.png");
                return;
            }

            if (s && lastRow < Background.getRows() && !forbiddenDown && a && firstCol > 0 && !forbiddenLeft) {
                moveObject(Direction.DOWN);
                moveObject(Direction.LEFT);
                picture.load("assets/player/playerdownleft.png");
                return;
            }

            if (s && lastRow < Background.getRows() && !forbiddenDown && d && lastCol < Background.getCols() && !forbiddenRight) {
                moveObject(Direction.DOWN);
                moveObject(Direction.RIGHT);
                picture.load("assets/player/playerdownright.png");
                return;
            }

            if (w && firstRow > 0 && !forbiddenUp) {
                moveObject(Direction.UP);
                picture.load("assets/player/playerup.png");
                return;
            }

            if (s && lastRow < Background.getRows() && !forbiddenDown) {
                moveObject(Direction.DOWN);
                picture.load("assets/player/playerdown.png");
                return;
            }

            if (a && firstCol > 0 && !forbiddenLeft) {
                moveObject(Direction.LEFT);
                picture.load("assets/player/playerleft.png");
                return;
            }

            if (d && lastCol < Background.getCols() && !forbiddenRight) {
                moveObject(Direction.RIGHT);
                picture.load("assets/player/playerright.png");
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
            if (player.isPlayerReady()) {

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
                    w = true;
                }

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
                    s = true;
                }

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
                    a = true;
                }

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
                    d = true;
                }
            }


            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                player.shoot();
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent){
            if (player.isPlayerReady()) {

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
                    w = false;

                }

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
                    a = false;
                }

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
                    d = false;
                }

                if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
                    s = false;
                }
            }
        }
    }
}