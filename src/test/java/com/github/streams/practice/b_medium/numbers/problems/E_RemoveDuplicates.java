package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import com.github.streams.practice.b_medium.numbers.problems.ignore.data.DummyData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Removes duplicates from a list of integers.
 *
 * <p><b>Input:</b> [1, 2, 2, 3, 4, 4, 5] <br>
 * <b>Output:</b> [1, 2, 3, 4, 5] <br>
 *
 * <p><b>Explanation:</b> Removes duplicate integers from a list.
 */
class E_RemoveDuplicates {

  @Test
  void testRemoveDuplicationFromListTest() {
    final var input = DummyData.fakeListOfLongNumbers();
    var yourSolution = input.stream().distinct().toList();
    var mySolution = MediumNumbersProblemSolution.getUniqueNumberFromList(input);

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
