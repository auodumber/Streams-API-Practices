package com.github.streams.practice.a_easy.numbers.problems;

import com.github.streams.practice.a_easy.numbers.EasyNumbersProblemSolution;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.FileSystemSource;

/**
 * Re-arranges the elements of a numeric array to form the smallest possible value.
 *
 * <p>Example: Input: [1, 34, 3, 98, 9, 76, 45, 4] <br>
 * Output: 133444576998
 *
 * <p>Explanation: The numbers are re-arranged in ascending order, with single-digit numbers placed
 * before multi-digit numbers like [1,3,34,4,45,76,9,98].
 */
class F_AscendingNumberValue {

  @Test
  public void test() {
    var input = List.of(1, 34, 3, 98, 9, 76, 45, 4);
    var mySolution = EasyNumbersProblemSolution.getSmallestPossibleValue(input);
    var yourSolution = input.stream().map(String::valueOf).sorted().collect(Collectors.joining());
    Assertions.assertEquals(mySolution, yourSolution);
  }
}
