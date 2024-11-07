package com.example.labb3.gameboard;
import com.example.labb3.GameBoard.Model;
import com.example.labb3.GameBoard.GameState;
import com.example.labb3.GameBoard.PlayerTurn;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Model model = new Model();

    @Test
    void WhenCreatingGameBoardThenGameStateIsStared(){
        assertEquals(GameState.STARTED, model.getGameState(), "The GameState should be started");
    }

    @Test
    void WhenThreeInTheFirstRowAreTheSameTheGameStateIsFinished(){
        model.getTiles()[0][0].set("X");
        model.getTiles()[0][1].set("X");
        model.getTiles()[0][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheSecondRowAreTheSameTheGameStateIsFinished(){
        model.getTiles()[1][0].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[1][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheThirdRowAreTheSameTheGameStateIsFinished(){
        model.getTiles()[2][0].set("X");
        model.getTiles()[2][1].set("X");
        model.getTiles()[2][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheFirstColumAreTheSameTheGameStateIsFinished(){
        model.getTiles()[0][0].set("X");
        model.getTiles()[1][0].set("X");
        model.getTiles()[2][0].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheSecondColumAreTheSameTheGameStateIsFinished(){
        model.getTiles()[0][1].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[2][1].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeInTheThirdColumAreTheSameTheGameStateIsFinished(){
        model.getTiles()[0][2].set("X");
        model.getTiles()[1][2].set("X");
        model.getTiles()[2][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeLeftToRightAreTheSameTheGameStateIsFinished(){
        model.getTiles()[0][0].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[2][2].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void WhenThreeRightToLeftAreTheSameTheGameStateIsFinished(){
        model.getTiles()[0][2].set("X");
        model.getTiles()[1][1].set("X");
        model.getTiles()[2][0].set("X");
        model.checkWinCondition(model.getTiles());
        assertEquals(GameState.FINISHED, model.getGameState());

    }

    @Test
    void IfTileIsNotEmptyLabelDoesNotChange(){
        model.getTiles()[1][1].set(model.getPlayer1Marker());
        model.setTurn(PlayerTurn.PLAYER2);
        model.checkTile(model.getTiles()[1][1]);
        assertThat(model.getTiles()[1][1].get()).isEqualTo(model.getPlayer1Marker());

    }

    @Test
    void IfTileIsEmptyLabelDoesChange (){
        model.checkTile(model.getTiles()[1][1]);
        assertThat(model.getTiles()[1][1].get()).isEqualTo(model.getPlayer1Marker());
    }
}
