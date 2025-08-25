package com.daniel.interfaces.impl.states;

import com.daniel.interfaces.GameState;
import com.daniel.model.GameContext;

public class StalemateState implements GameState {
    @Override
    public void handleState(GameContext context) {
        System.out.println("Empate (Stalemate).");
        context.setFinished(true);
    }

    @Override
    public String getName() {
        return "Empate";
    }
}
