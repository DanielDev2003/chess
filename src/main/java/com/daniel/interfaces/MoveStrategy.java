package com.daniel.interfaces;

import com.daniel.model.Piece;

public interface MoveStrategy {
    boolean canMove(Piece piece, int endX, int endY, Piece[][] board);
}