package com.github.streams.practice.a_easy.numbers.problems;

import com.github.streams.practice.a_easy.numbers.EasyNumbersProblemSolution;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Divides a list of integers into two separate lists, one containing all even numbers and the other
 * containing all odd numbers. Input: {1, 2, 3, 4, 5, 6, 7, 8, 9} Output: {2, 4, 6, 8, 1, 3, 5, 7, 9
 * }
 */
class I_SegregateEvenOddNumbers {
  @Test
  void testSegregationOfEvenOddNumbersTest() {
    final var input = IntStream.range(1, 50).boxed();
    final var mySolution = EasyNumbersProblemSolution.segregateEvenOddNumbers(input);


    final var input2 = IntStream.range(1, 50).boxed();
    Map<Boolean, List<Integer>> collect = input2.collect(Collectors.partitioningBy(i -> i % 2 == 0));

    List<Integer> evenList = collect.get(true);
    List<Integer> oddList = collect.get(false);

    final var yourSolution = new ArrayList<>(oddList);

    yourSolution.addAll(evenList);



    Assertions.assertEquals(mySolution, yourSolution);
  }
}
