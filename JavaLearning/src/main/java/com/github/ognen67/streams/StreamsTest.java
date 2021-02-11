package com.github.ognen67.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {


    public static void main(String[] args) {
        String sentence = "Hello World! I love programming!";

        // to lower case
        List<String> lowerCase = Stream.of(sentence).map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowerCase.toString());

        // to upper case
        List<String> upperCase = lowerCase.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCase.toString());

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // integer ArrayList stream using filter and map
        List<Integer> collect = numbers.stream().filter(c -> c < 8).map(c -> c * c).filter(c -> c < 16).collect(Collectors.toList());
        System.out.println(collect);

        int num = 5;
        System.out.println(filterLessThan(numbers, num));

        // returns the even numbers of a list
        System.out.println(getEvenNumbers(numbers));

        // returns the odd numbers of a list
        System.out.println(getOddNumbers(numbers));

    }

    private static List<Integer> getOddNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
    }

    private static List<Integer> getEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
    }

    // returning a list filtering out the numbers that are less than the num parameter
    private static List<Integer> filterLessThan(List<Integer> numbers, int num) {
        return numbers.stream().filter(n -> n < num).collect(Collectors.toList());
    }


}
