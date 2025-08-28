package com.daniel.interfaces;

import com.daniel.enums.ColorPiece;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public interface PieceFactory {
    Piece createPiece(String name, int x, int y, Player player, ColorPiece color);
    
}
