package com.example.labb3.gameboard;
import com.example.labb3.GameBoard.Model;
import com.example.labb3.GameBoard.GameState;
import com.example.labb3.GameBoard.PlayerTurn;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Model model = new Model();

    void addtiles(){
        for (int row = 0; row < model.getTiles().length; row++) {
            for (int col = 0; col < model.getTiles()[row].length; col++){
                model.getTiles()[row][col] = new SimpleStringProperty();
            }}
    }

    @Test
    void WhenCreatingGameBoardThenGameStateIsStared(){
        assertEquals(GameState.STARTED, model.getGameState(), "The GameState should be started");
    }

    @Test
    void WhenThreeInTheFirstRowAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[0][0].set("X");
        model.getTiles()[0][1].set("X");
        model.getTiles()[0][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheSecondRowAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[1][0].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[1][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheThirdRowAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[2][0].set("X");
        model.getTiles()[2][1].set("X");
        model.getTiles()[2][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheFirstColumAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[0][0].set("X");
        model.getTiles()[1][0].set("X");
        model.getTiles()[2][0].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheSecondColumAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[0][1].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[2][1].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheThirdColumAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[0][2].set("X");
        model.getTiles()[1][2].set("X");
        model.getTiles()[2][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeLeftToRightAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[0][0].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[2][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeRightToLeftAreTheSameTheGameStateIsFinished(){
        addtiles();
        model.getTiles()[0][2].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[2][0].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void IfTileIsNotEmptyLabelDoesNotChange(){
        addtiles();
        model.getTiles()[1][1].set(model.getPlayer1Marker());
        model.setTurn(PlayerTurn.PLAYER2);
        model.checkTile(model.getTiles()[1][1]);
        assertThat(model.getTiles()[1][1].get()).isEqualTo(model.getPlayer1Marker());

    }

    @Test
    void IfTileIsEmptyLabelDoesChange (){
        addtiles();
        model.checkTile(model.getTiles()[1][1]);
        assertThat(model.getTiles()[1][1].get()).isEqualTo(model.getPlayer1Marker());
    }
}
