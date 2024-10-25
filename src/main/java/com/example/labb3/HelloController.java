package com.example.labb3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import com.example.labb3.Model.*;
import javafx.scene.layout.BorderPane;


public class HelloController {
    @FXML
    public Button Start_button;
    public BorderPane borderPane = new BorderPane();
    private GameBoard gameBoard = new GameBoard();
    private Model model= new Model();

    public void initialize() {
        makeTileBorad(borderPane);
    }

    private void makeTileBorad(BorderPane borderPane) {
        borderPane.setCenter(gameBoard.getStackPane());
    }


    public Model getModel() {
        return model;
    }

    public void startGame(MouseEvent mouseEvent) {
    }
}