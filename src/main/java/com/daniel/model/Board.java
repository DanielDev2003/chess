package com.daniel.model;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.PieceFactory;
import com.daniel.interfaces.impl.ChessPieceFactory;

public class Board {

    private final Piece[][] boardPieces;
    private final PieceFactory factory = new ChessPieceFactory();

    public Board(){
        this.boardPieces = new Piece[8][8];
    }

    public void positionPiece(Player white, Player black){
        placePiecesForPlayer(white, ColorPiece.WHITE, 0, 1);
        placePiecesForPlayer(black, ColorPiece.BLACK, 7, 6);
    }

    private void placePiecesForPlayer(Player player, ColorPiece color, int mainRow, int pawnRow) {

        boardPieces[mainRow][0] = factory.createRook(mainRow, 0, player, color);
        boardPieces[mainRow][1] = factory.createKnight(mainRow, 1, player, color);
        boardPieces[mainRow][2] = factory.createBishop(mainRow, 2, player, color);
        boardPieces[mainRow][3] = factory.createQueen(mainRow, 3, player, color);
        boardPieces[mainRow][4] = factory.createKing(mainRow, 4, player, color);
        boardPieces[mainRow][5] = factory.createBishop(mainRow, 5, player, color);
        boardPieces[mainRow][6] = factory.createKnight(mainRow, 6, player, color);
        boardPieces[mainRow][7] = factory.createRook(mainRow, 7, player, color);

        for (int i = 0; i < 8; i++) {
            boardPieces[pawnRow][i] = factory.createPawn(pawnRow, i, player, color);
        }
    }

    public boolean isInsideBoardPiece(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public boolean movePiece(Piece piece, int newX, int newY) {
        if (!isInsideBoardPiece(newX, newY)) {
            System.out.println("Movimento inválido: fora do tabuleiro!");
            return false;
        }

        if (!piece.canMoveFor(newX, newY, boardPieces)) {
            System.out.println("Movimento inválido para esta peça!");
            return false;
        }

        Piece target = boardPieces[newX][newY];
        if (target != null && target.getPlayer() != piece.getPlayer()) {
            capturePiece(target);
        }

        boardPieces[piece.getPositionX()][piece.getPositionY()] = null;
        boardPieces[newX][newY] = piece;
        piece.moveFor(newX, newY);

        return true;
    }

    private void capturePiece(Piece target) {
        boardPieces[target.getPositionX()][target.getPositionY()] = null;
        target.getPlayer().removePiece(target);
    }

    public Piece[][] getBoardPieces() {
        return boardPieces;
    }

}
