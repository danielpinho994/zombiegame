package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Score {

    private Picture scoreImage;
    private Picture scoreImageUnits;
    private Picture scoreImageDozens;
    private Picture scoreImageHundreds;
    private Picture scoreImageThousands;
    private int zombieRoundCounter = 0;
    private String[] scoreValues = {"assets/0_score.png",
                                    "assets/1_score.png",
                                    "assets/2_score.png",
                                    "assets/3_score.png",
                                    "assets/4_score.png",
                                    "assets/5_score.png",
                                    "assets/6_score.png",
                                    "assets/7_score.png",
                                    "assets/8_score.png",
                                    "assets/9_score.png"};
    private int scoreValuesHundreds = 0;
    private int scoreValuesThousands = 0;

    public Score() {

        scoreImage = new Picture(Background.getPadding() * 105, Background.getPadding() + 5, "assets/score.png");
        scoreImageUnits = new Picture(Background.getPadding() * 138, Background.getPadding(), "assets/0_score.png");
        scoreImageDozens = new Picture(Background.getPadding() * 134, Background.getPadding(), "assets/0_score.png");
        scoreImageHundreds = new Picture(Background.getPadding() * 130, Background.getPadding(), "assets/0_score.png");
        scoreImageThousands = new Picture(Background.getPadding() * 126, Background.getPadding(), "assets/0_score.png");

    }

    public int setScore(int zombies) {
        drawScore();
        if (zombies > zombieRoundCounter) {
            if (scoreValuesHundreds == 8 && scoreValuesThousands == 9) {
                scoreValuesHundreds++;
                scoreImageHundreds.delete();
                scoreImageHundreds = new Picture(Background.getPadding() * 130, Background.getPadding(), scoreValues[scoreValuesHundreds]);
                scoreImageHundreds.draw();
                return 1;
            }
            if (scoreValuesHundreds == 9) {
                scoreValuesHundreds = 0;
                scoreValuesThousands++;
                scoreImageHundreds.delete();
                scoreImageThousands.delete();
                scoreImageHundreds = new Picture(Background.getPadding() * 130, Background.getPadding(), scoreValues[scoreValuesHundreds]);
                scoreImageThousands = new Picture(Background.getPadding() * 126, Background.getPadding(), scoreValues[scoreValuesThousands]);
                scoreImageHundreds.draw();
                scoreImageThousands.draw();
                return 0;
            }
            scoreValuesHundreds++;
            scoreImageHundreds.delete();
            scoreImageHundreds = new Picture(Background.getPadding() * 130, Background.getPadding(), scoreValues[scoreValuesHundreds]);
            scoreImageHundreds.draw();
            return 0;
        }
        return 0;

    }

    public void setZero() {
        zombieRoundCounter = 0;
    }

    public void drawScore() {
        scoreImage.draw();
        scoreImageUnits.draw();
        scoreImageDozens.draw();
        scoreImageHundreds.draw();
        scoreImageThousands.draw();

    }

    public void deleteScore() {
        scoreImage.delete();
        scoreImageUnits.delete();
        scoreImageDozens.delete();
        scoreImageHundreds.delete();
        scoreImageThousands.delete();
    }
}
