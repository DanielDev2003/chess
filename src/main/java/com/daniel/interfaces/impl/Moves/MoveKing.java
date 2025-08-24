package com.daniel.interfaces.impl.Moves;

import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MoveKing implements MoveStrategy {
    @Override
    public boolean canMove(Piece piece, int endX, int endY, Piece[][] board) {
        
        int deltaX = Math.abs(piece.getPositionX() - endX);
        int deltaY = Math.abs(piece.getPositionY() - endY);

        boolean isOneSquareMove = Math.max(deltaX, deltaY) == 1;

        if (!isOneSquareMove) {
            return false;
        }

        Piece destinationPiece = board[endX][endY];
        
        if (destinationPiece == null || destinationPiece.getColorPiece() != piece.getColorPiece()) {
            return true;
        }

        return false;
    }

}
