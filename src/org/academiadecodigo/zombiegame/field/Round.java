package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Round {

    private Picture roundImage;
    private Picture roundImageUnits;
    private Picture roundImageDozens;
    private String[] roundValues = {"assets/rounds/0_round.png",
                                    "assets/rounds/1_round.png",
                                    "assets/rounds/2_round.png",
                                    "assets/rounds/3_round.png",
                                    "assets/rounds/4_round.png",
                                    "assets/rounds/5_round.png",
                                    "assets/rounds/6_round.png",
                                    "assets/rounds/7_round.png",
                                    "assets/rounds/8_round.png",
                                    "assets/rounds/9_round.png"};

    public Round() {

        roundImage = new Picture(Background.getPadding() + 500, Background.getPadding() + 200, "assets/rounds/round.png");

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
