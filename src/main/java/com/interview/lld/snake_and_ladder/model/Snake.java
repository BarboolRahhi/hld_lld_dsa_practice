package com.interview.lld.snake_and_ladder.model;

public record Snake(
        int head,
        int tail
) implements Jump { }
