package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.zombiegame.player.Player;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Player player = new Player("Zé");

        Game game = new Game(player);

        Keyboard kb = new Keyboard(player);

        KeyboardEvent wPressed= new KeyboardEvent();
        wPressed.setKey(KeyboardEvent.KEY_W);
        wPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent sPressed= new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_S);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent aPressed= new KeyboardEvent();
        aPressed.setKey(KeyboardEvent.KEY_A);
        aPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent dPressed= new KeyboardEvent();
        dPressed.setKey(KeyboardEvent.KEY_D);
        dPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed= new KeyboardEvent();
        dPressed.setKey(KeyboardEvent.KEY_SPACE);
        dPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(wPressed);
        kb.addEventListener(sPressed);
        kb.addEventListener(aPressed);
        kb.addEventListener(dPressed);
        kb.addEventListener(spacePressed);

        game.init();
        game.start();


    }
}
