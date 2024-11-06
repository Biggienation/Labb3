package com.example.labb3.GameBoard;

import com.example.labb3.Player2.HumanPlayer2;
import com.example.labb3.Player2.Player2;
import com.example.labb3.ScoreDisplay.ScoreDisplay;
import javafx.scene.layout.GridPane;

import static com.example.labb3.GameBoard.GameState.*;

public class GameBoard {
    private final GridPane grid;
    private final Tile[][] tiles;
    int turn = 1;
    String player1Marker = "X";
    Player2 player2;
    ScoreDisplay scoreDisplay;
    GameState gameState = STARTED;

    public GameBoard() {
        tiles = new Tile[3][3];
        grid = new GridPane();
        grid.setMinSize(100, 100);
        scoreDisplay = new ScoreDisplay(player1Marker);
        player2 = new HumanPlayer2();
        AddAllTiles();
    }

    private void AddAllTiles() {
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                Tile tile = new Tile();

                SetOnMouseClick(tile);
                grid.add(tile.getStackPane(), col, row);
                tiles[row][col] = tile;
            }
        }
    }

    private void SetOnMouseClick(Tile tile) {
            tile.getStackPane().
                    setOnMouseClicked(mouseEvent -> {
                        if(gameState == STARTED) {
                            checkTile(tile);
                        }
                    });
    }

    public void checkTile(Tile tile) {
        if (tile.getLabel().isEmpty()) {

            if (turn == 2)
                tile.setLabel(player2.getMarker());
            else
                tile.setLabel(player1Marker);

            checkWinCondition(tiles);
        }
    }

    private void nextTurn(Tile[][] tiles) {
        if (player2.isNotHuman() && turn == 1) {
            player2.nextMove(tiles);
            turn = 2;
            checkWinCondition(tiles);
        } else if (turn == 2) {
            turn = 1;
            scoreDisplay.setPlayerTurn(player1Marker);
        } else {
            turn = 2;
            scoreDisplay.setPlayerTurn(player2.getMarker());
        }
    }


    public void checkWinCondition(Tile[][] tiles) {
        checkWinConditionRow(tiles);
        checkWinConditionColum(tiles);
        checkWinConditionRightLeft(tiles);
        checkWinConditionLeftRight(tiles);
        checkForEven(tiles);
        if (gameState == STARTED)
            nextTurn(tiles);
    }

    private void checkForEven(Tile[][] tiles) {
        if(gameState == STARTED) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (tiles[row][col].getLabel().isEmpty())
                        return;
                }

            }
            gameState = FINISHED;
            scoreDisplay.announceDraw();
        }
    }

    private void checkWinConditionLeftRight(Tile[][] tiles) {
            if (!(tiles[0][0].getLabel().isEmpty())
                    && tiles[0][0].getLabel().equals(tiles[1][1].getLabel())
                    && tiles[0][0].getLabel().equals(tiles[2][2].getLabel()))
                winTheGame();
    }

    private void checkWinConditionRightLeft(Tile[][] tiles) {
        if (!(tiles[0][2].getLabel().isEmpty())
                && tiles[0][2].getLabel().equals(tiles[1][1].getLabel())
                && tiles[0][2].getLabel().equals(tiles[2][0].getLabel()))
                    winTheGame();

    }

    private void checkWinConditionColum(Tile[][] tiles) {
        for (int colum = 0; colum < tiles.length; colum++)
            if (!(tiles[0][colum].getLabel().isEmpty())
                    && tiles[0][colum].getLabel().equals(tiles[1][colum].getLabel())
                    && tiles[0][colum].getLabel().equals(tiles[2][colum].getLabel())){
                winTheGame();
                return;
            }

    }

    private void checkWinConditionRow(Tile[][] tiles) {
        for (int row = 0; row < tiles.length; row++)
            if (!(tiles[row][0].getLabel().isEmpty())
                    && tiles[row][0].getLabel().equals(tiles[row][1].getLabel())
                    && tiles[row][0].getLabel().equals(tiles[row][2].getLabel())){
                        winTheGame();
                        return;
            }
    }

    private void winTheGame() {
        gameState = FINISHED;
         if (turn == 1)
             scoreDisplay.announceWinner(player1Marker);
         else
             scoreDisplay.announceWinner(player2.getMarker());
        scoreDisplay.addScore(turn);
    }

    public void startGame() {
        gameState = STARTED;
        turn = 1;
    }

    public void resetScore() {
        scoreDisplay.newScoreDisplay(player1Marker);
    }

    public void setPlayer2(Player2 player2) {
        this.player2 = player2;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public GridPane getGrid() {
        return grid;
    }

    public ScoreDisplay getScoreDisplay() {
        return scoreDisplay;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setTurn(int Turn){
        this.turn = turn;
    }

    public String getPlayer1Marker(){
        return player1Marker;
    }
}