package com.example.labb3.Model;
import com.example.labb3.GameState;
import static com.example.labb3.GameState.*;

public class Model {
GameState gameState = STARTED;

    public void StartGame() {
        gameState = STARTED;
    }

    public GameState getGameState() {
        return gameState;
    }
}
