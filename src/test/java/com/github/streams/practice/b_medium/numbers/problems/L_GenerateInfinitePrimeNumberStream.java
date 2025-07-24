package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class L_GenerateInfinitePrimeNumberStream {

    @Test
    void intStreamOfPrimeNumber() {
        final var limit = 5;
        final var mySolution = MediumNumbersProblemSolution.generateIntStreamOfPrimeNumberStream(limit);
        final var yourSolution = IntStream.iterate(2, n -> n < Integer.MAX_VALUE, v -> v + 1)
                .filter(number -> IntStream
                        .rangeClosed(2, (int) Math.sqrt(number))
                        .allMatch(d -> number % d != 0))
                .limit(limit)
                .boxed().peek(x -> System.out.print(x + ","))
                .toList();

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
