package com.daniel.Moves;

import com.daniel.Pieces.Piece;

public class MoveRook implements MoveStrategy {
    @Override
    public boolean canMove(Piece piece, int startX, int startY, int endX, int endY, Piece[][] board) {
        if (startX == endX && startY == endY) {
            return false;
        }

        if (startX != endX && startY != endY) {
            return false;
        }
        if (startY == endY) {
            int minX = Math.min(startX, endX);
            int maxX = Math.max(startX, endX);
            for (int x = minX + 1; x < maxX; x++) {
                if (board[x][startY] != null) {
                    return false;
                }
            }
        } else {
            int minY = Math.min(startY, endY);
            int maxY = Math.max(startY, endY);

            for (int y = minY + 1; y < maxY; y++) {
                if (board[startX][y] != null) {
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
