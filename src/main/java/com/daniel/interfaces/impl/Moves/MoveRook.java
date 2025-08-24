package com.daniel.interfaces.impl.Moves;

import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MoveRook implements MoveStrategy {
    @Override
    public boolean canMove(Piece piece, int endX, int endY, Piece[][] board) {
        if (piece.getPositionX() == endX && piece.getPositionY() == endY) {
            return false;
        }

        if (piece.getPositionY() == endY) {
            int minX = Math.min(piece.getPositionX(), endX);
            int maxX = Math.max(piece.getPositionX(), endX);
            for (int x = minX + 1; x < maxX; x++) {
                if (board[x][piece.getPositionY()] != null) {
                    return false;
                }
            }
        } else {
            int minY = Math.min(piece.getPositionY(), endY);
            int maxY = Math.max(piece.getPositionY(), endY);

            for (int y = minY + 1; y < maxY; y++) {
                if (board[piece.getPositionX()][y] != null) {
                    return false;
                }
            }
        }
        Piece destinationPiece = board[endX][endY];

        if (destinationPiece == null || destinationPiece.getColorPiece() != piece.getColorPiece()) {
            return true;
        }

        return false;
    }

}
