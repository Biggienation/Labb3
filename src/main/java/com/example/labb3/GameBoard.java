package com.example.labb3;


import javafx.scene.layout.StackPane;

public class GameBoard {
    private StackPane pane;
    private Tile[][] tiles = new Tile[3][3];

    public GameBoard() {
        pane = new StackPane();
        pane.setMinSize(100,100);
        pane.setTranslateX(700/2);
        pane.setTranslateY(500/2);

        addAllTiles();
    }

    private void addAllTiles() {
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                Tile tile = new Tile();
                tile.getStackPane().setTranslateX((col*50)- 50);
                tile.getStackPane().setTranslateY((row*50)- 50);
                pane.getChildren().add(tile.getStackPane());
                tiles[row][col] = tile;
            }
        }
    }

    public StackPane getStackPane() {
        return pane;
    }
}
