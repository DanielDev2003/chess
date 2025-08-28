package com.daniel.interfaces.impl;

import java.util.HashMap;
import java.util.Map;

import com.daniel.Pieces.Bishop;
import com.daniel.Pieces.King;
import com.daniel.Pieces.Horse;
import com.daniel.Pieces.Pawn;
import com.daniel.Pieces.Queen;
import com.daniel.Pieces.Rook;
import com.daniel.enums.ColorPiece;
import com.daniel.interfaces.PieceFactory;
import com.daniel.model.Piece;
import com.daniel.model.Player;

public class ChessPieceFactory implements PieceFactory {
    
    @FunctionalInterface //interface funcional -> define apenas um método abstrato
    private interface InnerChessPieceFactory {
        Piece create(int x, int y, Player p, ColorPiece c);
    }

    Map<String, InnerChessPieceFactory> pieceFactory = new HashMap<>();
    
    //lambda seria uma forma de criar uma classe anonima para implementar o metodo abstrado da interface funcional.
    //Seria como uma receita de como criar as peças.
    //O mapa vai guardar essas receitas e executalas quando for chama-las.
    public ChessPieceFactory(){
        pieceFactory.put("pawn",   (x, y, p, c) -> new Pawn(x, y, p, c));//Cria um objeto InnerChessPieceFactory que implementa create.
        pieceFactory.put("rook",   (x, y, p, c) -> new Rook(x, y, p, c));
        pieceFactory.put("knight", (x, y, p, c) -> new Horse(x, y, p, c));
        pieceFactory.put("bishop", (x, y, p, c) -> new Bishop(x, y, p, c));
        pieceFactory.put("queen",  (x, y, p, c) -> new Queen(x, y, p, c));
        pieceFactory.put("king",   (x, y, p, c) -> new King(x, y, p, c));
    }
    
    //rescrevendo o metodo abstrato da interface PieceFactory, agora recebendo o nome da peça.
    @Override
    public Piece createPiece(String name, int x, int y, Player player, ColorPiece color){
        
        //instanciando um objeto da interface funcional InnerChessPieceFactory para utilizar o metodo create.
        InnerChessPieceFactory creator = pieceFactory.get(name.toLowerCase());
        
        if(creator == null){
            throw new IllegalArgumentException("Nome de peça inexistente!");
        }

        //chama o metodo create para criar a peça.
        return creator.create(x, y, player, color);
    }
}
