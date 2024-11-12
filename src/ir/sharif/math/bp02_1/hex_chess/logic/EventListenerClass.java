package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;

import java.io.File;
import java.io.IOException;

public class EventListenerClass implements EventListener {

    private GameManager gameManager;

    public EventListenerClass(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void onClick(int row, char col) {
        gameManager.clicked(row , col);

    }

    @Override
    public void onLoad(File file) {
        try {
            gameManager.loadGame(file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onSave(File file) {
        try {
            gameManager.saveGame(file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onNewGame() {
       gameManager.newGame();
    }
}
