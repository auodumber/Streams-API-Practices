package com.github.streams.practice.a_easy.strings.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class E_NumberOfOccurencesOfEachWordTest {
  @Test
  @Disabled
  public void numberOfOccurencesOfEachWord() {
    final var input = "the quick brown fox jumps right over the little lazy dog little";
    final Map<String, Long> mySolution = StringProblemsSolution.numberOfOccurenceOfEachWord(input);

    Map<String, Long> yourSolution = Stream.of(input.split(" ")).collect(Collectors.toMap(word -> word, word -> 1L,(oldValue,newValue) -> oldValue + 1));
    assertEquals(mySolution, yourSolution);
  }
}
