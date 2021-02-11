package com.github.ognen67.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    public static void main(String[] args) {
        String sentence = "Hello World! I love programming!";
        List<String> lowerCase = Stream.of(sentence).map(String::toLowerCase).collect(Collectors.toList()); // to lower case
        System.out.println(lowerCase.toString());

        List<String> upperCase = lowerCase.stream().map(String::toUpperCase).collect(Collectors.toList()); // to upper case
        System.out.println(upperCase.toString());

    }


}
