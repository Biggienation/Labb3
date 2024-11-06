package com.example.labb3.Player2;

import com.example.labb3.GameBoard.Tile;

public interface Player2 {

    boolean isNotHuman();
    void nextMove(Tile[][] tiles);
    String getMarker ();
}
