package com.daniel.utils;

import com.daniel.model.Piece;
import com.daniel.model.Player;

public class BoardView {
    public void exibir(Piece[][] board, Player player) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("--- Chess ---");
        System.out.println("turn : " + player.getName());
        System.out.println("\n     0   1   2   3   4   5   6   7  (X)");
        System.out.println("   +---+---+---+---+---+---+---+---+");
        for (int y = 7; y >= 0; y--) {
            System.out.print(" " + y + " |");
            for (int x = 0; x < 8; x++) {
                Piece piece = board[x][y];
                if (piece == null) {
                    System.out.print(" . |");
                } else {
                    String simbolo = piece.getSymbol();
                    if (piece.getPlayer().getName().contains("Player 1")) {
                        System.out.print(" " + simbolo.toUpperCase() + " |");
                    } else {
                        System.out.print(" " + simbolo.toLowerCase() + " |");
                    }
                }
            }
            System.out.println();
            System.out.println("   +---+---+---+---+---+---+---+---+");
        }
    }
}
