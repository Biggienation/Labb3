package com.example.labb3.Player2;

import javafx.beans.property.StringProperty;

public interface Player2 {

    boolean isNotHuman();
    void nextMove(StringProperty[][] tiles);
    String getMarker ();
}
