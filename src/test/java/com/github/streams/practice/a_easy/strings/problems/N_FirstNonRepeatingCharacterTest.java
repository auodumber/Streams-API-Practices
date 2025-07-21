package com.github.streams.practice.a_easy.strings.problems;

import com.github.streams.practice.b_medium.ProblemSolutions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Given a String find the first non-repeating character:
 *
 * String = The quick brown fox jumps over the lazy dog, find the first non-repeated character.
 * (Google interview)
 */
class N_FirstNonRepeatingCharacterTest {
    @Test
    void testFirstNonRepeatingCharacter() {
        final var input =
                "The quick brown fox jumps over the lazy dog, find the first non repeated character.";
        final var yourSolution = input.chars().mapToObj(i -> (char) i).distinct().findFirst().get();
        final var mySolution = ProblemSolutions.firstNonRepeatingCharacter(input);

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
