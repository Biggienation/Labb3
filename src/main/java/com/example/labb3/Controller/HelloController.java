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
    @FXML
    public GridPane grid = new GridPane();
    @FXML
    public Label player1Score;
    @FXML
    public Label player2Score;
    @FXML
    public Label announcer;
    @FXML
    public Button restart_button;

    private final Model model = new Model();


    public void initialize() {
        setUpUI();
    }

    private void setUpUI() {
        setUpGameBoard();
        setUpScoreBoard();

    }

    private void setUpGameBoard() {
        grid.setMinSize(100, 100);
        borderPane.setAlignment(Pos.CENTER);
        AddTilesToGrid();
        borderPane.getChildren().add(grid);
    }

    private void setUpScoreBoard() {
        announcer.textProperty().bind(model.getScoreDisplay().getAnnouncer());
        announcer.setFont(Font.font(40));

        player1Score.textProperty().bind(model.getScoreDisplay().player1ScoreProperty());
        player2Score.textProperty().bind(model.getScoreDisplay().player2ScoreProperty());
        player1Score.setFont(Font.font(20));
        player2Score.setFont(Font.font(20));
    }


    private void AddTilesToGrid() {
        for (int row = 0; row < Model.BOARD_SIZE; row++) {
            for (int col = 0; col < Model.BOARD_SIZE; col++) {
                Tile tile = createTile(row, col);
                grid.add(tile.getStackPane(), col, row);
            }
        }
    }

    private Tile createTile(int row, int col) {
        Tile tile = new Tile();
        setUpTileOnMouseClicked(tile);
        StringProperty tileProperty = new SimpleStringProperty();
        tile.getLabel().textProperty().bindBidirectional(tileProperty);
        model.getBoardProperties()[row][col] = tileProperty;
        return tile;
    }

    private void setUpTileOnMouseClicked(Tile tile) {
        tile.getStackPane().setOnMouseClicked( _ -> {
            if(model.getGameState() == STARTED) {
                model.checkTile(tile.getLabel().textProperty());
            }
        });
    }

    @FXML
    public void pressOnRestartGame() {
        resetBoard();
        model.resetScore();
    }
    @FXML
    public void pressOnNext() {
        resetBoard();
    }

    private void resetBoard() {
        Arrays.stream(model.getBoardProperties())
                .forEach(tiles -> Arrays.stream(tiles)
                        .forEach(tile -> tile.set("")));
        model.startGame();
    }

    @FXML
    public void switchToEasyBot() {
        resetBoard();
        model.setPlayer2(new EasyBot());
    }

    @FXML
    public void switchToHumanPlayer() {
        resetBoard();
        model.setPlayer2(new HumanPlayer2());
    }
}