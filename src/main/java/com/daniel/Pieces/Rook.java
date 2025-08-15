package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public class Rook extends Piece{
    
    public Rook(ColorPiece colorPiece){
        super(colorPiece);
    }

    // move-se em linhas horizontais ou verticais
    // quantas casas desejar desde que esteja livre. 
    
    public boolean canMove(){
        return false;
    }

}
