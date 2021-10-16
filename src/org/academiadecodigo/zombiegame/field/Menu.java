package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.zombiegame.Game;
import org.academiadecodigo.zombiegame.gameobjects.player.Player;

public class Menu implements KeyboardHandler {

    private Game game;
    private Player player;
    private Rectangle menuBackground;
    private Rectangle startButton;
    private Rectangle scoreButton;
    private Rectangle buttonFrame;
    private boolean ready;
    private static Direction lastDirection = Direction.UP;

    private boolean isClosed;

    public Menu(Player player) {
        this.player = player;

        game = new Game(player);

        start();
    }

    public void start() {

        menuBackground = new Rectangle(Background.getPadding(), Background.getPadding(), Background.getWidth(), Background.getHeight());
        menuBackground.draw();
        menuBackground.setColor(Color.BLACK);
        menuBackground.fill();

        startButton = new Rectangle(Background.getPadding() * 2 , Background.getPadding() * 2, Background.getWidth() / 15, Background.getHeight() / 15);
        startButton.draw();
        startButton.setColor(Color.RED);
        startButton.fill();

        scoreButton = new Rectangle(Background.getPadding() * 4 , Background.getPadding() * 4, Background.getWidth() / 15, Background.getHeight() / 15);
        scoreButton.draw();
        scoreButton.setColor(Color.RED);
        scoreButton.fill();

        buttonFrame = new Rectangle(Background.getPadding() * 2 , Background.getPadding() * 2, Background.getWidth() / 15, Background.getHeight() / 15);
        buttonFrame.draw();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W && !isClosed) {
            System.out.println("w");
            if (lastDirection == Direction.UP) {
                lastDirection = Direction.DOWN;
                return;
            }
            lastDirection = Direction.UP;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S && !isClosed) {
            System.out.println("s");
            if (lastDirection == Direction.DOWN) {
                lastDirection = Direction.UP;
                return;
            }
            lastDirection = Direction.DOWN;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE && !isClosed) {
            System.out.println("space");
            if (lastDirection == Direction.UP) {
                ready = true;
                //clearMenu();
                game.init();
/**
                try {
                    game.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
 */
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    private void clearMenu() {
        menuBackground.delete();
        startButton.delete();
        scoreButton.delete();
        buttonFrame.delete();

        isClosed = true;
    }

    public boolean getReady() {
        return ready;
    }

}
