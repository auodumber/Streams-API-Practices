package com.github.streams.practice.c_hard.numbers.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Given an array of int, find the int value that occurs a majority
 * of times in the array (that is, strictly more than half of the
 * elements are that value), and return that int value in an OptionalInt.
 * Note, return the majority int value, not the number of times it occurs.
 * If there is no majority value, return an empty OptionalInt.
 * <p>
 * For example, given an input array [11, 12, 12] the result should be
 * an OptionalInt containing 12. Given an input array [11, 12, 13]
 * the result should be an empty OptionalInt.
 */
public class C_MajorityElement {

    @Test
    public void majorityElement() {
        int[] array1 = {13, 13, 24, 35, 24, 24, 35, 24, 24};
        int[] array2 = {13, 13, 24, 35, 24, 24, 35, 24};

        OptionalInt result1 = majority(array1);
        OptionalInt result2 = majority(array2);

        assertEquals(OptionalInt.of(24), result1);
        assertFalse(result2.isPresent());
    }
    private OptionalInt majority(int[] array1) {
        return Arrays.stream(array1).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(en -> en.getValue() > array1.length/2)
                .mapToInt(en -> en.getKey())
                .findAny();
    }
}
