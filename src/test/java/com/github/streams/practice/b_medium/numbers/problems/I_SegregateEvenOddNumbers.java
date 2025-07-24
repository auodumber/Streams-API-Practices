package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Divides a list of integers into two separate lists, one containing all even numbers and the other
 * containing all odd numbers. Input: {1, 2, 3, 4, 5, 6, 7, 8, 9} Output: {2, 4, 6, 8, 1, 3, 5, 7, 9
 * }
 */
class I_SegregateEvenOddNumbers {
    @Test
    void testSegregationOfEvenOddNumbersTest() {
        final var input = IntStream.range(1, 50).boxed();
        final var input2 = IntStream.range(1, 50).boxed();
        final var mySolution = MediumNumbersProblemSolution.segregateEvenOddNumbers(input);
        final var yourSolution = input2
                .collect(Collectors.partitioningBy(num -> num % 2 == 0))
                .values()
                .stream()
                .flatMap(s -> s.stream())
                .toList();

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
