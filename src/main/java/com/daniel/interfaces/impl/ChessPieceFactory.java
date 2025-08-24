package com.daniel.interfaces.impl;

import com.daniel.Pieces.Bishop;
import com.daniel.Pieces.King;
import com.daniel.Pieces.Knight;
import com.daniel.Pieces.Pawn;
import com.daniel.Pieces.Queen;
import com.daniel.Pieces.Rook;
import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.PieceFactory;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class ChessPieceFactory implements PieceFactory {
     @Override
    public Piece createPawn(int x, int y, Player player, ColorPiece color) {
        return new Pawn(x, y, player, color);
    }

    @Override
    public Piece createRook(int x, int y, Player player, ColorPiece color) {
        return new Rook(x, y, player, color);
    }

    @Override
    public Piece createKnight(int x, int y, Player player, ColorPiece color) {
        return new Knight(x, y, player, color);
    }

    @Override
    public Piece createBishop(int x, int y, Player player, ColorPiece color) {
        return new Bishop(x, y, player, color);
    }

    @Override
    public Piece createQueen(int x, int y, Player player, ColorPiece color) {
        return new Queen(x, y, player, color);
    }

    @Override
    public Piece createKing(int x, int y, Player player, ColorPiece color) {
        return new King(x, y, player, color);
    }
}
