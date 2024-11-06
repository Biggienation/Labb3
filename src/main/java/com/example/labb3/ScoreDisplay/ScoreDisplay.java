package com.example.labb3.ScoreDisplay;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreDisplay {
    private final StringProperty announcer = new SimpleStringProperty();
    private final StringProperty player1Score = new SimpleStringProperty();
    private final StringProperty player2Score = new SimpleStringProperty();
    private int player1;
    private int player2;


    public ScoreDisplay(String player1Marker){
        newScoreDisplay(player1Marker);
    }

    public void newScoreDisplay(String player1Marker) {
        player1 = 0;
        player2 = 0;
        setPlayer1Score("X - score: " + player1);
        setPlayer2Score("O - score: " + player2);
        announcer.set(player1Marker);
    }

    public void addScore(int turn) {
        if (turn == 1) {
            setPlayer1Score("X - score: " + ++player1);
        } else {
            setPlayer2Score("O - score: " + ++player2);
        }

    }

    public void setPlayerTurn (String playerMaker){
        announcer.set(playerMaker);
    }

    public StringProperty player1ScoreProperty() {
        return player1Score;
    }

    public void setPlayer1Score(String player1Score) {
        this.player1Score.set(player1Score);
    }

    public StringProperty player2ScoreProperty() {
        return player2Score;
    }

    public void setPlayer2Score(String player2Score) {
        this.player2Score.set(player2Score);
    }

    public StringProperty getAnnouncer() {
        return announcer;
    }

    public void announceWinner(String playerMarker) {
        announcer.set(playerMarker + " Wins!");
    }

    public void announceDraw() {
        announcer.set("It´s a draw!");
    }
}
