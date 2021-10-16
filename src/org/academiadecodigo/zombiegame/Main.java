package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.zombiegame.field.Menu;
import org.academiadecodigo.zombiegame.gameobjects.player.Player;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Player player = new Player("Zé");

        Menu menu = new Menu(player);

        Keyboard kb = new Keyboard(player);

        Keyboard kbm = new Keyboard(menu);

        KeyboardEvent wPressed= new KeyboardEvent();
        wPressed.setKey(KeyboardEvent.KEY_W);
        wPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent wReleased= new KeyboardEvent();
        wReleased.setKey(KeyboardEvent.KEY_W);
        wReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent aPressed= new KeyboardEvent();
        aPressed.setKey(KeyboardEvent.KEY_A);
        aPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent aReleased= new KeyboardEvent();
        aReleased.setKey(KeyboardEvent.KEY_A);
        aReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent sPressed= new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_S);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent sReleased= new KeyboardEvent();
        sReleased.setKey(KeyboardEvent.KEY_S);
        sReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent dPressed= new KeyboardEvent();
        dPressed.setKey(KeyboardEvent.KEY_D);
        dPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent dReleased = new KeyboardEvent();
        dReleased.setKey(KeyboardEvent.KEY_D);
        dReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent spacePressed= new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kbm.addEventListener(wPressed);
        kbm.addEventListener(sPressed);
        kbm.addEventListener(spacePressed);

        if (menu.getReady()) {
            kbm.removeEventListener(wPressed);
            kbm.removeEventListener(sPressed);
            kbm.removeEventListener(spacePressed);
        }

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
}
