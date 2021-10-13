package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.MovePosition;
import org.academiadecodigo.zombiegame.Position;

import java.awt.*;

public class Player implements KeyboardHandler {

    private Position pos;
    private Rectangle playerPic;
    private MovePosition currentDirection;

    private Weapon weapon;

    private String name;

    private int health = 100;

    public Player(String name){

        playerPic = new Rectangle(400 / 2, 400 / 2, 3 * 5, 3 * 5); //width/2 e 3cols * cellsize
        playerPic.draw();
        playerPic.setColor(Color.BLUE);
        playerPic.fill();

        this.name = name;

        this.weapon = new Weapon();

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            if (playerPic.getX() > Background.getPadding()) {
                playerPic.translate(-10, 0);
                // FALTA MEXER POSIÇAO
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            if (playerPic.getX() < Background.getWidth()) {
                playerPic.translate(10, 0);
                // FALTA MEXER POSIÇAO
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            if (playerPic.getY() > Background.getPadding()) {
                playerPic.translate(0, -10);
                // FALTA MEXER POSIÇAO
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            if (playerPic.getY() < Background.getHeight()) {
                playerPic.translate(0, 10);
                // FALTA MEXER POSIÇAO
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (playerPic.getX() > Background.getPadding()) {
                weapon.shoot();
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
