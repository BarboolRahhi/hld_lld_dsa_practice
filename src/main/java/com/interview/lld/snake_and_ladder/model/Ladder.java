package com.interview.lld.snake_and_ladder.model;

public record Ladder(
        int start,
        int end
) implements Jump {
}
