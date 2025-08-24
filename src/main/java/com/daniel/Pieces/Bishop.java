package com.daniel.Pieces;

import com.daniel.Moves.MoveBishop;
import com.daniel.enums.ColorPiece;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class Bishop extends Piece {

    public Bishop(int X, int Y, Player player, ColorPiece colorPiece) {
        super("Bishop", "B", player, X, Y, colorPiece, new MoveBishop());
    }

}
