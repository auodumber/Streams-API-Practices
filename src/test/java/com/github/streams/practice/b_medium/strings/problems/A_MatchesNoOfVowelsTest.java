package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

/**
 * Finds the words with the given number of vowels in a given string. <br>
 * <br>
 * Example:
 *
 * <pre>
 *  "The quick brown fox jumps right over the little lazy dog.";
 * </pre>
 *
 * <pre>
 *   Number of Vowels: 2
 *   Words with Maximum Vowels: [quick, over, little]
 * </pre>
 *
 * <br>
 * Example:
 *
 * <pre>
 *  "Hello World";
 * </pre>
 *
 * <pre>
 *   Maximum Number of Vowels: 2
 *   Words with Maximum Vowels: [Hello,World]
 * </pre>
 */
class A_MatchesNoOfVowelsTest {
    @Test
    void testAM_MaxNoOfVowelsTest() {
        var input = "The quick brown fox jumps right over the little lazy dog.";
        final var length = 2;

        Set<String> set = Set.of("A", "E", "I", "O", "U");
        var mySolution = StringProblemsSolution.getMatchesVowels(input, length);
        var yourSolution = Arrays.stream(input.split(" "))
                .filter(s -> s.chars()
                        .mapToObj(i -> String.valueOf((char)i))
                        .filter(c -> set.contains(c.toUpperCase()))
                        .count() == length)
                .toList();
        Assertions.assertEquals(mySolution, yourSolution);
    }
}
