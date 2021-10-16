package org.academiadecodigo.zombiegame.field;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import sun.swing.BakedArrayList;

import java.sql.SQLOutput;

public class GameOver {

    private Rectangle gameOverScreen;
    private Position gameOverTextPos;
    private Picture gameOverText;
    private int backgroundMiddleCol = Background.getCols()/2;
    private int backgroundMiddleRow = Background.getRows()/2;


    public GameOver(){

        //getGameOverBackground();
        gameOverTextPos = new Position(backgroundMiddleCol-330,backgroundMiddleRow-200);
        gameOverText = new Picture(gameOverTextPos.getCol()*Background.getCellSize(), gameOverTextPos.getRow()* Background.getCellSize(),"assets/GameOverZombies-removebg-preview.png");
        gameOverText.grow(-200,-100);
        gameOverText.draw();
        System.out.println("hello 2");
    }

    /*private void getGameOverBackground(){

        gameOverScreen = new Rectangle(Background.getPadding(),Background.getPadding(),Background.getWidth()+Background.getPadding(),Background.getHeight()+Background.getPadding());
        gameOverScreen.setColor(Color.DARK_GRAY);
        gameOverScreen.draw();
        gameOverScreen.fill();

    }*/

    private void setGameOverPos(){

        gameOverTextPos.setRow(gameOverTextPos.getRow()-1);
        gameOverTextPos.setCol(gameOverTextPos.getCol()-1);
        System.out.println("hello");

    }
    public void moveGameOver(){

        while((gameOverText.getX()>=10) && (gameOverText.getY()>=10)) {

            gameOverText.translate(-Background.getCellSize(), -Background.getCellSize());
            gameOverText.grow(Background.getCellSize(), Background.getCellSize());
            System.out.println("hello 3");
        }

    }


}