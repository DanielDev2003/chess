package com.daniel.model;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.MoveStrategy;

public abstract class Piece {

    private final String name;
    private final String symbol;

    private int positionX;
    private int positionY;

    private final Player player;

    private ColorPiece colorPiece;

    private final MoveStrategy moveStrategy;
    
    private boolean hasMoved = false;

    public Piece(String name, String symbol, Player player, int x, int y, ColorPiece colorPiece,
            MoveStrategy moveStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.player = player;
        this.positionX = x;
        this.positionY = y;
        this.moveStrategy = moveStrategy;
        this.colorPiece = colorPiece;
        this.hasMoved = false;

    }

    public boolean canMoveFor(int newX, int newY, Piece[][] board) {
        return moveStrategy.canMove(this, positionX, positionY, newX, newY, board);
    }

    public void moveFor(int newX, int newY) {
        this.positionX = newX;
        this.positionY = newY;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Player getPlayer() {
        return player;
    }

    public ColorPiece getColorPiece() {
        return colorPiece;
    }

    public ColorPiece isWhite() {
        return ColorPiece.WHITE;
    }

    public boolean isFirstMove() {
        return !this.hasMoved;
    }

    public void removePiece(Piece piece){
        player.removePiece(piece);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", name, symbol, colorPiece);
    }

}
