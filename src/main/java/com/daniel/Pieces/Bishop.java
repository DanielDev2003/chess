package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public class Bishop extends Piece {
    
    public Bishop(ColorPiece colorPiece){
        super(colorPiece);
    }

    // movimenta-se em diagonais quantas casas
    // desejar desde que estejam livres.

    public boolean canMove(){
        return false;
    }

}
