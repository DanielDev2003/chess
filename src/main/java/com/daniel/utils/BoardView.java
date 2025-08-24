package com.daniel.utils;

import com.daniel.model.Piece;
import com.daniel.model.Player;

public class BoardView {
    public void exibir(Piece[][] board, Player player) {
        System.out.flush();

        System.out.println("\n--- Chess ---\n");
        System.out.println("Player: " + player.getName());
        System.out.println("\n     0   1   2   3   4   5   6   7  (X)");
        System.out.println("   +---+---+---+---+---+---+---+---+");
        for (int y = 7; y >= 0; y--) {
            System.out.print(" " + y + " |");
            for (int x = 0; x < 8; x++) {
                Piece piece = board[x][y];
                if (piece == null) {
                    System.out.print(" . |");
                } else {
                    String symbol = piece.getSymbol();
                    if (piece.isWhite()) {
                        System.out.print(" " + symbol.toUpperCase() + " |");
                    } else {
                        System.out.print(" " + symbol.toLowerCase() + " |");
                    }
                }
            }
            System.out.println();
            System.out.println("   +---+---+---+---+---+---+---+---+");
        }
        System.out.println("\n");
    }
}
