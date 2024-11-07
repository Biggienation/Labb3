package com.example.labb3.Player2;

import javafx.beans.property.StringProperty;
import java.util.Random;

public class EasyBot implements Player2 {
    String marker = "O";
    Random random = new Random();
    int row, colum;

    @Override
    public boolean isNotHuman (){
        return true;
    }

    @Override
    public void nextMove(StringProperty[][] tiles) {
        whereTo();
        if (checkIfTileIsEmpty(tiles)){
            makeMove(tiles);
        } else {
            nextMove(tiles);
        }

    }

    private void makeMove(StringProperty[][] tiles) {
        tiles[row][colum].set(marker);
    }

    private boolean checkIfTileIsEmpty(StringProperty[][] tiles) {
        return tiles[row][colum].get().isEmpty();

    }

    private void whereTo() {
        row = random.nextInt(3);
        colum = random.nextInt(3);
    }

    public String getMarker(){
        return marker;
    }

}
