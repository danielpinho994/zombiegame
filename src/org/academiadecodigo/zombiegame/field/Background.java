package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {

    private final static int PADDING = 10;

    private final static int CELL_SIZE = 1;
    private final static int COLS = 300;
    private final static int ROWS = 150;

    private final static int WIDTH = COLS * getCellSize();
    private final static int HEIGHT = ROWS * getCellSize();

    private Rectangle grid;

    public Background() {

        grid = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        grid.draw();
    }

    public static int getPadding() {
        return PADDING;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }

    public static int getCols() {
        return COLS;
    }

    public static int getRows() {
        return ROWS;
    }
}
