package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public class King extends Piece {

    public King(ColorPiece colorPiece){
        super(colorPiece);
    }

    // REI: move-se uma casa por vez em qualquer direção ou
    // sentido.

    public boolean canMove(){
        return false;
    }
}
