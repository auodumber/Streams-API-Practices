package com.github.streams.learn.ignore.inprogress;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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

        return new int[]{(int) count, (int) count1};
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
        assertArrayEquals(new int[]{2, 3, 4, 1}, leftRotateByOne(input, 1));
        assertArrayEquals(new int[]{3, 4, 1, 2}, leftRotateByOne(input, 2));
    }
    private int[] leftRotateByOne(int[] input, int k) {
        k = k % input.length;
        return IntStream.concat(
                Arrays.stream(input, k, input.length),
                Arrays.stream(input, 0, k)
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

    @Test
    public void testFindSumAndAverage() {
        assertArrayEquals(new int[]{12, 3}, findSumAndAverage(new int[]{1, 2, 4, 5}));
    }
    private int[] findSumAndAverage(int[] ints) {
        final IntSummaryStatistics intSummaryStatistics = Arrays.stream(ints).summaryStatistics();
        return new int[]{(int) intSummaryStatistics.getSum(), (int) intSummaryStatistics.getAverage()};
    }

    /*
     * Calculate the product of all non-zero elements.
     * Example: [2, 0, 3, 4, 0, 5] => 120 (2*3*4*5)
     * Return 1 if no non-zero elements
     */
    @Test
    public void testProductOfNonZero() {
        assertEquals(120, productOfNonZero(new int[]{2, 0, 3, 4, 0, 5}));
        assertEquals(1, productOfNonZero(new int[]{0, 0, 0}));
        assertEquals(24, productOfNonZero(new int[]{1, 2, 3, 4}));
        assertEquals(1, productOfNonZero(new int[]{}));
    }
    public static int productOfNonZero(int[] arr) {
        return Arrays.stream(arr).boxed().reduce(1, (a, b) -> b != 0 ? a * b : a);
    }
    /*
     * Get the top N largest elements from the array.
     * Example: [5, 2, 8, 1, 9, 3], n=3 => [9, 8, 5]
     * Return in descending order
     */
    @Test
    public void testGetTopN() {
        assertArrayEquals(new int[]{9, 8, 5}, getTopN(new int[]{5, 2, 8, 1, 9, 3}, 3));
        assertArrayEquals(new int[]{3, 2, 1}, getTopN(new int[]{1, 2, 3}, 5));
        assertArrayEquals(new int[]{}, getTopN(new int[]{1, 2, 3}, 0));
        assertArrayEquals(new int[]{}, getTopN(new int[]{}, 3));
    }
    public static int[] getTopN(int[] arr, int n) {

        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /*
     * Check if the array contains any duplicate elements.
     * Example: [1, 2, 3, 4, 5] => false, [1, 2, 3, 2] => true
     */
    @Test
    public void testHasDuplicates() {
        assertFalse(hasDuplicates(new int[]{1, 2, 3, 4, 5}));
        assertTrue(hasDuplicates(new int[]{1, 2, 3, 2}));
        assertTrue(hasDuplicates(new int[]{5, 5}));
        assertFalse(hasDuplicates(new int[]{42}));
        assertFalse(hasDuplicates(new int[]{}));
    }


    public static boolean hasDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray().length != arr.length;
    }
    /*
     * Flatten a 2D array into a 1D array.
     * Example: [[1, 2], [3, 4, 5], [6]] => [1, 2, 3, 4, 5, 6]
     */

    @Test
    public void testFlatten2D() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6},
                flatten2D(new int[][]{{1, 2}, {3, 4, 5}, {6}}));
        assertArrayEquals(new int[]{}, flatten2D(new int[][]{}));
        assertArrayEquals(new int[]{1, 2, 3}, flatten2D(new int[][]{{1, 2, 3}}));
        assertArrayEquals(new int[]{}, flatten2D(new int[][]{{}, {}, {}}));
    }
    public static int[] flatten2D(int[][] arr) {
        //return Arrays.stream(arr).flatMapToInt(a -> Arrays.stream(a)).toArray();
        return Arrays.stream(arr)
                .<Integer>mapMulti((a, consumer) -> {
                    for (int i : a) {
                        consumer.accept(i);
                    }
                }).mapToInt(i -> Integer.valueOf(i)).toArray();
    }

    /*
     * Find elements that appear exactly once in the array.
     * Example: [1, 2, 3, 2, 4, 3, 5] => [1, 4, 5]
     * Return in the order they first appear
     */
    @Test
    public void testFindUnique() {
        assertEquals(Arrays.asList(1, 4, 5), findUnique(new int[]{1, 2, 3, 2, 4, 3, 5}));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), findUnique(new int[]{1, 2, 3, 4, 5}));
        assertEquals(Arrays.asList(), findUnique(new int[]{1, 1, 2, 2, 3, 3}));
        assertEquals(Arrays.asList(), findUnique(new int[]{}));
    }
    public static List<Integer> findUnique(int[] arr) {
         return Arrays.stream(arr).boxed()
                 .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                 .entrySet()
                 .stream()
                 .filter(i -> i.getValue() == 1)
                 .map(x -> x.getKey())
                 .toList();
    }
    /**
     * Flip the  bits of given number if it is 0 then 1 vice versa
     * 13 = 1101 => flip => 0010 => decimal convert = 2
     */
    @Test
    public void customBitNegate() {
        int num = 13;
        int bits = Integer.toBinaryString(num).length();
        int mask = (1 << bits) - 1;
        int res = (~num) & mask;

        assertEquals(2, res);
    }

}

