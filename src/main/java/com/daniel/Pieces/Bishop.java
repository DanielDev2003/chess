package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public class Bishop extends Piece {

    public Bishop(int x, int y, Player player, ColorPiece colorPiece) {
        super("Bishop", "B", player, x, y, colorPiece);
    }

    // movimenta-se em diagonais quantas casas
    // desejar desde que estejam livres.

    public boolean canMove() {
        return false;
    }

}
