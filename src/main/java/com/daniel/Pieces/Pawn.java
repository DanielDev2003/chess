package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.impl.Moves.MovePawn;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class Pawn extends Piece {

    public Pawn(int X, int Y, Player player, ColorPiece colorPiece) {
        super("Pawn", "P", player, X, Y, colorPiece, new MovePawn());
    }

}
