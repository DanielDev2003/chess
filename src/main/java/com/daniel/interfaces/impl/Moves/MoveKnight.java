package com.daniel.interfaces.impl.Moves;

import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MoveKnight implements MoveStrategy {
    @Override
    public boolean canMove(Piece piece, int endX, int endY, Piece[][] board) {
        System.out.println("posicao inicial X: " + piece.getPositionX() + " posical inicial Y: " + piece.getPositionY());
        int deltaX = Math.abs(endX - piece.getPositionX());
        System.out.println("Delta X: " + deltaX);
        int deltaY = Math.abs(endY - piece.getPositionY());
        System.out.println("Delta Y:" + deltaY);

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
