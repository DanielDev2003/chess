package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.impl.Moves.MoveKing;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class King extends Piece {

    public King(int X, int Y, Player player, ColorPiece colorPiece) {
        super("King", "K", player, X, Y, colorPiece, new MoveKing());
    }

}
