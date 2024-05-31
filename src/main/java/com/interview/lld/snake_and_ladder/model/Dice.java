package com.interview.lld.snake_and_ladder.model;

import java.util.concurrent.ThreadLocalRandom;

public record Dice(
        int count
) {

    private static final int MIN = 1;
    private static final int MAX = 6;

    public int rollDice() {
        int totalSum = 0;
        int diceUsed = 0;
        while (diceUsed < count) {
            totalSum += ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            diceUsed++;
        }
        return totalSum;
    }
}
