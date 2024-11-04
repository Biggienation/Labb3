package com.example.labb3.GameBoard;

import com.example.labb3.Bot.Bot;
import com.example.labb3.ScoreDisplay.ScoreDisplay;
import javafx.scene.layout.GridPane;
import static com.example.labb3.GameBoard.GameState.*;

public class GameBoard {
    private final GridPane grid;
    private final Tile[][] tiles;
    GameState gameState = STARTED;
    Bot bot;
    ScoreDisplay scoreDisplay;

    public GameBoard() {
        tiles = new Tile[3][3];
        grid = new GridPane();
        grid.setMinSize(100, 100);
        scoreDisplay = new ScoreDisplay();
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
            //TODO If bot wins add score
            botNextMove(tiles);
        } else {
            scoreDisplay.changeTurn();
        }
    }

    private void botNextMove(Tile[][] tiles) {
        scoreDisplay.setPlayerTurn("X");
        bot.nextMove(tiles);
    }

    private void checkForEven(Tile[][] tiles) {

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
        for (int colum = 0; colum < tiles.length -1; colum++)
            if (!(tiles[0][colum].getLabel().isEmpty())
                    && tiles[0][colum].getLabel().equals(tiles[1][colum].getLabel())
                    && tiles[0][colum].getLabel().equals(tiles[2][colum].getLabel())){
                winTheGame();
                return;
            }

    }

    private void checkWinConditionRow(Tile[][] tiles) {
        for (int row = 0; row < tiles.length -1; row++)
            if (!(tiles[row][0].getLabel().isEmpty())
                    && tiles[row][0].getLabel().equals(tiles[row][1].getLabel())
                    && tiles[row][0].getLabel().equals(tiles[row][2].getLabel())){
                        winTheGame();
                        return;
            }
    }

    private void winTheGame() {
        gameState = FINISHED;
        scoreDisplay.addScore();
    }

    private void checkTile(Tile tile) {
        if (tile.getLabel().isEmpty()) {
            tile.setLabel(scoreDisplay.getPlayerTurn());
        }
    }

    public void startGame() {
        gameState = STARTED;
        scoreDisplay.setPlayerTurn("X");
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

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public void resetScore() {
        scoreDisplay.newScoreDisplay();
    }
}