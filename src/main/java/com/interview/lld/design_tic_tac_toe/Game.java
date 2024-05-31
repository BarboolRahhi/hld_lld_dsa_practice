package com.interview.lld.design_tic_tac_toe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Cell[][] grid;
    private final int gridSize;
    private final Queue<Player> pieceTypesQueue;
    private int currentMove = 0;
    private Player currentPlayer;
    public Game(int gridSize, List<Player> players) {
        this.gridSize = gridSize;
        this.grid = new Cell[gridSize][gridSize];
        this.pieceTypesQueue = new LinkedList<>();
        players.forEach(pieceTypesQueue::offer);
        currentPlayer = pieceTypesQueue.peek();
    }

    public boolean move(int row, int col) throws RuntimeException {
        if (row > gridSize - 1 || col > gridSize - 1 || grid[row][col] != null) {
            return false;
        }
        var player = pieceTypesQueue.poll();
        String turnPiece = player.pieceType();
        grid[row][col] = new Cell(turnPiece);
        pieceTypesQueue.offer(player);
        currentMove++;
        display();

        currentPlayer = pieceTypesQueue.peek();
        return true;
    }

    public boolean isWinner(Player player) {
        return checkWinner(player.pieceType());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private boolean checkWinner(String pieceType) {
        // check for all row
        for (int i = 0; i < gridSize; i++) {
            if (checkRow(i, pieceType)) {
                return true;
            }
            if (checkCol(i, pieceType)) {
                return true;
            }
        }

        return checkDiagonalOne(pieceType) || checkDiagonalTwo(pieceType);
    }

    private boolean checkDiagonalOne(String pieceType) {
        for (int i = 0; i < gridSize; i++) {
            if (grid[i][i] == null || !grid[i][i].pieceType().equals(pieceType)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonalTwo(String pieceType) {
        for (int i = 0; i < gridSize; i++) {
            if (grid[i][gridSize - 1 - i] == null || !grid[i][gridSize - 1 - i].pieceType().equals(pieceType)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int position, String pieceType) {
        for (int j = 0; j <gridSize; j++) {
            if (grid[position][j] == null || !grid[position][j].pieceType().equals(pieceType)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int position, String pieceType) {
        for (int j = 0; j <gridSize; j++) {
            if (grid[j][position] == null || !grid[j][position].pieceType().equals(pieceType)) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (Cell[] cells : grid) {
            for (int j = 0; j < grid.length; j++) {
                if (cells[j] != null) {
                    System.out.print(STR."\{cells[j].pieceType()} ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public boolean isGameOver() {
        return currentMove > gridSize * gridSize - 1;
    }
}
