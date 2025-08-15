package com.daniel.Pieces;

import com.daniel.enums.ColorPiece;

public abstract class Piece {

    private boolean killed;
    private ColorPiece colorPiece;

    public Piece(ColorPiece colorPiece){
        this.killed = false;
        this.colorPiece = colorPiece;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public ColorPiece getColorPiece() {
        return colorPiece;
    }

    public ColorPiece isWhite() {
        return ColorPiece.WHITE;
    }

    public abstract boolean canMove();

    
    
}
