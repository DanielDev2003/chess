package com.daniel.interfaces;

import com.daniel.enums.ColorPiece;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public interface PieceFactory {
    Piece createPawn(int x, int y, Player player, ColorPiece color);
    Piece createRook(int x, int y, Player player, ColorPiece color);
    Piece createKnight(int x, int y, Player player, ColorPiece color);
    Piece createBishop(int x, int y, Player player, ColorPiece color);
    Piece createQueen(int x, int y, Player player, ColorPiece color);
    Piece createKing(int x, int y, Player player, ColorPiece color);
}
