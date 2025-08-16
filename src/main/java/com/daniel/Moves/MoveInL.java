package com.daniel.Moves;

import com.daniel.Pieces.Piece;

public class MoveInL implements MoveStrategy {
    @Override
    public boolean canMove(Piece piece, int startX, int startY, Piece[][] board) {
        int deltaX = Math.abs(startX - piece.getPositionX());
        int deltaY = Math.abs(startY - piece.getPositionY());
        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }

}
