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

        Piece rook1 = factory.createRook(mainRow, 0, player, color);
        boardPieces[mainRow][0] = rook1;
        player.addPiece(rook1);

        Piece knight1 = factory.createKnight(mainRow, 1, player, color);
        boardPieces[mainRow][1] = knight1;
        player.addPiece(knight1);

        Piece bishop1 = factory.createBishop(mainRow, 2, player, color);
        boardPieces[mainRow][2] = bishop1;
        player.addPiece(bishop1);

        Piece queen = factory.createQueen(mainRow, 3, player, color);
        boardPieces[mainRow][3] = queen;
        player.addPiece(queen);

        Piece king = factory.createKing(mainRow, 4, player, color);
        boardPieces[mainRow][4] = king;
        player.addPiece(king);

        Piece bishop2 = factory.createBishop(mainRow, 5, player, color);
        boardPieces[mainRow][5] = bishop2;
        player.addPiece(bishop2);

        Piece knight2 = factory.createKnight(mainRow, 6, player, color);
        boardPieces[mainRow][6] = knight2;
        player.addPiece(knight2);

        Piece rook2 = factory.createRook(mainRow, 7, player, color);
        boardPieces[mainRow][7] = rook2;
        player.addPiece(rook2);

        // Peões
        for (int i = 0; i < 8; i++) {
            Piece pawn = factory.createPawn(pawnRow, i, player, color);
            boardPieces[pawnRow][i] = pawn;
            player.addPiece(pawn);
        }
    }

    public boolean isInsideBoardPiece(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public boolean movePiece(Piece piece, int newX, int newY) {
        if (!isInsideBoardPiece(newX, newY)) {
            System.out.println("Invalid move: off the board!");
            return false;
        }

        if (!piece.canMoveFor(newX, newY, boardPieces)) {
            System.out.println("Invalid move for this piece!");
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
        System.out.println(String.format("\nPiece: %s  of the player: %s was captured", target.getName(), target.getPlayer().getName()));
    }

    public Piece getPieceAt(int x, int y) {
        if (!isInsideBoardPiece(x, y)) return null;
        return boardPieces[x][y];
    }

    public Piece[][] getBoardPieces() {
        return boardPieces;
    }

}
