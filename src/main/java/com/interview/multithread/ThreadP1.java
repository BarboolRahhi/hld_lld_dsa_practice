package com.interview.multithread;

import static java.lang.System.*;

public class ThreadP1 {

    public static void main(String[] args) {
        var thread = new Thread(() -> {
            var name = Thread.currentThread().getName();
            out.printf("Thread name %s%n", name);
        });
        thread.start();
    }
}
