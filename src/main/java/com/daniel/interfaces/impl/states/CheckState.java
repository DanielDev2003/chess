package com.daniel.interfaces.impl.states;

import com.daniel.interfaces.GameState;
import com.daniel.model.GameContext;

public class CheckState implements GameState {
    @Override
    public void handleState(GameContext context) {
        System.out.println("Rei do adversário está em xeque!");
    }

    @Override
    public String getName() {
        return "Xeque";
    }
}