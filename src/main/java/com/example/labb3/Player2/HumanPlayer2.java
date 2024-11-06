package com.example.labb3.Player2;

import com.example.labb3.GameBoard.Tile;

public class HumanPlayer2 implements Player2{
    String marker = "O";
    public boolean isNotHuman(){
        return false;
    }

    @Override
    public void nextMove(Tile[][] tiles) {

    }

    @Override
    public String getMarker() {
        return marker;
    }
}
