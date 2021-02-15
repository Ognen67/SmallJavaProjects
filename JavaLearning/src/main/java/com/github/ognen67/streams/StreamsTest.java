package com.github.ognen67.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        // Prints the sum of the numbers ArrayList
        System.out.println(numbers.stream().reduce(0, Integer::sum));

        // Sum of the even numbers
        System.out.println(numbers.stream().filter(number -> number % 2 == 0).reduce(Integer::sum));

        System.out.println(getEvenNumbers(numbers).stream().reduce(Integer::sum));

        // Double the even numbers and print the sum of them
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).reduce(0, (result, x) -> result += x * 2));

        System.out.println(numbers.stream().filter(x -> x % 2 == 0).map(x -> x * 2).reduce(0, (result, x) -> result += x));

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(intStream.filter(x -> x % 2 == 0).map(x -> x * 2).sum());

        // Print first even element bigger than 3 doubled
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 5, 7, 6, 4, 8, 9, 10));
        System.out.println(
            list.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst());

        List<Integer> lista = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));

        int sum = 0;
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i) > 3 && lista.get(i) % 2 == 0) {
                sum += lista.get(i) * 2;
            }
        }

        System.out.println(sum);

        sum = lista.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> e * 2)
                .sum();

        System.out.println(sum);

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
