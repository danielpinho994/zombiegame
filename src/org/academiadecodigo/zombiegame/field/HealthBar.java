package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class HealthBar {

    private Rectangle greenBar;
    private Rectangle redBar;
    private Position pos;

    public HealthBar(){

        pos = new Position(0,0);
        redBar = new Rectangle(pos.getCol() + Background.getPadding(), pos.getRow() + Background.getPadding(), 400, 50);
        redBar.setColor(Color.RED);
        redBar.draw();
        redBar.fill();
        greenBar = new Rectangle(pos.getCol()+Background.getPadding(), pos.getRow()+Background.getPadding(), 400,50);
        greenBar.setColor(Color.GREEN);
        greenBar.draw();
        greenBar.fill();

    }

    public void looseHp(int hpLoss){
        greenBar.translate(-(hpLoss)*2,0);
        greenBar.grow(-(hpLoss)*2,0);
    }


}
