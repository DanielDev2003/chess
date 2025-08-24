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

            int startX = InputHandler.askX("Origem X: ");
            int startY = InputHandler.askY("Origem Y: ");

            int endX = InputHandler.askX("Destino X: ");
            int endY = InputHandler.askY("Destino Y: ");

            Piece piece = board.getPieceAt(startX, startY);

            if (piece == null) {
                System.out.println("Não existe peça nessa posição!");
                continue;
            }

            System.out.println(piece);
            System.out.println(piece.getPositionX());
            System.out.println(piece.getPositionY());

            
            if (!piece.getPlayer().equals(currentPlayer)) {
                System.out.println("Essa não é sua peça!");
                continue;
            }

            boolean moved = board.movePiece(piece, endX, endY);
            if (!moved) {
                continue; // jogador repete a jogada
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;

        }
        System.out.println("\nFim de jogo!");
        if (player1.hasPieces()) {
            System.out.println("Vencedor: " + player1.getName());
        } else {
            System.out.println("Vencedor: " + player2.getName());
        }
    }

}
