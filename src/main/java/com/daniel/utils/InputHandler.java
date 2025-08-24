package com.daniel.utils;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String askNamePlayerOne() {
        System.out.print("Player one name: ");
        return scanner.nextLine();
    }
    public static String askNamePlayerTwo() {
        System.out.print("Player two name: ");
        return scanner.nextLine();
    }

    public static int askX(String string){
        System.err.print(string);
        int newX = scanner.nextInt();
        return newX;
    }

    public static int askY(String string){
        System.err.print(string);
        int newY = scanner.nextInt();
        return newY;
    }
}
