package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class K_FindDuplicateStrings {
    @Test
    void findDuplicateStrings() {
        final var input = List.of("Hellow", "World", "How", "are", "you", "How", "are", "you");
        final var mySolution = StringProblemsSolution.findDuplicateStrings(input);
        final var yourSolution = input.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .toList();
        Assertions.assertEquals(mySolution, yourSolution);
    }
}
