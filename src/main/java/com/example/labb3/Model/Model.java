package com.example.labb3.Model;

import com.example.labb3.Player2.HumanPlayer2;
import com.example.labb3.Player2.Player2;
import com.example.labb3.ScoreDisplay.ScoreDisplay;
import javafx.beans.property.StringProperty;
import static com.example.labb3.Model.GameState.*;
import static com.example.labb3.Model.PlayerTurn.*;

public class Model {
    private static final int BOARD_SIZE = 3;
    private final StringProperty[][] boardProperties;
    private PlayerTurn turn = PLAYER1;
    private String player1Marker = "X";
    private Player2 player2;
    private final ScoreDisplay scoreDisplay;
    private GameState gameState = STARTED;

    public Model() {
        boardProperties = new StringProperty[BOARD_SIZE][BOARD_SIZE];
        scoreDisplay = new ScoreDisplay(player1Marker);
        player2 = new HumanPlayer2();
    }

    public void checkTile(StringProperty tile) {
        if (tile.getValueSafe().isEmpty()) {
            tile.set(turn == PLAYER1 ? player1Marker : player2.getMarker());
            checkWinCondition();
        }
    }

    private void nextTurn() {
        if (player2.isNotHuman() && turn == PLAYER1) {
            player2.nextMove(boardProperties);
            turn = PLAYER2;
            checkWinCondition();
        } else if (turn == PLAYER2) {
            turn = PLAYER1;
            scoreDisplay.setPlayerTurn(player1Marker);
        } else {
            turn = PLAYER2;
            scoreDisplay.setPlayerTurn(player2.getMarker());
        }
    }


    public void checkWinCondition() {
        if (checkRow() ||checkColum() || checkRightLeft() || checkLeftRight())
            winTheGame();
        else {
            checkDraw();
            if (gameState == STARTED)
                nextTurn();
        }
    }

    private boolean threeOfTheSame (StringProperty one, StringProperty two, StringProperty three) {
        return !(one.getValueSafe().isEmpty())
                && one.get().equals(two.get())
                && one.get().equals(three.get());
    }

    private void checkDraw() {
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    if (boardProperties[row][col].getValueSafe().isEmpty())
                        return;
                }

            }
            gameState = FINISHED;
            scoreDisplay.announceDraw();
    }

    private boolean checkLeftRight() {
        return threeOfTheSame(boardProperties[0][0],boardProperties[1][1],boardProperties[2][2]);
    }

    private boolean checkRightLeft() {
        return threeOfTheSame(boardProperties[0][2],boardProperties[1][1],boardProperties[2][0]);

    }

    private boolean checkColum() {
        for (int colum = 0; colum < BOARD_SIZE; colum++)
            if (threeOfTheSame(boardProperties[0][colum],boardProperties[1][colum],boardProperties[2][colum]))
                return true;
        return false;
    }

    private boolean checkRow() {
        for (int row = 0; row < BOARD_SIZE; row++)
            if (threeOfTheSame(boardProperties[row][0],boardProperties[row][1],boardProperties[row][2]))
                return true;
        return false;
    }

    private void winTheGame() {
        gameState = FINISHED;
        scoreDisplay.announceWinner(turn == PLAYER1 ? player1Marker : player2.getMarker());
        scoreDisplay.addScore(turn);
    }

    public void startGame() {
        gameState = STARTED;
        turn = PLAYER1;
    }

    public void resetScore() {
        scoreDisplay.newScoreDisplay(player1Marker);
    }

    public void setPlayer2(Player2 player2) {
        this.player2 = player2;
    }

    public StringProperty[][] getBoardProperties() {
        return boardProperties;
    }

    public ScoreDisplay getScoreDisplay() {
        return scoreDisplay;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setTurn(PlayerTurn turn){
        this.turn = turn;
    }

    public String getPlayer1Marker(){
        return player1Marker;
    }
}