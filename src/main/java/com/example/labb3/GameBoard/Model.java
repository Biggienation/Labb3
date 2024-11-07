package com.example.labb3.GameBoard;

import com.example.labb3.Player2.HumanPlayer2;
import com.example.labb3.Player2.Player2;
import com.example.labb3.ScoreDisplay.ScoreDisplay;
import javafx.beans.property.StringProperty;
import static com.example.labb3.GameBoard.GameState.*;
import static com.example.labb3.GameBoard.PlayerTurn.*;

public class Model {
    private final StringProperty[][] tiles;
    PlayerTurn turn = PLAYER1;
    String player1Marker = "X";
    Player2 player2;
    ScoreDisplay scoreDisplay;
    GameState gameState = STARTED;

    public Model() {
        tiles = new StringProperty[3][3];
        scoreDisplay = new ScoreDisplay(player1Marker);
        player2 = new HumanPlayer2();
    }

    public void checkTile(StringProperty tile) {
        if (tile.getValueSafe().isEmpty()) {

            if (turn == PLAYER2)
                tile.set(player2.getMarker());
            else
                tile.set(player1Marker);

            checkWinCondition(tiles);
        }
    }

    private void nextTurn(StringProperty[][] tiles) {
        if (player2.isNotHuman() && turn == PLAYER1) {
            player2.nextMove(tiles);
            turn = PLAYER2;
            checkWinCondition(tiles);
        } else if (turn == PLAYER2) {
            turn = PLAYER1;
            scoreDisplay.setPlayerTurn(player1Marker);
        } else {
            turn = PLAYER2;
            scoreDisplay.setPlayerTurn(player2.getMarker());
        }
    }


    public void checkWinCondition(StringProperty[][] tiles) {
        checkWinConditionRow(tiles);
        checkWinConditionColum(tiles);
        checkWinConditionRightLeft(tiles);
        checkWinConditionLeftRight(tiles);
        checkForEven(tiles);
        if (gameState == STARTED)
            nextTurn(tiles);
    }

    private void checkForEven(StringProperty[][] tiles) {
        if(gameState == STARTED) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (tiles[row][col].getValueSafe().isEmpty())
                        return;
                }

            }
            gameState = FINISHED;
            scoreDisplay.announceDraw();
        }
    }

    private void checkWinConditionLeftRight(StringProperty[][] tiles) {
            if (!(tiles[0][0].getValueSafe().isEmpty())
                    && tiles[0][0].get().equals(tiles[1][1].get())
                    && tiles[0][0].get().equals(tiles[2][2].get()))
                winTheGame();
    }

    private void checkWinConditionRightLeft(StringProperty[][] tiles) {
        if (!(tiles[0][2].getValueSafe().isEmpty())
                && tiles[0][2].get().equals(tiles[1][1].get())
                && tiles[0][2].get().equals(tiles[2][0].get()))
                    winTheGame();

    }

    private void checkWinConditionColum(StringProperty[][] tiles) {
        for (int colum = 0; colum < tiles.length; colum++)
            if (!(tiles[0][colum].getValueSafe().isEmpty())
                    && tiles[0][colum].get().equals(tiles[1][colum].get())
                    && tiles[0][colum].get().equals(tiles[2][colum].get())){
                winTheGame();
                return;
            }

    }

    private void checkWinConditionRow(StringProperty[][] tiles) {
        for (int row = 0; row < tiles.length; row++)
            if (!(tiles[row][0].getValueSafe().isEmpty())
                    && tiles[row][0].get().equals(tiles[row][1].get())
                    && tiles[row][0].get().equals(tiles[row][2].get())){
                        winTheGame();
                        return;
            }
    }

    private void winTheGame() {
        gameState = FINISHED;
         if (turn == PLAYER1)
             scoreDisplay.announceWinner(player1Marker);
         else
             scoreDisplay.announceWinner(player2.getMarker());
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

    public StringProperty[][] getTiles() {
        return tiles;
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