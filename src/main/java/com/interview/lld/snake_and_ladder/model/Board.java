package com.interview.lld.snake_and_ladder.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board {

    private Cell[][] cells;

    // for snake head is the key
    private final Map<Integer, Snake> snakeMap;

    // for ladder start is the key
    private final Map<Integer, Ladder> ladderMap;

    public Board(int boardSize, List<Snake> snakes, List<Ladder> ladders) {
        this.snakeMap = snakes.stream().collect(Collectors.toMap(Snake::head, Function.identity()));
        this.ladderMap = ladders.stream().collect(Collectors.toMap(Ladder::start, Function.identity()));
        initializeCells(boardSize);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        int position = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                position += 1;
                if (snakeMap.containsKey(position)) {
                    var snake = snakeMap.get(position);
                    var cell = new Cell(snake);
                    cells[i][j] = cell;
                } else if (ladderMap.containsKey(position)) {
                    var ladder = ladderMap.get(position);
                    var cell = new Cell(ladder);
                    cells[i][j] = cell;
                } else {
                    var cell = new Cell(null);
                    cells[i][j] = cell;
                }
            }
        }
    }

    public int size() {
        return this.cells.length;
    }

    public Cell getCell(int position) {
        int boardRow = position / cells.length;
        int boardColumn = (position % cells.length);
        return cells[boardRow][boardColumn];
    }

}
