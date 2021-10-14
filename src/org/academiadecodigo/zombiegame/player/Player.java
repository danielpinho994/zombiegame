package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Player implements KeyboardHandler {


    private static Position pos;
    private Rectangle playerPic;
    private Direction currentDirection;
    private String lastDirection;

    private Weapon weapon;

    private String name;

    private int health = 100;

    public Player(String name){

        //make random position in centre zone
        Zones z = Zones.E;
        pos = new Position(z.getFirstCol(), z.getLastCol(), z.getFirstRow(), z.getLastRow());

        int x = pos.getCol() * Background.getCellSize() + Background.getPadding();
        int y = pos.getRow() * Background.getCellSize() + Background.getPadding();

        int height = 3 * Background.getCellSize();
        int width = 3 * Background.getCellSize();

        playerPic = new Rectangle(x, y, width, height); //width/2 e 3cols * cellsize
        playerPic.draw();
        playerPic.setColor(Color.BLUE);
        playerPic.fill();

        this.name = name;

        this.weapon = new Weapon();

    }

    public Position getPos() {
        return pos;
    }

    public Bullet[] getBullets() {
        return weapon.getBullets();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            if (playerPic.getX() > Background.getPadding()) {
                playerPic.translate(-Background.getCellSize(), 0);
                lastDirection = "left";
                pos.move(Direction.LEFT);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            if (playerPic.getX() < Background.getWidth()) {
                playerPic.translate(Background.getCellSize(), 0);
                lastDirection = "right";
                pos.move(Direction.RIGHT);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            if (playerPic.getY() > Background.getPadding()) {
                playerPic.translate(0, -Background.getCellSize());
                lastDirection = "up";
                pos.move(Direction.UP);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            if (playerPic.getY() < Background.getHeight()) {
                playerPic.translate(0, Background.getCellSize());
                lastDirection = "down";
                pos.move(Direction.DOWN);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (lastDirection == null) {
                weapon.shoot("right", playerPic.getX(), playerPic.getY());
                return;
            }
            if (playerPic.getX() > Background.getPadding()) {
                weapon.shoot(lastDirection, playerPic.getX(), playerPic.getY());
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}