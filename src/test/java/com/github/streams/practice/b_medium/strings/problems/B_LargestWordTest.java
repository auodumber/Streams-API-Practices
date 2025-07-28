package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Stream;

class B_LargestWordTest {
  /**
   * Find the largest word in a given string. <br>
   * <br>
   * Example string:
   *
   * <pre>
   * Input: "I am interested123455 to grow in my organization"
   * Output: "interested123455"
   * </pre>
   *
   * @author ZahidKhan
   * @see StringProblemsSolution#findLargestWordInTheString(String)
   */
  @Test
  public void findLargestWordInTheString() {
    final String input = "I am interested123455 to grow in my organization";
    final String mySolution = StringProblemsSolution.findLargestWordInTheString(input);

    String yourSolution = Stream.of(input.split(" ")).max(Comparator.comparingInt(String::length)).get();

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
