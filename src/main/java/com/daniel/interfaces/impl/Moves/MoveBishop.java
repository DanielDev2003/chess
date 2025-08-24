package com.daniel.interfaces.impl.Moves;

import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MoveBishop implements MoveStrategy {

    @Override
    public boolean canMove(Piece piece, int endX, int endY, Piece[][] board) {
        if (piece.getPositionX() == endX && piece.getPositionY() == endY) {
            return false;
        }

        if (Math.abs(piece.getPositionX() - endX) != Math.abs(piece.getPositionY() - endY)) {
            return false;
        }

        int xDirection = (endX > piece.getPositionX()) ? 1 : -1;
        int yDirection = (endY > piece.getPositionY()) ? 1 : -1;

        int currentX = piece.getPositionX() + xDirection;
        int currentY = piece.getPositionY() + yDirection;

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
