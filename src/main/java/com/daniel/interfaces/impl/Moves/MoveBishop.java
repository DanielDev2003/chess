package com.daniel.interfaces.impl.Moves;

import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MoveBishop implements MoveStrategy {

    @Override
    public boolean canMove(Piece piece, int startX, int startY, int endX, int endY, Piece[][] board) {
        if (startX == endX && startY == endY) {
            return false;
        }

        if (Math.abs(startX - endX) != Math.abs(startY - endY)) {
            return false;
        }

        int xDirection = (endX > startX) ? 1 : -1;
        int yDirection = (endY > startY) ? 1 : -1;

        int currentX = startX + xDirection;
        int currentY = startY + yDirection;

        while (currentX != endX) {
            if (board[currentX][currentY] != null) {
                return false;
            }
            currentX += xDirection;
            currentY += yDirection;
        }

        Piece destinationPiece = board[endX][endY];

        if (destinationPiece == null || destinationPiece.getColorPiece() != piece.getColorPiece()) {
            return true;
        }

        return false;
    }
}
