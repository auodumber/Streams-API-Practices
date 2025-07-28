package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E_NumberOfOccurencesOfEachWordTest {
  @Test
  public void numberOfOccurencesOfEachWord() {
    final var input = "the quick brown fox jumps right over the little lazy dog little";
    final Map<String, Long> mySolution = StringProblemsSolution.numberOfOccurenceOfEachWord(input);

    Map<String, Long> yourSolution = Stream.of(input.split(" "))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    assertEquals(mySolution, yourSolution);
  }
}
