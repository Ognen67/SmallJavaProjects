package com.github.ognen67.threading;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomic {

    public static void main(String[] args) throws InterruptedException {
        int x = getX(1_000_000);
        x = getX(1_000_000);
        System.out.println(x);
    }

    public static int getX(final int total) throws InterruptedException {
        AtomicInteger count = new AtomicInteger();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < total; j++) {
                    count.getAndIncrement();
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int x = count.get();
        return x;
    }
}

