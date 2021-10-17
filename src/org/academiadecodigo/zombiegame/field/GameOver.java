package org.academiadecodigo.zombiegame.field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

    private Position gameOverTextPos;
    private Picture gameOverText;
    private int backgroundMiddleCol = Background.getCols()/2;
    private int backgroundMiddleRow = Background.getRows()/2;


    public GameOver() throws InterruptedException {

        //getGameOverBackground();
        gameOverTextPos = new Position(backgroundMiddleCol-330,backgroundMiddleRow-200);
        gameOverText = new Picture(gameOverTextPos.getCol()*Background.getCellSize(), gameOverTextPos.getRow()* Background.getCellSize(),"assets/GameOverZombies-removebg-preview.png");
        gameOverText.grow(-2,-1);
        gameOverText.draw();
        for(int i = 0; i < 100; i++){
            Thread.sleep(20);
        }
        gameOverText.delete();
    }
}