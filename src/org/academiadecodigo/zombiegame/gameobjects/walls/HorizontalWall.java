package org.academiadecodigo.zombiegame.gameobjects.walls;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class HorizontalWall extends Wall {
    public HorizontalWall(Position pos, Zones zone) {
        super(pos, zone);

        newPicture(pos, "assets/horizontalwall.png");
    }

    @Override
    public void newPicture(Position pos, String picturePath) {

        super.newPicture(pos, picturePath);

        //used to readapt colliding position size [magic numbers]
        firstCol = pos.getCol();
        lastCol = pos.getCol() + posSizeX + 8;
        firstRow = pos.getRow();
        lastRow = pos.getRow() + posSizeY + 8;

        posSizeX = lastCol - firstCol;
        posSizeY = lastRow - firstRow;

        /*
        //test size
        int x = firstCol * Background.getCellSize() + Background.getPadding();
        int y = firstRow * Background.getCellSize() + Background.getPadding();
        int width = lastCol * Background.getCellSize() - x;
        int height = lastRow * Background.getCellSize() - y;

        Rectangle testRectangle = new Rectangle(x, y, width, height);
        testRectangle.draw();
        //

         */

        if (lastCol > Background.getCols()) {
            pos.setCol(Background.getCols() - picture.getWidth() - 15);

            newPicture(pos, picturePath);
        }

        if (lastRow > Background.getRows()) {
            pos.setRow(Background.getRows() - picture.getHeight() - 15);

            newPicture(pos, picturePath);
        }
    }

    public void remove() {
        firstCol = 0;
        lastCol = 0;
        firstRow = 0;
        lastRow = 0;

        picture.delete();

    }
}
