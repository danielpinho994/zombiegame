package org.academiadecodigo.zombiegame;

public class Zones {

    private int maxCol = Background.getCols();
    private int maxRow = Background.getRows();

    private int nrColsZone = maxCol / 3;
    private int nrRowsZone = maxRow / 3;

    private static int[] zoneColNumber = new int[3];
    private static int[] zoneRowNumber = new int[3];

    private int backgroundCols;
    private int backgroundRows;


    public Zones(){

        backgroundCols = Background.getCols();
        backgroundRows = Background.getRows();

        for(int i = 0; i < 3 ; i++){

            zoneColNumber[i] = backgroundCols - (backgroundCols - nrColsZone);
            zoneRowNumber[i] = backgroundRows - (backgroundRows - nrRowsZone);

        }
    }

    public static int[] getZone(){

        int random = (int) Math.round(Math.random()*3);
        int chosenCol = zoneColNumber[random];
        int random1 = (int) Math.round(Math.random()*3);
        int chosenRow = zoneRowNumber[random1];

        if(random == random1){
            getZone();
        }

        int[] chosenZone = {
                chosenCol,
                chosenRow
        };
        return chosenZone;

    }



}