package com.github.ognen67.streams;

import java.util.stream.Stream;

public class InifiniteStreams {
    public static void main(String[] args) {
        int k = 1;
        int n = 100;
        int result = compute(k, n);
        System.out.println(result);
    }

    private static int compute(int k, int n) {
        return Stream.iterate(k, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(n)
                .sum();
    }
}
