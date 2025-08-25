package com.daniel.interfaces.impl.states;

import com.daniel.interfaces.GameState;
import com.daniel.model.GameContext;

public class InProgressState implements GameState {
    
    @Override
    public void handleState(GameContext context) {
        System.out.println("Jogo em andamento...");
    }

    @Override
    public String getName() {
        return "Em andamento";
    }
}