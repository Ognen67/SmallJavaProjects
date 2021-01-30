package com.github.ognen67.threading;

public class ThreadSynchronized {

    int count = 0;

    public static void main(String[] args) throws InterruptedException {

        int x = getX(1_000_000);
        x = getX(1_000_000);
        System.out.println(x);
    }

    public static int getX(int total) throws InterruptedException {
        ThreadSynchronized threadOne = new ThreadSynchronized();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < total; i++) {
                synchronized (threadOne) {
                    threadOne.count++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < total; i++) {
                synchronized (threadOne) {
                    threadOne.count++;
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return threadOne.count;
    }
}
