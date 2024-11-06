package com.example.labb3.Bot;

import com.example.labb3.GameBoard.Tile;

import java.util.Random;

import static com.example.labb3.GameBoard.GameState.STARTED;

public class EasyBot implements Player2 {
    String marker = "T";
    Random random = new Random();
    int row, colum;

    public EasyBot() {
        super();
    }

    @Override
    public boolean isNotHuman (){
        return true;
    }

    @Override
    public void nextMove(Tile[][] tiles) {
        whereTo();
        if (checkIfTileIsEmpty(tiles)){
            makeMove(tiles);
        } else {
            nextMove(tiles);
        }

    }

    private void makeMove(Tile[][] tiles) {
        tiles[row][colum].setLabel(marker);
    }

    private boolean checkIfTileIsEmpty(Tile[][] tiles) {
        return tiles[row][colum].getLabel().isEmpty();

    }


    private void whereTo() {
        row = random.nextInt(3);
        colum = random.nextInt(3);
    }

    public String getMarker(){
        return marker;
    }

}
