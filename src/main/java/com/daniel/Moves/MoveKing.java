package com.daniel.Moves;

import com.daniel.Pieces.Piece;

public class MoveKing implements MoveStrategy {
    @Override
    public boolean canMove(Piece piece, int startX, int startY, int endX, int endY, Piece[][] board) {
        
        int deltaX = Math.abs(startX - endX);
        int deltaY = Math.abs(startY - endY);

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
