package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public class Queen extends Piece {
    
    public Queen(ColorPiece colorPiece){
        super(colorPiece);
    }

    // combina os movimentos do bispo e da torre:
    // move-se quantas casas desejar nas retas
    // horizontais, verticais e diagonais desde que
    // estejam livres.

    public boolean canMove(){
        return false;
    }
}
