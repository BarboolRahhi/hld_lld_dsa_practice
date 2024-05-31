package com.interview.lld.design_tic_tac_toe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Grid Size of game:");
        int gridSize = scanner.nextInt();
        System.out.println("Number of players: ");
        int noOfPlayers = scanner.nextInt();
        var list = new ArrayList<Player>();
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter players details: Format (name pieceType)");
            String name = scanner.next();
            String pieceType = scanner.next();
            list.add(new Player(name, pieceType));
        }


        Game game = new Game(gridSize, list);
        game.display();
        while (!game.isGameOver()) {
            Player player = game.getCurrentPlayer();
            int row;
            int column;
            boolean isValid = false;
            while (!isValid) {
                System.out.println(STR."Player \{player.name()}(\{player.pieceType()}) enter row and col:");
                row = scanner.nextInt();
                column = scanner.nextInt();
                isValid = game.move(row, column);
                if (!isValid) {
                    System.out.println("Invalid move!");
                }
            }
            if (game.isWinner(player)) {
                System.out.println(STR."The winner is \{player.name()}.");
                break;
            }
        }
        System.out.println("Game Over");
    }
}
