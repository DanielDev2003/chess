package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public class Knight extends Piece {

    public Knight(ColorPiece colorPiece) {
        super(colorPiece);
    }

    // move-se duas casas na horizontal ou na
    // vertical e depois uma para o lado. O movimento
    // completo do cavalo forma um «L» sobre o tabuleiro. O
    // cavalo é a única peça que pode saltar sobre as
    // outras.

    public boolean canMove() {
        return false;
    }
}
