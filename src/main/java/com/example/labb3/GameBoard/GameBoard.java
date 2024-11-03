package com.example.labb3.GameBoard;

import javafx.scene.layout.GridPane;

import static com.example.labb3.GameBoard.GameState.FINISHED;
import static com.example.labb3.GameBoard.GameState.STARTED;

public class GameBoard {
    private GridPane grid;
    private Tile[][] tiles;
    GameState gameState = STARTED;
    public String turn = "X";

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
        CheckWinConditionRow(tiles);
        CheckWinConditionColum(tiles);
        CheckWinConditionRightLeft(tiles);
        CheckWinConditionLeftRight(tiles);

    }

    private void CheckWinConditionLeftRight(Tile[][] tiles) {
        if (!(tiles[0][0].getLabel().isEmpty())
                && tiles[0][0].getLabel().equals(tiles[1][1].getLabel())
                && tiles[0][0].getLabel().equals(tiles[2][2].getLabel()))
            WinTheGame(turn);

    }

    private void CheckWinConditionRightLeft(Tile[][] tiles) {
        if (!(tiles[0][2].getLabel().isEmpty())
                && tiles[0][2].getLabel().equals(tiles[1][1].getLabel())
                && tiles[0][2].getLabel().equals(tiles[2][0].getLabel()))
                    WinTheGame(turn);

    }

    private void CheckWinConditionColum(Tile[][] tiles) {
        for (int colum = 0; colum < tiles.length -1; colum++)
            if (!(tiles[0][colum].getLabel().isEmpty())
                    && tiles[0][colum].getLabel().equals(tiles[1][colum].getLabel())
                    && tiles[0][colum].getLabel().equals(tiles[2][colum].getLabel())){
                WinTheGame(turn);
                return;
            }

    }

    private void CheckWinConditionRow(Tile[][] tiles) {
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
        System.out.println("Win");

    }


    private void CheckTile(Tile tile) {
        if (tile.getLabel().isEmpty()) {
            tile.setLabel(turn);
            changeTurn();
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

}