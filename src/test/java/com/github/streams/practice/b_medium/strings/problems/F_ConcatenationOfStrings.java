package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class F_ConcatenationOfStrings {
    /**
     * Given a list of strings, write a method to concatenate all the strings in the list, separated
     * by a comma, using Java 8 Streams.
     */
    @Test
    void testConcatenationOfStrings() {
        List<String> input = List.of("Hellow", "World", "Hello", "World");
        final var mySolution = StringProblemsSolution.concatenateStrings(input);
        final var yourSolution = input.stream().collect(Collectors.joining(","));

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
