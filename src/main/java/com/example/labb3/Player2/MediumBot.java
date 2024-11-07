package com.example.labb3.Player2;

import com.example.labb3.GameBoard.Tile;

public class MediumBot implements Player2{
    String marker = "O";

    @Override
    public boolean isNotHuman() {
        return true;
    }

    @Override
    public void nextMove(Tile[][] tiles) {

    }

    @Override
    public String getMarker() {
        return marker;
    }
}
