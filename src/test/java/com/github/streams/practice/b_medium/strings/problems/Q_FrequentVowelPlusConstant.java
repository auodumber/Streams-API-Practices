package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/// You are given a string s consisting of lowercase English letters ('a' to 'z').
///
/// Your task is to:
///
/// Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
/// Find the consonant (all other letters excluding vowels) with the maximum frequency.
/// Return the sum of the two frequencies.
///
/// Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.
///
///
///
/// The frequency of a letter x is the number of times it occurs in the string.
///
///
/// Example 1:
///
/// Input: s = "successes"
///
/// Output: 6
///
/// Explanation:
///
/// The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
/// The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
/// The output is 2 + 4 = 6.
/// Example 2:
///
/// Input: s = "aeiaeia"
///
/// Output: 3
///
/// Explanation:
///
/// The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
/// There are no consonants in s. Hence, maximum consonant frequency = 0.
/// The output is 3 + 0 = 3.
///
///
/// Constraints:
///
/// 1 <= s.length <= 100
/// s consists of lowercase English letters only.
///
///
///
class Q_FrequentVowelPlusConstant {

    @Test
    void freqVowelsPlusConstant() {
        final var input = "successes";
        final var mySolution = StringProblemsSolution.frequentVowelPlusConstant(input);

        Set<String> set = Set.of("a", "e", "i", "o", "u");

        final var partition = input.chars().mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.partitioningBy(c -> set.contains(c),
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(x -> x, Collectors.counting()),
                                freqMap -> freqMap
                                        .entrySet()
                                        .stream()
                                        .max(Map.Entry.comparingByValue(Comparator.comparing(x -> x.longValue())))
                                        .map(en -> en.getValue())
                                        .get())));

        final var yourSolution = (int) (partition.get(true) + partition.get(false));
        Assertions.assertEquals(mySolution, yourSolution);
    }
}
