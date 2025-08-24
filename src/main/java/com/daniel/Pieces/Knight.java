package com.daniel.Pieces;

import com.daniel.Moves.MoveKnight;
import com.daniel.enums.ColorPiece;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class Knight extends Piece {

    public Knight(int X, int Y, Player player, ColorPiece colorPiece) {
        super("Knight", "k", player, Y, X, colorPiece, new MoveKnight());
    }
}
