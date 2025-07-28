package com.github.streams.practice.c_hard.numbers.problems;

import com.github.streams.practice.c_hard.numbers.HardNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class A_GenerateAPrimeNumberStream {

    @Test
    void intStreamOfPrimeNumber() {
        final var mySolution = HardNumbersProblemSolution.generateIntStreamOfPrimeNumberStream(5);
        final var yourSolution = IntStream.iterate(2, x -> x < Integer.MAX_VALUE, v -> v + 1)
                .filter(num -> IntStream.rangeClosed(2, (int)Math.sqrt(num))
                        .allMatch(n -> num % n != 0))
                .limit(5)
                .boxed()
                .toList();

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
