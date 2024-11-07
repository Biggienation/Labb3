package com.example.labb3.Player2;

import javafx.beans.property.StringProperty;

public class HumanPlayer2 implements Player2{
    String marker = "O";
    public boolean isNotHuman(){
        return false;
    }

    @Override
    public void nextMove(StringProperty[][] tiles) {

    }

    @Override
    public String getMarker() {
        return marker;
    }
}
