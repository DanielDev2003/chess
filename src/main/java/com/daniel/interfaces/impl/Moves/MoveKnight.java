package com.daniel.interfaces.impl.Moves;

import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MoveKnight implements MoveStrategy {
    @Override
    public boolean canMove(Piece piece, int startX, int startY, int endX, int endY, Piece[][] board) {
        int deltaX = Math.abs(startX - endX);
        int deltaY = Math.abs(startY - endY);

        boolean isLShape = (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);

        if (!isLShape) {
            return false;
        }

        Piece destinationPiece = board[endX][endY];

        if (destinationPiece == null || destinationPiece.getColorPiece() != piece.getColorPiece()) {
            return true;
        }

        return false;
    }

}
