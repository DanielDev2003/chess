package com.daniel.interfaces.impl.Moves;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MovePawn implements MoveStrategy {

    @Override
    public boolean canMove(Piece piece, int endX, int endY, Piece[][] board) {
        int direction = (piece.getColorPiece() == ColorPiece.WHITE) ? 1 : -1;

        if (piece.getPositionY() == endY) { 
            if (endX == piece.getPositionX() + direction) {
                return board[endX][endY] == null;
            }

            if (piece.isFirstMove() && endX == piece.getPositionX() + (2 * direction)) {
                return board[endX][endY] == null && board[piece.getPositionX() + direction][endY] == null;
            }
        }

        if (Math.abs(piece.getPositionY() - endY) == 1 && endX == piece.getPositionX() + direction) {
            Piece destinationPiece = board[endX][endY];
            return destinationPiece != null && destinationPiece.getColorPiece() != piece.getColorPiece();
        }

        return false;
    }

}
