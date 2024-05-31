package com.interview.lld.snake_and_ladder;

import com.interview.lld.snake_and_ladder.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {

        var reader = new BufferedReader(new InputStreamReader(System.in));

        int snakeLen = Integer.parseInt(reader.readLine());
        var snakes = new ArrayList<Snake>();
        for (int i = 0; i < snakeLen; i++) {
            int[] snakeArr = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            snakes.add(new Snake(snakeArr[0], snakeArr[1]));
        }

        int ladderLen = Integer.parseInt(reader.readLine());
        var ladders = new ArrayList<Ladder>();
        for (int i = 0; i < ladderLen; i++) {
            int[] ladderArr = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ladders.add(new Ladder(ladderArr[0], ladderArr[1]));
        }


        Board board = new Board(10, snakes, ladders);

        var players = List.of(
                new Player("rahhi", 0),
                new Player("anku", 0)
        );

        var dice = new Dice(1);
        Game game = new Game(board, dice , players);
        game.startGame();

    }
}
