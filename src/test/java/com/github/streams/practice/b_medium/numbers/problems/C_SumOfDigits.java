package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import com.github.streams.practice.b_medium.numbers.problems.ignore.data.DummyData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * Calculates the sum of digits of a given integer.
 *
 * <p>This method takes an integer as input, breaks it down into individual digits, and returns
 * their sum.
 *
 * <p>Example: <br>
 * Input = 123<br>
 * Output = 6 <br>
 * Explanation: (1 + 2 + 3)
 */
class C_SumOfDigits {

    @Test
    void testSumOfDigits() {
        final var input = DummyData.fakerNumber();
        var mySolution = MediumNumbersProblemSolution.sumOfDigits(input);
        var yourSolution = IntStream.iterate(input, num -> num  > 0, digit -> digit / 10)
                .map(digit -> digit % 10)
                .reduce(0, (a, b) -> a + b);

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
