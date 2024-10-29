package com.example.labb3.GameBoard;

import javafx.scene.layout.StackPane;
import static com.example.labb3.GameBoard.GameState.STARTED;

public class GameBoard {
    private StackPane pane;
    private Tile[][] tiles;
    GameState gameState = STARTED;
    public String turn = "X";

    public GameBoard() {
        tiles = new Tile[3][3];
        pane = new StackPane();
        pane.setMinSize(100,100);
        AddAllTiles();
    }

    private void AddAllTiles() {
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                Tile tile = new Tile();
                SetXAndY(tile, col, row);
                SetOnMouseClick(tile);
                pane.getChildren().add(tile.getStackPane());
                tiles[row][col] = tile;
            }
        }
    }

    private static void SetXAndY(Tile tile, int col, int row) {
        tile.getStackPane().setTranslateX((col *100)-100);
        tile.getStackPane().setTranslateY((row *100)-100);
    }

    private void SetOnMouseClick(Tile tile) {
        tile.getStackPane().
                setOnMouseClicked(mouseEvent -> {
                    CheckTile(tile);
                    CheckWinCondition(tiles);
                });
    }

    private void CheckWinCondition(Tile[][] tiles) {
        CheckWinConditionRow(tiles);
        CheckWinConDitionColum(tiles);
        CheckWinConditionRightLeft(tiles);
        CheckWinConditionLeftRight(tiles);

    }

    private void CheckWinConditionLeftRight(Tile[][] tiles) {
        if (tiles[1][1] == tiles[1][3] && tiles[1][1] == tiles[1][2]){
            System.out.println("Win");
        }
    }

    private void CheckWinConDitionColum(Tile[][] tiles) {
    }

    private void CheckWinConditionRightLeft(Tile[][] tiles) {
    }

    private void CheckWinConditionRow(Tile[][] tiles) {
    }

    private void CheckTile(Tile tile) {
        if (tile.getLabel().isEmpty()) {
            tile.setLabel(turn);
            ChangeTurn();
        }
    }

    public void ChangeTurn (){
        if (turn.equals("X")){
            this.turn = "O";
        } else {
            this.turn = "X";
        }
    }

    public void StartGame() {
        gameState = STARTED;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public StackPane getStackPane() {
        return pane;
    }

}
