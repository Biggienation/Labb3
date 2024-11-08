package com.example.labb3.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreBoard {
    private final StringProperty player1Score = new SimpleStringProperty();
    private final StringProperty announcer = new SimpleStringProperty();
    private final StringProperty player2Score = new SimpleStringProperty();
    private int player1Points;
    private int player2Points;


    public ScoreBoard(String player1Marker) {
        resetScore(player1Marker);
    }

    public void resetScore(String player1Marker) {
        player1Points = 0;
        player2Points = 0;
        updatePlayer1Score();
        updatePlayer2Score();
        announcer.set(player1Marker);
    }

    private void updatePlayer2Score() {
        player1Score.set("O - score: " + player2Points);
    }

    private void updatePlayer1Score() {
        player1Score.set("X - score: " + player1Points);
    }

    public void addScore(PlayerTurn turn) {
        if (turn == PlayerTurn.PLAYER1) {
            player1Points++;
            updatePlayer1Score();
        } else {
            player2Points++;
            updatePlayer2Score();
        }

    }

    public void setPlayerTurn(String playerMaker) {
        announcer.set(playerMaker);
    }

    public void announceWinner(String playerMarker) {
        announcer.set(playerMarker + " Wins!");
    }

    public void announceDraw() {
        announcer.set("It´s a draw!");
    }

    public StringProperty getAnnouncer() {
        return announcer;
    }

    public StringProperty getPlayer1Score() {
        return player1Score;
    }

    public StringProperty getPlayer2Score() {
        return player2Score;
    }
}

