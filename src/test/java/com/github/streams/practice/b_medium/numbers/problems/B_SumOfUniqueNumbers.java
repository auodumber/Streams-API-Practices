package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Calculates the sum of unique elements in an array. <br>
 * Example: <br>
 * Input: [5, 6, 7, 8, 5, 5, 8, 8, 7]<br>
 * Output: 26
 */
class B_SumOfUniqueNumbers {

    @Test
    void testSumOfUniqueDigitsTest() {
        final var input = List.of(5, 6, 7, 8, 5, 5, 8, 8, 7);
        var mySolution = MediumNumbersProblemSolution.sumOfUniqueNumbers(input);
        var yourSolution = input.stream()
                .distinct().mapToInt(Integer::intValue).sum();

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
