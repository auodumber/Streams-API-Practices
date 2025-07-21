package com.github.streams.practice.a_easy.strings.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class D_NumberOfOccurencesOfEachCharacterTest {
  @Test
  void numberOfOccurencesOfEachCharacter() {
    final String input = "the quick brown fox jumps right over the little lazy dog little";
    final var mySolution = StringProblemsSolution.findOccurenceOfCharacter(input);
    final Map<Character, Long> yourSolution = input.chars().mapToObj(c -> (char) c).filter(c -> !Character.isSpaceChar(c))
                    .collect(Collectors.groupingBy( c -> c,Collectors.counting()));

    assertEquals(mySolution, yourSolution);
  }
}
