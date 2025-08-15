package com.daniel.Moves;

import com.daniel.Pieces.Piece;

public interface MoveStrategy {
    boolean canMove(Piece piece, int startX, int startY, int endX, int endY);
}