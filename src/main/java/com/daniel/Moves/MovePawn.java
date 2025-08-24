package com.daniel.Moves;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MovePawn implements MoveStrategy {

    @Override
    public boolean canMove(Piece piece, int startX, int startY, int endX, int endY, Piece[][] board) {
        int direction = (piece.getColorPiece() == ColorPiece.WHITE) ? -1 : 1;

        if (startY == endY) { 
            if (endX == startX + direction) {
                return board[endX][endY] == null;
            }

            if (piece.isFirstMove() && endX == startX + (2 * direction)) {
                return board[endX][endY] == null && board[startX + direction][endY] == null;
            }
        }

        if (Math.abs(startY - endY) == 1 && endX == startX + direction) {
            Piece destinationPiece = board[endX][endY];
            return destinationPiece != null && destinationPiece.getColorPiece() != piece.getColorPiece();
        }

        return false;
    }

}
