package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.ProblemSolutions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

/**
 * Given a String find the first non-repeating character:
 *
 * <p>String = The quick brown fox jumps over the lazy dog, find the first non-repeated character.
 * (Google interview)
 */
class N_FirstNonRepeatingCharacterTest {
    @Test
    void testFirstNonRepeatingCharacter() {
        final var input =
                "The quick brown fox jumps over the lazy dog, find the first non repeated character.";
        final var mySolution = ProblemSolutions.firstNonRepeatingCharacter(input);

        final var yourSolution = input.chars()
                .mapToObj(s -> Character.valueOf((char) s))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(en -> en.getValue() == 1)
                .findFirst()
                .map(e -> e.getKey())
                .orElseThrow();

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
