package com.github.streams.practice.a_easy.strings.problems;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
 *   Words with Maximum Vowels: [Hello, World]
 * </pre>
 */
class A_MatchesNoOfVowelsTest {
  @Test
  void testAM_MaxNoOfVowelsTest() {
    var input = "The quick brown fox jumps right over the little lazy dog.";
    final var length = 2;

    var mySolution = StringProblemsSolution.getMatchesVowels(input, length);

    Set<Character> vow = Set.of('a','e','i','o','u');

 var yourSolution = Stream.of(input.split(" "))
            .filter(s ->
                    s.chars()
                            .mapToObj(c -> (char)c).filter(vow::contains).count() == length
            ).toList();

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
