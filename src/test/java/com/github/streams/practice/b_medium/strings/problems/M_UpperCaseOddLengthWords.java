package com.github.streams.practice.b_medium.strings.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class M_UpperCaseOddLengthWords {

  /**
   * Given a list of words, create an output list that contains only the odd-length words, converted
   * to upper case.
   */
  @Test
  public void uppercaseOddLengthWords() {
    List<String> input = List.of("alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

    List<String> result = input.stream().filter(s -> s.length() % 2 != 0).map(s -> s.toUpperCase()).toList();

    Assertions.assertEquals(List.of("BRAVO", "CHARLIE", "DELTA", "FOXTROT"), result);
  }
}
