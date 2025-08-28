// com.daniel.model.GameContext
package com.daniel.model;

import java.util.ArrayList;
import java.util.List;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.GameObserver;
import com.daniel.interfaces.GameState;
import com.daniel.interfaces.impl.states.InProgressState;

public class GameContext {

    private final Board board;
    private GameState state = new InProgressState();
    private boolean finished = false;

    private Player currentPlayer;
    private Player opponent;
    
    private ColorPiece currentColor;
    private ColorPiece opponentColor;

    private final List<GameObserver> observers = new ArrayList<>();

    public GameContext(Board board, Player white, Player black) {
        this.board = board;
        // por padrão: branco começa
        this.currentPlayer = white;
        this.opponent = black;
        this.currentColor = ColorPiece.WHITE;
        this.opponentColor = ColorPiece.BLACK;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (GameObserver o : observers) {
            o.onStateChange(this);
        }
    }

    public void swapTurn() {
        Player tmpP = currentPlayer;
        currentPlayer = opponent;
        opponent = tmpP;

        ColorPiece tmpC = currentColor;
        currentColor = opponentColor;
        opponentColor = tmpC;
    }

    public Board getBoard() { return board; }

    public GameState getState() { return state; }
    
    public void setState(GameState state) {
        this.state = state;
        this.state.handleState(this);
    }

    public boolean isFinished() { return finished; }
    
    public void setFinished(boolean finished) { this.finished = finished; }

    public Player getCurrentPlayer() { return currentPlayer; }
    public Player getOpponent() { return opponent; }

    public ColorPiece getCurrentColor() { return currentColor; }
    public ColorPiece getOpponentColor() { return opponentColor; }
}
