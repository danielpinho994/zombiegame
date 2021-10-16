package org.academiadecodigo.zombiegame.gameobjects;

        import org.academiadecodigo.simplegraphics.graphics.Rectangle;
        import org.academiadecodigo.zombiegame.field.Background;
        import org.academiadecodigo.zombiegame.field.Position;
        import org.academiadecodigo.zombiegame.field.Zones;

public class Wall {

    private Position pos;
    private Rectangle wall;
    private Zones zone;
    private int posSizeX;
    private int posSizeY;
    private int height;
    private int width;
    private int firstCol;
    private int lastCol;
    private int firstRow;
    private int lastRow;


    public Wall(Position pos,   Zones zone ){

        this.pos = pos;
        this.zone = zone;
        firstCol = pos.getCol();
        firstRow = pos.getRow();
        getRandomSize();
        setPosition();

    }

    private void getRandomSize(){

        int random = (int) Math.floor(Math.random()*2);

        switch(random){

            case 0:
                this.posSizeX = 4;
                this.posSizeY = (int) (Math.random()*30) + 10;
                System.out.println(posSizeX+" "+posSizeY);
                break;
            case 1:
                this.posSizeX = (int) (Math.random()*30) + 10;
                this.posSizeY = 4;
                break;
        }
        lastCol = pos.getCol() + posSizeX;
        lastRow = pos.getRow() + posSizeY;
    }


    public void setPosition(){

        int x = firstCol * Background.getCellSize() + Background.getPadding();
        int y = firstRow * Background.getCellSize() + Background.getPadding();

        height = posSizeX * Background.getCellSize();
        width = posSizeY * Background.getCellSize();

        wall = new Rectangle( x, y, height,width);
        wall.draw();
        wall.fill();

    }


}

