package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;

public class Menu implements KeyboardHandler {

    private Game game;
    private Picture menuBackground;
    private Rectangle startButton;
    private Rectangle exitButton;
    private Rectangle buttonFrame;
    private boolean ready;
    private static Direction lastDirection = Direction.UP;

    private boolean isClosed;

    private Sound swapButtonSound = new Sound("/Users/codecadet/Workspace/Projects/game/zombiegame/sounds/Wooden Button Click Sound Effect.mp3");

    public Menu() throws InterruptedException {

        game = new Game();

        start();

        setKeys();

        while (!isClosed) {
            Thread.sleep(200);
        }

        clearMenu();

        game.init();
        game.start();

    }

    public void start() {

        menuBackground = new Picture(Background.getPadding(), Background.getPadding(), "assets/menu.jpg");
        menuBackground.draw();

        startButton = new Rectangle(Background.getPadding() * 4, Background.getRows() - 170, Background.getWidth() / 5, Background.getHeight() / 12);
        startButton.draw();
        startButton.setColor(Color.RED);
        startButton.fill();

        exitButton = new Rectangle(Background.getPadding() * 4, Background.getRows() - 80, Background.getWidth() / 5, Background.getHeight() / 12);
        exitButton.draw();
        exitButton.setColor(Color.RED);
        exitButton.fill();

        buttonFrame = new Rectangle(Background.getPadding() * 4, Background.getRows() - 170, Background.getWidth() / 5, Background.getHeight() / 12);
        buttonFrame.draw();
        buttonFrame.setColor(Color.WHITE);

    }

    public void setKeys() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent wPressed = new KeyboardEvent();
        wPressed.setKey(KeyboardEvent.KEY_W);
        wPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent sPressed = new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_S);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(wPressed);
        kb.addEventListener(sPressed);
        kb.addEventListener(spacePressed);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W && !isClosed) {
            swapButtonSound.play(true);
             try {
             Thread.sleep(200);
             } catch (InterruptedException e) {
             e.printStackTrace();
             }
            if (lastDirection == Direction.UP) {
                /**
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                buttonFrame.translate(0, exitButton.getY() - startButton.getY());
                lastDirection = Direction.DOWN;
                return;
            }
            buttonFrame.translate(0, startButton.getY() - exitButton.getY());
            lastDirection = Direction.UP;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S && !isClosed) {
            swapButtonSound.play(true);
            if (lastDirection == Direction.DOWN) {
                buttonFrame.translate(0, startButton.getY() - exitButton.getY());
                lastDirection = Direction.UP;
                return;
            }
            buttonFrame.translate(0, exitButton.getY() - startButton.getY());
            lastDirection = Direction.DOWN;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE && !isClosed) {
            if (lastDirection == Direction.UP) {
                ready = true;
                isClosed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    private void clearMenu() {
        menuBackground.delete();
        startButton.delete();
        exitButton.delete();
        buttonFrame.delete();

        isClosed = true;
    }

    public boolean getReady() {
        return ready;
    }
}
