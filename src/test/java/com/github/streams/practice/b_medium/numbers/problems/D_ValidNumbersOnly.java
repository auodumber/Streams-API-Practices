package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Extracts integers from a list of strings. <br>
 * <br>
 * Example:<br>
 * Input: ["as", "123",* "32", "2as"]<br>
 * Output: [123, 32]<br>
 * Explanation: Parses strings as integers and returns a list of valid integers.
 */
class D_ValidNumbersOnly {
    @Test
    void testCheckAllIntegersWithoutAlphabets() {
        final var input = List.of("1", "12", "12a", "a12");
        var yourSolution = input.stream().mapMulti((s, consumer) -> {
            try {
                Integer.parseInt(s);
                consumer.accept(s);
            } catch (RuntimeException e) {
            }
        }).toList();
        var mySolution = MediumNumbersProblemSolution.getNumberOnly(input);

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
