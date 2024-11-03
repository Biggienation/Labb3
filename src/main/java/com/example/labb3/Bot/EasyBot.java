package com.example.labb3.Bot;

import com.example.labb3.GameBoard.Tile;

import java.util.Random;

public class EasyBot extends Bot {
    Random random = new Random();
    int row, colum;

    public EasyBot() {
        super();
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
        tiles[row][colum].setLabel("O");
    }

    private boolean checkIfTileIsEmpty(Tile[][] tiles) {
        return tiles[row][colum].getLabel().isEmpty();

    }


    private void whereTo() {
        row = random.nextInt(3);
        colum = random.nextInt(3);
    }
}
