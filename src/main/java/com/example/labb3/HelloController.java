package com.example.labb3;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import com.example.labb3.GameBoard.*;
import javafx.scene.layout.HBox;

import java.util.Arrays;


public class HelloController {
    @FXML
    public Button Start_button;
    public HBox borderPane = new HBox();
    public Label playerX;
    public Label playerO;
    public Button restart_button;
    private GameBoard gameBoard = new GameBoard();

    public void initialize() {
        makeTileBorad(borderPane);
    }

    private void makeTileBorad(HBox borderPane) {
        borderPane.setAlignment(Pos.CENTER);
        borderPane.getChildren().add(gameBoard.getGrid());
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void restartGame(MouseEvent mouseEvent) {
        Arrays.stream(gameBoard.getTiles()).forEach(tiles -> Arrays.stream(tiles).forEach(tile -> tile.setLabel("")));
        gameBoard.startGame();
    }
}