package com.daniel.model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Piece> pieces;

    public Player(String name) {
        this.name = name;
        this.pieces = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }

    public boolean hasPieces() {
        return !pieces.isEmpty();
    }

    public void clearPieces() {
        pieces.clear();
    }

}
