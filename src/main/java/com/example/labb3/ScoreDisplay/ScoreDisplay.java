package com.example.labb3.ScoreDisplay;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreDisplay {
    private final StringProperty announcer = new SimpleStringProperty();
    private final StringProperty playerXScore = new SimpleStringProperty();
    private final StringProperty playerOScore = new SimpleStringProperty();
    private int playerX;
    private int playerO;
    public String playerTurn = "X";

    public ScoreDisplay(){
        newScoreDisplay();
    }

    public void newScoreDisplay() {
        playerX = 0;
        playerO = 0;
        setPlayerXScore("X - score: " + playerX++);
        setPlayerOScore("O - score: " + playerO++);
        announcer.set(playerTurn);
    }

    public String getPlayerTurn (){
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn){
        this.playerTurn = playerTurn;
        announcer.set(playerTurn);
    }

    public void changeTurn() {
        if (playerTurn.equals("X")) {
            this.playerTurn = "O";
        } else {
            this.playerTurn = "X";
        }
        announcer.set(playerTurn);
    }

    public void addScore() {
        if (playerTurn.equals("X")) {
            setPlayerXScore("X - score: " + playerX++);
        } else {
            setPlayerOScore("O - score: " + playerO++);
        }

    }

    public StringProperty playerXScoreProperty() {
        return playerXScore;
    }

    public void setPlayerXScore(String playerXScore) {
        this.playerXScore.set(playerXScore);
    }

    public StringProperty playerOScoreProperty() {
        return playerOScore;
    }

    public void setPlayerOScore(String playerOScore) {
        this.playerOScore.set(playerOScore);
    }

    public StringProperty getAnnouncer() {
        return announcer;
    }

    public void announceWinner() {
        announcer.set(playerTurn + " Wins!");
    }

    public void announceDraw() {
        announcer.set("It´s a draw!");
    }
}
