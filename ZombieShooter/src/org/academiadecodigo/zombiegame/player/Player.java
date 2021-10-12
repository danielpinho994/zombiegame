package org.academiadecodigo.zombiegame.player;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.Background;
import org.academiadecodigo.zombiegame.Position;

public class Player implements KeyboardHandler {

    private Position pos;
    private Picture playerPic;

    private Weapon weapon;

    private String name;

    private int health = 100;

    public Player(String name){

        //playerPic = new Picture(Background.getPadding(), Background.getPadding(), "src/org/academiadecodigo/zombiegame/SoldierTopDownView.png");
        //playerPic.draw();

        this.name = name;

        this.weapon = new Weapon();

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
