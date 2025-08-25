package com.daniel.model;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.GameObserver;
import com.daniel.interfaces.impl.StateGameObserver;
import com.daniel.utils.BoardView;
import com.daniel.utils.InputHandler;

public class Game {
    
    private final Board board = new Board();
    private final BoardView boardView = new BoardView();
    private Player whitePlayer;
    private Player blackPlayer;

    public void run(){

        whitePlayer = new Player(InputHandler.askNamePlayerOne());
        blackPlayer = new Player(InputHandler.askNamePlayerTwo());

        board.positionPiece(whitePlayer, blackPlayer);

        GameContext context = new GameContext(board, whitePlayer, blackPlayer);
        GameObserver observer = new StateGameObserver();
        context.addObserver(observer);

        while (!context.isFinished()) {

            Player currentPlayer = context.getCurrentPlayer();
            boardView.exibir(board.getBoardPieces(), currentPlayer);

            System.out.println("\n" + currentPlayer.getName() + " (" + (context.getCurrentColor() == ColorPiece.WHITE ? "Brancas" : "Negras") + "), faça seu movimento:");

            int startX = InputHandler.askX("Choose the current part at position (X): ");
            int startY = InputHandler.askY("Choose the current part at position (Y): ");

            int endX = InputHandler.askX("Choose the position you want to take the piece (X): ");
            int endY = InputHandler.askY("Choose the position you want to take the piece (Y): ");

            Piece piece = board.getPieceAt(startX, startY);

            if (piece == null) {
                System.out.println("There is no piece in that position!");
                continue;
            }
            
            System.out.println(piece.getName());
            System.out.println("Posicao X: " + piece.getPositionX() + " Posicao Y: " + piece.getPositionY());

            if (!piece.getPlayer().equals(currentPlayer)) {
                System.out.println("This is not your play!");
                continue;
            }

            if (!board.movePiece(piece, endX, endY)) {
                continue; // jogador repete a jogada
            }

            context.notifyObservers();

            if (!context.isFinished()) {
                context.swapTurn(); // só troca se o jogo não terminou
            }

        }
        System.out.println("\nEnd of game!");
        System.out.println("Estado final: " + context.getState().getName());
        if (context.getState().getName().equalsIgnoreCase("checkmate")) {
            System.out.println("Vencedor: " + context.getCurrentPlayer().getName());
        }
    }

}
