package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

///
/// Calculates the sum of all elements in an integer array.
///
/// Example:
/// Input: [5, 6, 7, 8]
///
/// Output: 26
///
class A_SumOfNumbers {

  @Test
  void testSumOfUniqueDigitsTest() {
    final var input = List.of(5, 6, 7, 8, 5, 5, 8, 8, 7);
    var mySolution = MediumNumbersProblemSolution.sumOfNumbers(input);
    var yourSolution = input.stream().mapToInt(Integer::intValue).sum();

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
