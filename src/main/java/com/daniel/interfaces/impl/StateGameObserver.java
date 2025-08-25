package com.daniel.interfaces.impl;

import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.GameObserver;
import com.daniel.interfaces.impl.states.CheckState;
import com.daniel.interfaces.impl.states.CheckmateState;
import com.daniel.interfaces.impl.states.InProgressState;
import com.daniel.model.Board;
import com.daniel.model.GameContext;
import com.daniel.model.Piece;

public class StateGameObserver implements GameObserver {

    @Override
    public void onStateChange(GameContext context) {
        Board board = context.getBoard();
        Piece[][] grid = board.getBoardPieces();

        ColorPiece defender = context.getOpponentColor();

        if (isCheckmate(defender, board)) {
            context.setState(new CheckmateState());
        } else if (isKingInCheck(defender, grid)) {
            context.setState(new CheckState());
        } else {
            context.setState(new InProgressState());
        }
    }

    private int[] findKing(ColorPiece color, Piece[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                Piece p = grid[x][y];
                if (p != null && "King".equalsIgnoreCase(p.getName()) && p.getColorPiece() == color) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    private boolean isSquareAttackedBy(ColorPiece attacker, int targetX, int targetY, Piece[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                Piece p = grid[x][y];
                if (p != null && p.getColorPiece() == attacker) {
                    if (p.canMoveFor(targetX, targetY, grid)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isKingInCheck(ColorPiece kingColor, Piece[][] grid) {
        int[] pos = findKing(kingColor, grid);
        if (pos == null) return false;
        int kx = pos[0], ky = pos[1];
        ColorPiece attacker = (kingColor == ColorPiece.WHITE) ? ColorPiece.BLACK : ColorPiece.WHITE;
        return isSquareAttackedBy(attacker, kx, ky, grid);
    }

    private boolean isCheckmate(ColorPiece defender, Board board) {
        Piece[][] grid = board.getBoardPieces();
        if (!isKingInCheck(defender, grid)) return false;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                Piece p = grid[x][y];
                if (p != null && p.getColorPiece() == defender) {
                    for (int nx = 0; nx < 8; nx++) {
                        for (int ny = 0; ny < 8; ny++) {
                            if (!board.isInsideBoardPiece(nx, ny)) continue;
                            if (!p.canMoveFor(nx, ny, grid)) continue;

                            boolean stillInCheck = board.simulateMove(p, nx, ny,
                                    () -> isKingInCheck(defender, grid));

                            if (!stillInCheck) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
