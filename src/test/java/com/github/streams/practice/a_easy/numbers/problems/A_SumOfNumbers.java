package com.github.streams.practice.a_easy.numbers.problems;

import com.github.streams.practice.a_easy.numbers.EasyNumbersProblemSolution;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Tests for calculating the sum of all elements in an integer list.
 *
 * <p>Example:
 *
 * <pre>
 * Input: [5, 6, 7, 8]
 * Output: 26
 * </pre>
 */
class A_SumOfNumbers {

  @Test
  void testSumOfUniqueDigitsTest() {
    final var input = List.of(5, 6, 7, 8, 5, 5, 8, 8, 7);
    var mySolution = EasyNumbersProblemSolution.sumOfNumbers(input);
    var yourSolution = input.stream().mapToInt(Integer::intValue).sum();

    Assertions.assertEquals(mySolution, yourSolution);
  }
}