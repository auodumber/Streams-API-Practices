package com.github.streams.learn.ignore.inprogress;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Auodumbar
 */
public class G_Arrays {

    /*
     *
     * Find the maximum element in the given array.
     * Example: [3, 5, 1, 8, 2] => Output: 8
     *
     */
    @Test
    public void testFindMaxElement() {
        int[] input = {3, 5, 1, 8, 2};
        int actual = Arrays.stream(input).max().getAsInt();
        assertEquals(8, actual);
    }

    /*
     *
     * Reverse the elements of the given array.
     * Example: [1, 2, 3, 4] => [4, 3, 2, 1]
     *
     */
    @Test
    public void testReverseArray() {
        int[] input = {23, 54, 78, 65};
        int[] expected = {65, 78, 54, 23};
        int[] result = IntStream.range(0, input.length)
                .map(i -> input[input.length - 1 - i])
                .toArray();
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expected, result);
    }


    /*
     *
     * Move all 0s to the end of the array while maintaining the order of other elements.
     * Example: [0, 1, 0, 3, 12] => [1, 3, 12, 0, 0]
     *
     */
    @Test
    public void testMoveZerosToEnd() {
        int[] input = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};

        final int[] array = Stream.concat(
                        Arrays.stream(input).boxed().filter(i -> i != 0),
                        Arrays.stream(input).boxed().filter(i -> i == 0))
                .mapToInt(i -> Integer.valueOf(i)).toArray();

        assertArrayEquals(expected, array);
    }

    /*
     *
     * Find the second largest element in the array.
     * Example: [3, 6, 2, 8, 7] => 7
     * If array has less than 2 unique elements, return -1.
     *
     */
    @Test
    public void testSecondLargest() {
        assertEquals(7, secondLargest(new int[]{3, 6, 2, 8, 7}));
        assertEquals(-1, secondLargest(new int[]{5}));
        assertEquals(-1, secondLargest(new int[]{3, 3, 3}));
    }
    private int secondLargest(int[] ints) {
        return Arrays.stream(ints)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst()
                .orElse(-1);
    }


    /*
     *
     * Count the number of even and odd numbers in the array.
     * Example: [1, 2, 3, 4, 5] => evens: 2, odds: 3
     * Return as int[] => [evenCount, oddCount]
     *
     */
    @Test
    public void testCountEvenOdd() {
        assertArrayEquals(new int[]{2, 3}, countEvenOdd(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{0, 0}, countEvenOdd(new int[]{}));
    }
    private int[] countEvenOdd(int[] ints) {

        final long count = Arrays.stream(ints).boxed().filter(i -> i % 2 == 0).count();
        final long count1 = Arrays.stream(ints).boxed().filter(i -> i % 2 != 0).count();

        return new int[]{(int)count, (int)count1};
    }


    /*
     *
     * Given an array containing n-1 integers from 1 to n, find the missing number.
     * Example: [1, 2, 4, 5] => 3
     *
     */
    @Test
    public void testFindMissingNumber() {
        assertEquals(3, findMissingNumber(new int[]{1, 2, 4, 5}));
        assertEquals(1, findMissingNumber(new int[]{2}));
    }
    private int findMissingNumber(int[] ints) {
        int n = ints.length + 1;
        return (n * (n + 1) / 2) - Arrays.stream(ints).sum();
    }


    /*
     *
     * Left rotate the array by k position.
     * Example: [1, 2, 3, 4] k = 0 => [2, 3, 4, 1]
     *
     */
    @Test
    public void testLeftRotateByOne() {
        int[] input = {1, 2, 3, 4};
       ;
        assertArrayEquals(new int[]{2, 3, 4, 1},  leftRotateByOne(input,1));
        assertArrayEquals(new int[]{3, 4, 1, 2},  leftRotateByOne(input,2));
    }
    private int[] leftRotateByOne(int[] input , int k) {
         k = k % input.length;
        return IntStream.concat(
                Arrays.stream(input,k,input.length),
                Arrays.stream(input,0, k)
        ).toArray();
    }

    /*
     *
     * Find all unique pairs of numbers in the array that sum up to a target.
     * Example: [1, 2, 3, 4, 3], target = 6 => [(2, 4), (3, 3)]
     * Return list of int[] pairs, where each pair is size 2.
     *
     */
    @Test
    public void testFindPairsWithSum() {
        List<int[]> pairs = findPairsWithSum(new int[]{1, 2, 3, 4, 3}, 6);
        System.out.println(Arrays.toString(pairs.get(0)));
        System.out.println(Arrays.toString(pairs.get(1)));
        assertEquals(2, pairs.size());
        
    }
    private List<int[]> findPairsWithSum(int[] ints, int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] + ints[j] == target) {
                    list.add(new int[]{ints[i], ints[j]});
                    break;
                }
            }
        }
        return list;
    }
}

