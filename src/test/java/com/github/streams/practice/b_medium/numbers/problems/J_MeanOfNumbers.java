package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class J_MeanOfNumbers {
    @Test
    void meanOfNumbers() {
        final var input =
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        final var mySolution = MediumNumbersProblemSolution.meanOfNumbers(input);
        final var yourSolution = input
                .stream()
                .mapToInt(x -> x)
                .average().orElseThrow();

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
