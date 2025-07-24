package com.github.streams.practice.c_hard.numbers.problems;

import com.github.streams.practice.c_hard.numbers.HardNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/// ### Longest Consecutive Sequence
///
/// Given an unsorted array of integers `nums`, return the length of the longest consecutive
// elements
/// sequence.
///
/// You must write an algorithm that runs in $O(n)$ time.
///
/// ### Example 1:
///
/// ```
/// Input: nums = [100, 4, 200, 1, 3, 2]
/// ```
/// ```
/// Output: 4
/// ```
/// Explanation: The longest consecutive elements sequence is `[1, 2, 3, 4]`. There-fore its length
// is 4.
///
/// ### Example 2:
///
/// ```
/// Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1] [0,1,2,3,4,5,6,7,8]
/// ```
/// ```
/// Output: 9
/// ```
class B_LengthOfLargestConsecutiveSequence {
  @Test
  void largestConsecutiveSequence() {
    final var input =  List.of(0, 3, 7, 2, 5, 8, 4, 6, 0, 1);//List.of(1, 12, 33, 4, 2, 3, 99, 100, 101, 102, 104, 98);
    Set<Integer> set = new HashSet<>(input);
    final var mySolution = HardNumbersProblemSolution.largestConsecutiveSequence(input);
    final var yourSolution = set.stream().filter(n -> !set.contains(n-1))
                    .map(n -> {
                      int count = 0;
                      while(set.contains(n)){
                        count++;
                        n++;
                      }
                      return count;
                    }).max(Comparator.comparingInt(Integer::intValue)).get();

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
