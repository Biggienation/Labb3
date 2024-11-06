package com.example.labb3.gameboard;
import com.example.labb3.GameBoard.GameBoard;
import com.example.labb3.GameBoard.GameState;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    GameBoard gameBoard = new GameBoard();

    @Test
    void WhenCreatingGameBoardThenGameStateIsStared(){
        assertEquals(GameState.STARTED, gameBoard.getGameState(), "The GameState should be started");
    }

    @Test
    void WhenThreeInTheFirstRowAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[0][0].setLabel("X");
        gameBoard.getTiles()[0][1].setLabel("X");
        gameBoard.getTiles()[0][2].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void WhenThreeInTheSecondRowAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[1][0].setLabel("X");
        gameBoard.getTiles()[1][1].setLabel("X");
        gameBoard.getTiles()[1][2].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void WhenThreeInTheThirdRowAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[2][0].setLabel("X");
        gameBoard.getTiles()[2][1].setLabel("X");
        gameBoard.getTiles()[2][2].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void WhenThreeInTheFirstColumAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[0][0].setLabel("X");
        gameBoard.getTiles()[1][0].setLabel("X");
        gameBoard.getTiles()[2][0].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void WhenThreeInTheSecondColumAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[0][1].setLabel("X");
        gameBoard.getTiles()[1][1].setLabel("X");
        gameBoard.getTiles()[2][1].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void WhenThreeInTheThirdColumAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[0][2].setLabel("X");
        gameBoard.getTiles()[1][2].setLabel("X");
        gameBoard.getTiles()[2][2].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void WhenThreeLeftToRightAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[0][0].setLabel("X");
        gameBoard.getTiles()[1][1].setLabel("X");
        gameBoard.getTiles()[2][2].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void WhenThreeRightToLeftAreTheSameTheGameStateIsFinished(){
        gameBoard.getTiles()[0][2].setLabel("X");
        gameBoard.getTiles()[1][1].setLabel("X");
        gameBoard.getTiles()[2][0].setLabel("X");
        gameBoard.checkWinCondition(gameBoard.getTiles());
        assertEquals(GameState.FINISHED, gameBoard.getGameState());

    }

    @Test
    void IfTileIsNotEmptyLabelDoesNotChange(){
        gameBoard.getTiles()[1][1].setLabel(gameBoard.getPlayer1Marker());
        gameBoard.setTurn(2);
        gameBoard.checkTile(gameBoard.getTiles()[1][1]);
        assertThat(gameBoard.getTiles()[1][1].getLabel()).isEqualTo(gameBoard.getPlayer1Marker());

    }

    @Test
    void IfTileIsEmptyLabelDoesChange (){
        gameBoard.checkTile(gameBoard.getTiles()[1][1]);
        assertThat(gameBoard.getTiles()[1][1].getLabel()).isEqualTo(gameBoard.getPlayer1Marker());
    }
}
