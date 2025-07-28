package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.ProblemSolutions;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Given A String Find the highest number of vowels present in a word.
 *
 * <p>Example: INPUT: HELLO HOW ARE YOU OUTPUT: 2 EXPLANATION: HELLO contains 2 vowels.
 */
class P_WordWithMaxNumberOfVowelsTest {

  @Test
  void testNumberOfVowels() {
    var input = new Faker().chuckNorris().fact();
    final var mySolution = ProblemSolutions.maxNumberOfVowels(input);
    Set<String> set = Set.of("A","I","O","U","E");
    final Integer yourSolution = Stream.of(input.split(" "))
            .map(str -> str.chars().mapToObj(i -> String.valueOf((char)i))
                    .filter(c -> set.contains(c.toUpperCase())).count())

                    .max(Comparator.comparingLong(Long::longValue)).get().intValue();

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
