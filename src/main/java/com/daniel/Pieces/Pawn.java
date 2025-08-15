package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public class Pawn extends Piece {
    
    public Pawn(ColorPiece colorPiece){
        super(colorPiece);
    }

    //move-se sempre para frente, uma casa por vez,
    // podendo em cada primeira jogada de cada peão
    // escolher mover uma ou duas casas. O peão é a única
    // peça que captura de forma diferente do seu
    // movimento. Sua captura é na diagonal, uma casa por
    // vez.
    public boolean canMove(){
        return false;
    }

}
