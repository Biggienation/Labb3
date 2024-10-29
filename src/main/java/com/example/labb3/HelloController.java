package com.example.labb3;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import com.example.labb3.GameBoard.*;
import javafx.scene.layout.HBox;


public class HelloController {
    @FXML
    public Button Start_button;
    public HBox borderPane = new HBox();
    private GameBoard gameBoard = new GameBoard();

    public void initialize() {
        makeTileBorad(borderPane);
    }

    private void makeTileBorad(HBox borderPane) {
        borderPane.setAlignment(Pos.CENTER);
        borderPane.getChildren().add(gameBoard.getStackPane());
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void startGame(MouseEvent mouseEvent) {
    }
}