package com.example.labb3.Controller;

import com.example.labb3.Player2.EasyBot;
import com.example.labb3.Player2.HumanPlayer2;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.labb3.Model.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import java.util.Arrays;

import static com.example.labb3.Model.GameState.STARTED;


public class HelloController {
    @FXML
    public HBox borderPane = new HBox();
    public GridPane grid = new GridPane();
    public Label playerXScore;
    public Label playerOScore;
    public Label announcer;
    public Button restart_button;
    private final Model model = new Model();


    public void initialize() {
        makeTileBoard(borderPane);
        makePlayerScore();
        grid.setMinSize(100, 100);
    }

    private void makePlayerScore() {
        announcer.textProperty().bind(model.getScoreDisplay().getAnnouncer());
        announcer.setFont(Font.font(40));
        playerXScore.textProperty().bind(model.getScoreDisplay().player1ScoreProperty());
        playerOScore.textProperty().bind(model.getScoreDisplay().player2ScoreProperty());
        playerXScore.setFont(Font.font(20));
        playerOScore.setFont(Font.font(20));
    }

    private void makeTileBoard(HBox borderPane) {
        AddAllTiles();
        borderPane.setAlignment(Pos.CENTER);
        borderPane.getChildren().add(grid);
    }

    private void AddAllTiles() {
        for (int row = 0; row < model.getBoardProperties().length; row++) {
            for (int col = 0; col < model.getBoardProperties()[row].length; col++) {
                Tile tile = new Tile();

                SetOnMouseClick(tile);
                grid.add(tile.getStackPane(), col, row);
                StringProperty temp = new SimpleStringProperty();
                tile.getLabel().textProperty().bindBidirectional(temp);
                model.getBoardProperties()[row][col] = temp;
            }
        }
    }

    private void SetOnMouseClick(Tile tile) {
        tile.getStackPane().
                setOnMouseClicked( _ -> {
                    if(model.getGameState() == STARTED) {
                        model.checkTile(tile.getLabel().textProperty());
                    }
                });
    }

    public void pressOnRestartGame() {
        resetBoard();
        model.resetScore();
    }

    public void pressOnNext() {
        resetBoard();
    }

    private void resetBoard() {
        Arrays.stream(model.getBoardProperties())
                .forEach(tiles -> Arrays.stream(tiles)
                        .forEach(tile -> tile.set("")));
        model.startGame();
    }

    public void ChangeToEasyBot() {
        resetBoard();
        model.setPlayer2(new EasyBot());
    }

    public void changeToPlayer() {
        resetBoard();
        model.setPlayer2(new HumanPlayer2());
    }
}