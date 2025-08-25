package com.daniel.interfaces;

import com.daniel.model.GameContext;

public interface GameState {
    void handleState(GameContext context);
    String getName();
}