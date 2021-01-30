package com.github.ognen67.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadLongAdderStream {

    public static void main(String[] args) throws InterruptedException {

        int x = getX(1_000_000);
        x = getX(1_000_000);
        System.out.println(x);
    }

    public static int getX(final int total) throws InterruptedException {
        LongAdder count = new LongAdder();

        List<Thread> threads = IntStream.range(0, 200)
                .mapToObj(value -> createThread(total, count))
                .peek(Thread::start)
                .collect(Collectors.toList());
        
        for (Thread thread : threads) {
            thread.join();
        }

        return count.intValue();
    }

    private static Thread createThread(int total, LongAdder count) {
        return new Thread(() -> {
            for (int j = 0; j < total; j++) {
                count.increment();
            }
        });
    }
}

