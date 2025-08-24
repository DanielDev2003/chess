package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.impl.Moves.MoveKnight;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class Horse extends Piece {

    public Horse(int X, int Y, Player player, ColorPiece colorPiece) {
        super("Horse", "H", player, X, Y, colorPiece, new MoveKnight());
    }
}
