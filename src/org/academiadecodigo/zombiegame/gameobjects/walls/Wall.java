package org.academiadecodigo.zombiegame.gameobjects.walls;

        import org.academiadecodigo.simplegraphics.graphics.Rectangle;
        import org.academiadecodigo.zombiegame.field.Background;
        import org.academiadecodigo.zombiegame.field.Position;
        import org.academiadecodigo.zombiegame.field.Zones;
        import org.academiadecodigo.zombiegame.gameobjects.GameObject;

public class Wall extends GameObject {

    private Rectangle wall;

    public Wall(Position pos,   Zones zone ){
        super(zone);

        super.pos = pos;

        getRandomSize();
        newPicture(pos,"assets/walls/wall-horizontal.png");

    }

    @Override
    public void newPicture(Position pos, String picturePath) {

        super.newPicture(pos, picturePath);

        //used to readapt colliding position size [magic numbers]
        firstCol = pos.getCol() + 12;
        lastCol = pos.getCol() + posSizeX + 7;
        firstRow = pos.getRow() + 12;
        lastRow = pos.getRow() + posSizeY + 7;

        //test size
        int x = firstCol / Background.getCellSize();
        int y = firstRow / Background.getCellSize();
        int width = lastCol / Background.getCellSize() - x;
        int height =  lastRow / Background.getCellSize() - y;

        Rectangle testRectangle = new Rectangle(x, y, width, height);
        testRectangle.draw();
        //

        if (lastCol >= Background.getCols()) {
            pos.setCol(Background.getCols() - posSizeX);
            firstCol = pos.getCol();
            lastCol = pos.getCol() + posSizeX;
        }

        if (lastRow >= Background.getRows()) {
            pos.setRow(Background.getRows() - posSizeY);
            firstRow = pos.getRow();
            lastRow = pos.getRow() + posSizeY;
        }
    }

    private void getRandomSize(){

        int random = (int) Math.floor(Math.random()*2);
        switch(random){

            case 0:
                super.posSizeX = 4;
                super.posSizeY = (int) (Math.random()*30) + 10;
                break;
            case 1:
                super.posSizeX = (int) (Math.random()*30) + 10;
                super.posSizeY = 4;
                break;
        }
        lastCol = pos.getCol() + posSizeX;
        lastRow = pos.getRow() + posSizeY;
    }
}

