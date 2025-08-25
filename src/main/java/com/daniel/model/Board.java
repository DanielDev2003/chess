package com.daniel.model;

import java.util.function.BooleanSupplier;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.PieceFactory;
import com.daniel.interfaces.impl.ChessPieceFactory;
import com.daniel.interfaces.impl.StateGameObserver;

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

        // linha principal (y = mainRow)
        boardPieces[mainRow][0] = add(player, factory.createRook(mainRow, 0, player, color));
        boardPieces[mainRow][1] = add(player, factory.createKnight(mainRow, 1, player, color));
        boardPieces[mainRow][2] = add(player, factory.createBishop(mainRow, 2, player, color));
        boardPieces[mainRow][3] = add(player, factory.createQueen(mainRow, 3, player, color));
        boardPieces[mainRow][4] = add(player, factory.createKing(mainRow, 4, player, color));
        boardPieces[mainRow][5] = add(player, factory.createBishop(mainRow, 5, player, color));
        boardPieces[mainRow][6] = add(player, factory.createKnight(mainRow, 6, player, color));
        boardPieces[mainRow][7] = add(player, factory.createRook(mainRow, 7, player, color));

        // peões (y = pawnRow)
        for (int x = 0; x < 8; x++) {
            boardPieces[pawnRow][x] = add(player, factory.createPawn(pawnRow, x, player, color));
        }
    }

    private Piece add(Player owner, Piece p) {
        owner.addPiece(p);
        return p;
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

        if (target != null && "King".equalsIgnoreCase(target.getName())) {
            System.out.println("Movimento ilegal: você não pode capturar o rei adversário!");
            return false;
        }

        // Essa parte está criando uma nova instância da classe StateGameObserver no momento da execução.
        // Mesmo que você nunca tenha guardado essa instância em uma variável, você pode usar ela imediatamente.
        boolean ownKingInCheck = simulateMove(piece, newX, newY, () ->
        new com.daniel.interfaces.impl.StateGameObserver() 
            .isKingInCheck(piece.getColorPiece(), boardPieces)
        );

        if (ownKingInCheck) {
            System.out.println("Movimento ilegal: seu rei ficaria em cheque!");
            return false;
        }

        // ✔️ Executa o movimento real
        boardPieces[piece.getPositionX()][piece.getPositionY()] = null;
        boardPieces[newX][newY] = piece;
        piece.moveFor(newX, newY);

        // ✔️ Captura a peça adversária (não sendo o rei, que já foi tratado acima)
        if (target != null && target.getPlayer() != piece.getPlayer()) {
            capturePiece(target);
        }

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

    public boolean simulateMove(Piece piece, int endX, int endY, BooleanSupplier check) {
        int startX = piece.getPositionX();
        int startY = piece.getPositionY();
        Piece captured = boardPieces[endX][endY];

        boardPieces[startX][startY] = null;
        boardPieces[endX][endY] = piece;
        piece.moveFor(endX, endY);

        boolean result;
        try {
            result = check.getAsBoolean();
        } finally {
            piece.moveFor(startX, startY);
            boardPieces[endX][endY] = captured;
            boardPieces[startX][startY] = piece;
        }
        return result;
    }
}
