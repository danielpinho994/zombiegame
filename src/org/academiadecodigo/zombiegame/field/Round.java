package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Round {

    private Picture roundImage;
    private Picture roundImageUnits;
    private Picture roundImageDozens;
    private String[] roundValues = {"assets/0_round.png",
                                    "assets/1_round.png",
                                    "assets/2_round.png",
                                    "assets/3_round.png",
                                    "assets/4_round.png",
                                    "assets/5_round.png",
                                    "assets/6_round.png",
                                    "assets/7_round.png",
                                    "assets/8_round.png",
                                    "assets/9_round.png"};

    public Round() {

        roundImage = new Picture(Background.getPadding() + 500, Background.getPadding() + 200, "assets/round.png");

    }

    public void setRound(int roundNumber) {
        roundImage.draw();

        if (roundNumber < 10) {
            roundImageUnits = new Picture(Background.getPadding() + 650, Background.getPadding() + 300, roundValues[roundNumber]);
            roundImageUnits.draw();
        }
        else {
            roundImageUnits = new Picture(Background.getPadding() + 600, Background.getPadding() + 300, roundValues[roundNumber - 10]);
            roundImageDozens = new Picture(Background.getPadding() + 700, Background.getPadding() + 300, roundValues[1]);
            roundImageUnits.draw();
            roundImageDozens.draw();
        }

    }

    public void deleteRound() {
        roundImage.delete();
        roundImageUnits.delete();
        if (roundImageDozens != null) {
            roundImageDozens.delete();
        }
    }
}
