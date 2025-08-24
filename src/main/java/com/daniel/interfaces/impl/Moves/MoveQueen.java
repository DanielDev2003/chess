package com.daniel.interfaces.impl.Moves;

import com.daniel.interfaces.MoveStrategy;
import com.daniel.model.Piece;

public class MoveQueen implements MoveStrategy {

    @Override
    public boolean canMove(Piece piece, int endX, int endY, Piece[][] board) {

        if (piece.getPositionX() == endX && piece.getPositionY() == endY) {
            return false;
        }

        // movimento horizontal
        if (piece.getPositionY() == endY) {
            return isPathClear(piece.getPositionX(), piece.getPositionY(), endX, endY, board);
        }

        // movimento vertical
        if (piece.getPositionX() == endX) {
            return isPathClear(piece.getPositionX(), piece.getPositionY(), endX, endY, board);
        }

        // movimento diagonal
        if (Math.abs(endX - piece.getPositionX()) == Math.abs(endY - piece.getPositionY())) {
            return isPathClear(piece.getPositionX(), piece.getPositionY(), endX, endY, board);
        }

        // caso não seja reto nem diagonal → inválido
        return false;

    }

    private boolean isPathClear(int startX, int startY, int endX, int endY, Piece[][] board) {

        int stepX = Integer.compare(endX, startX); // se a > b retorna 1, se a < b retorna -1, se a == b retorna 0
        int stepY = Integer.compare(endY, startY); 

        int x = startX + stepX;
        int y = startY + stepY;

        // percorre o caminho até 1 antes do destino
        while (x != endX || y != endY) {
            if (board[x][y] != null) {
                return false; // caminho bloqueado
            }
            x += stepX;
            y += stepY;
        }

        // destino pode estar vazio ou conter peça inimiga
        return (board[endX][endY] == null || board[endX][endY].getPlayer() != board[startX][startY].getPlayer());
    }
    
}
