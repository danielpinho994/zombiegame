package org.academiadecodigo.zombiegame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {

    private static int padding;
    private static int width;
    private static int height;

    private static int cellSize = 5;
    private static int cols;
    private static int rows;

    private Rectangle grid;

    public Background(int padding, int width, int height) {

        grid = new Rectangle(padding, padding, width, height);
        grid.draw();

        this.padding = padding;
        this.width = width;
        this.height = height;
        cols = width / cellSize;
        rows = height / cellSize;
    }

    public Position makeGridPosition() {
        return new Position(5, 5); // ALTERAAAAAAR
    }

    public static int getPadding() {
        return padding;
    }

    public static void setPadding(int padding) {
        Background.padding = padding;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Background.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Background.height = height;
    }

    public static int getCellSize() {
        return cellSize;
    }

    public static void setCellSize(int cellSize) {
        Background.cellSize = cellSize;
    }

    public static void setCols(int cols) {
        Background.cols = cols;
    }

    public static void setRows(int rows) {
        Background.rows = rows;
    }


    public static int getCols() {
        return cols;
    }

    public static int getRows() {
        return rows;
    }
}
