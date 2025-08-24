package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.impl.Moves.MoveQueen;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class Queen extends Piece {

    public Queen(int X, int Y, Player player, ColorPiece colorPiece){
        super("Queen", "Q", player, X, Y, colorPiece, new MoveQueen());
    }

}
