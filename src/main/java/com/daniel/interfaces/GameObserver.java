package com.daniel.interfaces;

import com.daniel.model.GameContext;

public interface GameObserver {
    void onStateChange(GameContext context);
}
