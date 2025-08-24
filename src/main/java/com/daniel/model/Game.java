package com.daniel.model;

import com.daniel.utils.BoardView;
import com.daniel.utils.InputHandler;

public class Game {
    
    private Board board = new Board();
    BoardView boardView = new BoardView();
    private Player player1;
    private Player player2;

    public void run(){

        player1 = new Player(InputHandler.askNamePlayerOne());
        player2 = new Player(InputHandler.askNamePlayerTwo());

        board.positionPiece(player1, player2);

        Player currentPlayer = player1;

        while (player1.hasPieces() && player2.hasPieces()) {
            
            boardView.exibir(board.getBoardPieces(), currentPlayer);

            int startX = InputHandler.askX("Choose the current part at position (X): ");
            int startY = InputHandler.askY("Choose the current part at position (Y): ");

            int endX = InputHandler.askX("Choose the position you want to take the piece (X): ");
            int endY = InputHandler.askY("Choose the position you want to take the piece (Y): ");

            Piece piece = board.getPieceAt(startX, startY);

            if (piece == null) {
                System.out.println("There is no piece in that position!");
                continue;
            }
            
            if (!piece.getPlayer().equals(currentPlayer)) {
                System.out.println("This is not your play!");
                continue;
            }

            if (!board.movePiece(piece, endX, endY)) {
                continue; // jogador repete a jogada
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;

        }
        System.out.println("\nEnd of game!");
        if (player1.hasPieces()) {
            System.out.println("Winner: " + player1.getName());
        } else {
            System.out.println("Loser: " + player2.getName());
        }
    }

}
