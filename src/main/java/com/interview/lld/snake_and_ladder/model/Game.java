package com.interview.lld.snake_and_ladder.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private Board board;
    private Dice dice;
    private final Deque<Player> players = new LinkedList<>();
    private Player winner;

    public Game(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        addPlayers(players);
    }

    private void addPlayers(List<Player> players) {
        this.players.addAll(players);
    }

    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn is: " + playerTurn.getId() + " current position is: " + playerTurn.getCurrentPosition());

            int diceNumber = dice.rollDice();
            System.out.println(playerTurn.getId() + " rolled dice: " + diceNumber);

            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumber;

            playerNewPosition = playerHasJump(playerNewPosition);
            playerTurn.setCurrentPosition(playerNewPosition);

            System.out.println("player turn is:" + playerTurn.getId() + " new Position is: " + playerNewPosition);

            if (playerNewPosition > board.size() * board.size() - 1) {
                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS:" + winner.getId());
    }

    private int playerHasJump(int playerNewPosition) {
        if (playerNewPosition > board.size() * board.size() - 1) {
            return playerNewPosition;
        }
        // (playerNewPosition - 1) is done because our cell start from 00 to 99
        var cell = board.getCell(playerNewPosition - 1);
        var jump = cell.jump();
        return switch (jump) {
            case Snake s when s.head() == playerNewPosition -> {
                System.out.println("jump done by: snake");
                yield s.tail();
            }
            case Ladder l when l.start() == playerNewPosition -> {
                System.out.println("jump done by: Ladder");
                yield l.end();
            }
            default -> playerNewPosition;
        };
    }

    private Player findPlayerTurn() {
        var player = players.removeFirst();
        players.addLast(player);
        return player;
    }
}
