package com.github.ognen67.threading;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

public class ThreadTest {

//    @Benchmark
    public int threadSynchronized() throws InterruptedException {
        return ThreadSynchronized.getX(1_000_000);
    }

    @Benchmark
    public int threadAtomic() throws InterruptedException {
        return ThreadAtomic.getX(1_000_000);
    }

    @Benchmark
    public int threadLongAdder() throws InterruptedException {
        return ThreadLongAdder.getX(1_000_000);
    }

    public static void main(String[] args) throws IOException, RunnerException {
        final Options options = new OptionsBuilder().forks(1)
                .warmupIterations(1)
                .include(ThreadTest.class.getCanonicalName())
                .measurementIterations(10)
                .addProfiler(GCProfiler.class)
                .build();
        new Runner(options).run();
    }
}
