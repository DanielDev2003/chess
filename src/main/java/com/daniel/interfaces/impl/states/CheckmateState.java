package com.daniel.interfaces.impl.states;

import com.daniel.interfaces.GameState;
import com.daniel.model.GameContext;

public class CheckmateState implements GameState {
    @Override
    public void handleState(GameContext context) {
        System.out.println("Xeque-mate! Fim de jogo.");
        context.setFinished(true);
    }

    @Override
    public String getName() {
        return "Xeque-mate";
    }
}
