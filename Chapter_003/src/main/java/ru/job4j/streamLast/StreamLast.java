package ru.job4j.streamLast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLast {
    public static void main(String[] args) {
        List <List <Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        List <Integer> str = matrix.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
