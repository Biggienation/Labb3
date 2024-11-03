package com.example.labb3.GameBoard;

import com.example.labb3.Bot.Bot;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.GridPane;

import static com.example.labb3.GameBoard.GameState.FINISHED;
import static com.example.labb3.GameBoard.GameState.STARTED;

public class GameBoard {
    private StringProperty playerXScore = new SimpleStringProperty();
    private StringProperty playerOScore = new SimpleStringProperty();
    private int playerX = 1;
    private int playerO = 1;
    private GridPane grid;
    private Tile[][] tiles;
    GameState gameState = STARTED;
    public String turn = "X";
    Bot bot;

    public GameBoard() {
        tiles = new Tile[3][3];
        grid = new GridPane();
        grid.setMinSize(100, 100);
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
                            CheckTile(tile);
                            CheckWinCondition(tiles);
                        }
                    });
    }

    private void CheckWinCondition(Tile[][] tiles) {
        checkWinConditionRow(tiles);
        checkWinConditionColum(tiles);
        checkWinConditionRightLeft(tiles);
        checkWinConditionLeftRight(tiles);
        checkForEven(tiles);
        //TODO Better check than Null
        if (bot != null) {
            //TODO delay the time for it to make a move
            botNextMove(tiles);
        } else {
            changeTurn();
        }
    }

    private void botNextMove(Tile[][] tiles) {
        changeTurn("X");
        bot.nextMove(tiles);
    }

    private void checkForEven(Tile[][] tiles) {

    }

    private void checkWinConditionLeftRight(Tile[][] tiles) {
        if (!(tiles[0][0].getLabel().isEmpty())
                && tiles[0][0].getLabel().equals(tiles[1][1].getLabel())
                && tiles[0][0].getLabel().equals(tiles[2][2].getLabel()))
            WinTheGame(turn);

    }

    private void checkWinConditionRightLeft(Tile[][] tiles) {
        if (!(tiles[0][2].getLabel().isEmpty())
                && tiles[0][2].getLabel().equals(tiles[1][1].getLabel())
                && tiles[0][2].getLabel().equals(tiles[2][0].getLabel()))
                    WinTheGame(turn);

    }

    private void checkWinConditionColum(Tile[][] tiles) {
        for (int colum = 0; colum < tiles.length -1; colum++)
            if (!(tiles[0][colum].getLabel().isEmpty())
                    && tiles[0][colum].getLabel().equals(tiles[1][colum].getLabel())
                    && tiles[0][colum].getLabel().equals(tiles[2][colum].getLabel())){
                WinTheGame(turn);
                return;
            }

    }

    private void checkWinConditionRow(Tile[][] tiles) {
        for (int row = 0; row < tiles.length -1; row++)
            if (!(tiles[row][0].getLabel().isEmpty())
                    && tiles[row][0].getLabel().equals(tiles[row][1].getLabel())
                    && tiles[row][0].getLabel().equals(tiles[row][2].getLabel())){
                        WinTheGame(turn);
                        return;
            }
    }

    private void WinTheGame(String turn) {
        gameState = FINISHED;
        if (turn.equals("X")) {
            setPlayerXScore("X - score: " + playerX++);
        } else {
            setPlayerOScore("O - score: " + playerO++);
        }

    }

    private void CheckTile(Tile tile) {
        if (tile.getLabel().isEmpty()) {
            tile.setLabel(turn);
        }
    }

    public void changeTurn() {
        if (turn.equals("X")) {
            this.turn = "O";
        } else {
            this.turn = "X";
        }
    }

    public void changeTurn(String turn) {
        this.turn = turn;
    }

    public void startGame() {
        gameState = STARTED;
        changeTurn("X");
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public GridPane getGrid() {
        return grid;
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

    public void setBot(Bot bot) {
        this.bot = bot;
    }
}