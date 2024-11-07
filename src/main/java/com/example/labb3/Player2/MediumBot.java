package com.example.labb3.Player2;

import com.example.labb3.GameBoard.Tile;
import javafx.beans.property.StringProperty;

public class MediumBot implements Player2{
    String marker = "O";

    @Override
    public boolean isNotHuman() {
        return true;
    }

    @Override
    public void nextMove(StringProperty[][] tiles) {
        int points = evaluate(tiles);

    }

    public int evaluate(StringProperty[][] board) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0].get().equals(marker)) return +10;
                else if (!(board[i][0].get().equals(marker) ) && !(board[i][0].get().isEmpty())) return -10;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i].get().equals(marker)) return +10;
                else if (!(board[0][i].get().equals(marker)) && !(board[0][i].get().isEmpty())) return -10;
            }
        }

        // Check diagonals
       /* if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0].getLabel().equals(marker)) return +10;
            else if (board[0][0] == -1) return -10;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2].getLabel().equals(marker)) return +10;
            else if (board[0][2] == -1) return -10;
        }*/

        // No winner
        return 0;
    }


    @Override
    public String getMarker() {
        return marker;
    }
}
