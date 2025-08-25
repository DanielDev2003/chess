package com.daniel;

import com.daniel.model.Game;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo de Xadrez!");
        System.out.println("Prepare-se para o desafio...\n");

        Game game = new Game();
        game.run();
    }
}
