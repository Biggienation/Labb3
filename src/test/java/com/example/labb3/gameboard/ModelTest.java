package com.example.labb3.gameboard;
import com.example.labb3.Model.Model;
import com.example.labb3.Model.GameState;
import com.example.labb3.Model.PlayerTurn;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Model model = new Model();

    void addStringProperties(){
        StringProperty[][] tiles = model.getBoardProperties();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                tiles[row][col] = new SimpleStringProperty();
            }
        }

    }

    @Test
    void WhenCreatingGameBoardThenGameStateIsStared(){
        assertEquals(GameState.STARTED, model.getGameState(), "The GameState should be started");
    }

    @Test
    void WhenThreeInTheFirstRowAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[0][0].set("X");
        model.getBoardProperties()[0][1].set("X");
        model.getBoardProperties()[0][2].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheSecondRowAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[1][0].set("X");
        model.getBoardProperties()[1][1].set("X");
        model.getBoardProperties()[1][2].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheThirdRowAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[2][0].set("X");
        model.getBoardProperties()[2][1].set("X");
        model.getBoardProperties()[2][2].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheFirstColumAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[0][0].set("X");
        model.getBoardProperties()[1][0].set("X");
        model.getBoardProperties()[2][0].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheSecondColumAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[0][1].set("X");
        model.getBoardProperties()[1][1].set("X");
        model.getBoardProperties()[2][1].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheThirdColumAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[0][2].set("X");
        model.getBoardProperties()[1][2].set("X");
        model.getBoardProperties()[2][2].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeLeftToRightAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[0][0].set("X");
        model.getBoardProperties()[1][1].set("X");
        model.getBoardProperties()[2][2].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeRightToLeftAreTheSameTheGameStateIsFinished(){
        addStringProperties();
        model.getBoardProperties()[0][2].set("X");
        model.getBoardProperties()[1][1].set("X");
        model.getBoardProperties()[2][0].set("X");
        model.checkWinCondition();
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void IfTileIsNotEmptyLabelDoesNotChange(){
        addStringProperties();
        model.getBoardProperties()[1][1].set(model.getPlayer1Marker());
        model.setTurn(PlayerTurn.PLAYER2);
        model.checkTile(model.getBoardProperties()[1][1]);
        assertThat(model.getBoardProperties()[1][1].get()).isEqualTo(model.getPlayer1Marker());

    }

    @Test
    void IfTileIsEmptyLabelDoesChange (){
        addStringProperties();
        model.checkTile(model.getBoardProperties()[1][1]);
        assertThat(model.getBoardProperties()[1][1].get()).isEqualTo(model.getPlayer1Marker());
    }
}
