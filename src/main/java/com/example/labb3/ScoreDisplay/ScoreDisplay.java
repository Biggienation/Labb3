package com.example.labb3.ScoreDisplay;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreDisplay {
    private final StringProperty announcer = new SimpleStringProperty();
    private final StringProperty player1Score = new SimpleStringProperty();
    private final StringProperty player2Score = new SimpleStringProperty();
    private int player1;
    private int player2;
    public String playerTurn = "X";

    public ScoreDisplay(){
        newScoreDisplay();
    }

    public void newScoreDisplay() {
        player1 = 0;
        player2 = 0;
        setPlayer1Score("X - score: " + player1++);
        setPlayer2Score("O - score: " + player2++);
        announcer.set(playerTurn);
    }

    public String getPlayerTurn (){
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn){
        this.playerTurn = playerTurn;
        announcer.set(playerTurn);
    }

    public void addScore(int turn) {
        if (turn == 1) {
            setPlayer1Score("X - score: " + player1++);
        } else {
            setPlayer2Score("O - score: " + player2++);
        }

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
