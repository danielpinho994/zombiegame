package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.zombiegame.field.Background;

public enum Zones {

    A (0, Background.getCols() / 3, 0, Background.getRows() / 3),
    B (Background.getCols() / 3, Background.getCols() / 3 * 2, 0, Background.getRows() / 3),
    C (Background.getCols() / 3 * 2, Background.getCols(), 0, Background.getRows() / 3),
    D (0, Background.getCols() / 3, Background.getRows() / 3, Background.getRows() / 3 * 2),
    E (Background.getCols() / 3, Background.getCols() / 3 * 2, Background.getRows() / 3, Background.getRows() / 3 * 2),
    F (Background.getCols() / 3 * 2, Background.getCols(), Background.getRows() / 3, Background.getRows() / 3 * 2),
    G (0, Background.getCols() / 3, Background.getRows() / 3 * 2, Background.getRows()),
    H (Background.getCols() / 3, Background.getCols() / 3 * 2, Background.getRows() / 3 * 2, Background.getRows()),
    I (Background.getCols() / 3 * 2, Background.getCols(), Background.getRows() / 3 * 2, Background.getRows());

    private int firstRow;
    private int firstCol;
    private int lastRow;
    private int lastCol;

    Zones(int firstCol, int lastCol, int firstRow, int lastRow) {
        this.firstCol = firstCol;
        this.firstRow = firstRow;
        this.lastCol = lastCol;
        this.lastRow = lastRow;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public int getLastRow() {
        return lastRow;
    }

    public int getLastCol() {
        return lastCol;
    }
}

