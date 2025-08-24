package com.daniel.Pieces;

import com.daniel.Moves.MoveRook;
import com.daniel.enums.ColorPiece;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class Rook extends Piece {

    public Rook(int X, int Y, Player player, ColorPiece colorPiece) {
        super("Rook", "R", player, X, Y, colorPiece, new MoveRook());
    }

}
