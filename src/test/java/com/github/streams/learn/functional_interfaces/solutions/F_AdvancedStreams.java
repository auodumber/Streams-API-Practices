package com.github.streams.learn.functional_interfaces.solutions;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;

/**
 * This set of exercises covers advanced stream operations, including grouping collectors,
 * composition of collectors, and customized collectors.
 */
public class F_AdvancedStreams {

  // Pattern for splitting a string into words
  static final Pattern SPLIT_PATTERN = Pattern.compile("[- .:,]+");

  // Hint:
  // <editor-fold defaultstate="collapsed">
  // Use Collectors.groupingBy().
  // </editor-fold>
  private BufferedReader reader;

  // Hint 1:
  // <editor-fold defaultstate="collapsed">
  // Use the overload of Collectors.groupingBy() that has
  // a "downstream" parameter.
  // </editor-fold>
  // Hint 2:
  // <editor-fold defaultstate="collapsed">
  // Use Collectors.counting().
  // </editor-fold>

  /**
   * Categorize the words from the text file into a map, where the map's key is the length of each
   * word, and the value corresponding to a key is a list of words of that length. Don't bother with
   * uniqueness or lower- casing the words. As before, use the BufferedReader variable named
   * "reader" that has been set up for you to read from the text file, and use SPLIT_PATTERN for
   * splitting the line into words.
   *
   * @throws IOException
   */
  @Test
  public void f1_mapLengthToWordList() throws IOException {
    // TODO//Map<Integer, List<String>> result = null;
    // BEGINREMOVE
    Map<Integer, List<String>> result =
        reader
            .lines()
            .flatMap(line -> SPLIT_PATTERN.splitAsStream(line))
            .collect(Collectors.groupingBy(String::length));
    // ENDREMOVE

    assertEquals(10, result.get(7).size());
    assertEquals(Set.of("beauty's", "increase", "ornament"), new HashSet<>(result.get(8)));
    assertEquals(Set.of("abundance", "creatures"), new HashSet<>(result.get(9)));
    assertEquals(Set.of("contracted", "niggarding"), new HashSet<>(result.get(10)));
    assertEquals(List.of("substantial"), result.get(11));
    assertFalse(result.containsKey(12));
  }

  // Hint 1:
  // <editor-fold defaultstate="collapsed">
  // For Collectors.groupingBy(), consider that each word needs to be in
  // a category of its own, that is, each word is categorized as itself.
  // </editor-fold>
  // Hint 2:
  // <editor-fold defaultstate="collapsed">
  // For Collectors.toMap(), the first occurrence of a word should be mapped to 1.
  // If two elements of the Stream are generating the same key, you will need to
  // provide a merging function.
  // </editor-fold>

  /**
   * Categorize the words from the text file into a map, where the map's key is the length of each
   * word, and the value corresponding to a key is a count of words of that length. Don't bother
   * with uniqueness or lower- casing the words. This is the same as the previous exercise except
   * the map values are the count of words instead of a list of words.
   *
   * @throws IOException
   */
  @Test
  public void f2_mapLengthToWordCount() throws IOException {
    // TODO//Map<Integer, Long> result = null;
    // BEGINREMOVE
    Map<Integer, Long> result =
        reader
            .lines()
            .flatMap(line -> SPLIT_PATTERN.splitAsStream(line))
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    // ENDREMOVE

    assertEquals(
        Map.ofEntries(
            entry(1, 1L),
            entry(2, 11L),
            entry(3, 28L),
            entry(4, 21L),
            entry(5, 16L),
            entry(6, 12L),
            entry(7, 10L),
            entry(8, 3L),
            entry(9, 2L),
            entry(10, 2L),
            entry(11, 1L)),
        result);
  }

  // Hint 1:
  // <editor-fold defaultstate="collapsed">
  // The nested map structure that's desired is the result of applying a
  // "downstream" collector that's the same operation as the first-level collector.
  // </editor-fold>
  // Hint 2:
  // <editor-fold defaultstate="collapsed">
  // Both collection operations are Collectors.groupingBy().
  // </editor-fold>

  /**
   * Gather the words from the text file into a map, accumulating a count of the number of
   * occurrences of each word. Don't worry about upper case and lower case. Extra challenge:
   * implement two solutions, one that uses groupingBy() and the other that uses toMap().
   *
   * @throws IOException
   */
  @Test
  public void f3_wordFrequencies() throws IOException {
    // TODO//Map<String, Long> result = null;
    // BEGINREMOVE
    Map<String, Long> result =
        reader
            .lines()
            .flatMap(line -> SPLIT_PATTERN.splitAsStream(line))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    // or use word -> word instead of Function.identity()

    // Alternative solution using toMap():

    // Map<String, Long> map =
    //     reader.lines()
    //           .flatMap(line -> Stream.of(line.split(REGEXP)))
    //           .collect(toMap(Function.identity(),
    //                          w -> 1L,
    //                          Long::sum));
    // ENDREMOVE

    assertEquals(2L, (long) result.get("tender"));
    assertEquals(6L, (long) result.get("the"));
    assertEquals(1L, (long) result.get("churl"));
    assertEquals(2L, (long) result.get("thine"));
    assertEquals(1L, (long) result.get("world"));
    assertEquals(4L, (long) result.get("thy"));
    assertEquals(3L, (long) result.get("self"));
    assertFalse(result.containsKey("lambda"));
  }

  // Hint 1:
  // <editor-fold defaultstate="collapsed">
  // Use Collectors.partitioningBy().
  // </editor-fold>
  // Hint 2:
  // <editor-fold defaultstate="collapsed">
  // The collect(Collector) method we need is defined on Stream<T>, but not on
  // IntStream, LongStream or DoubleStream.
  // </editor-fold>

  /**
   * From the words in the text file, create nested maps, where the outer map is a map from the
   * first letter of the word to an inner map. (Use a string of length one as the key.) The inner
   * map, in turn, is a mapping from the length of the word to a list of words with that length.
   * Don't bother with any lowercasing or uniquifying of the words.
   *
   * <p>For example, given the words "foo bar baz bazz foo" the string representation of the result
   * would be: {b={3=[bar, baz], 4=[bazz]}, f={3=[foo, foo]}}
   *
   * @throws IOException
   */
  @Test
  public void f4_nestedMaps() throws IOException {
    // TODO//Map<String, Map<Integer, List<String>>> result = null;
    // BEGINREMOVE
    Map<String, Map<Integer, List<String>>> result =
        reader
            .lines()
            .flatMap(line -> SPLIT_PATTERN.splitAsStream(line))
            .collect(
                Collectors.groupingBy(
                    word -> word.substring(0, 1), Collectors.groupingBy(String::length)));
    // ENDREMOVE

    assertEquals("[abundance]", result.get("a").get(9).toString());
    assertEquals("[by, be, by]", result.get("b").get(2).toString());
    assertEquals("[flame, fresh]", result.get("f").get(5).toString());
    assertEquals("[gaudy, grave]", result.get("g").get(5).toString());
    assertEquals("[should, spring]", result.get("s").get(6).toString());
    assertEquals("[substantial]", result.get("s").get(11).toString());
    assertEquals(
        "[the, thy, thy, thy, too, the, the, thy, the, the, the]",
        result.get("t").get(3).toString());
    assertEquals("[where, waste, world]", result.get("w").get(5).toString());
  }

  // Hint 1:
  // <editor-fold defaultstate="collapsed">
  // The collector state (that is, the object being accumulated and
  // combined) can be a single StringBuilder, which is manipulated
  // by lambda expressions in the three-arg form of the collect() method.
  // </editor-fold>
  // Hint 2:
  // <editor-fold defaultstate="collapsed">
  // The combiner function must take its second argument and merge
  // it into the first argument, mutating the first argument.
  // </editor-fold>
  // Hint 3:
  // <editor-fold defaultstate="collapsed">
  // The second argument to the combiner function happens AFTER the first
  // argument in encounter order, so the second argument needs to be split
  // in half and prepended/appended to the first argument.
  // </editor-fold>

  /**
   * Given a stream of integers, compute separate sums of the even and odd values in this stream.
   * Since the input is a stream, this necessitates making a single pass over the input.
   */
  @Test
  public void f5_separateOddEvenSums() {
    IntStream input = new Random(987523).ints(20, 0, 100);

    // TODO//int sumEvens = 0;
    // TODO//int sumOdds  = 0;
    // BEGINREMOVE

    Map<Boolean, Integer> sums =
        input
            .boxed()
            .collect(Collectors.partitioningBy(i -> (i & 1) == 1, Collectors.summingInt(i -> i)));
    int sumEvens = sums.get(false);
    int sumOdds = sums.get(true);
    // ENDREMOVE

    assertEquals(516, sumEvens);
    assertEquals(614, sumOdds);
  }

  // Hint:
  // <editor-fold defaultstate="collapsed">
  // The operations you need to write are actually quite simple.
  // Don't overthink it.
  // </editor-fold>

  /**
   * Given a stream of strings, accumulate (collect) them into the result string by inserting the
   * input string at both the beginning and end. For example, given input strings "x" and "y" the
   * result should be "yxxy". Note: the input stream is a parallel stream, so you MUST write a
   * proper combiner function to get the correct result.
   */
  @Test
  public void f6_insertBeginningAndEnd() {
    Stream<String> input =
        List.of(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t")
            .parallelStream();

    // UNCOMMENT//String result = input.collect(null, null, null).toString();
    // UNCOMMENT//// TODO fill in lambda expressions or method references
    // UNCOMMENT//// in place of the nulls in the line above.
    // BEGINREMOVE
    String result =
        input
            .collect(
                StringBuilder::new,
                (sb, s) -> sb.insert(0, s).append(s),
                (sb1, sb2) -> {
                  int half = sb2.length() / 2;
                  sb1.insert(0, sb2.substring(0, half));
                  sb1.append(sb2.substring(half));
                })
            .toString();
    // ENDREMOVE

    assertEquals("tsrqponmlkjihgfedcbaabcdefghijklmnopqrst", result);
  }

  // ========================================================
  // END OF EXERCISES
  // TEST INFRASTRUCTURE IS BELOW
  // ========================================================

  @Test
  public void f7_countTotalAndDistinctWords() {
    List<String> allWords =
        reader
            .lines()
            .map(String::toLowerCase)
            .flatMap(line -> SPLIT_PATTERN.splitAsStream(line))
            .collect(Collectors.toList());

    TotalAndDistinct totalAndDistinct =
        Collections.nCopies(100, allWords).parallelStream()
            .flatMap(List::stream)
            .collect(
                TotalAndDistinct::new, TotalAndDistinct::accumulate, TotalAndDistinct::combine);

    assertEquals(81, totalAndDistinct.getDistinctCount(), "distinct count");
    assertEquals(totalAndDistinct.getTotalCount(), 10700, "total count");
  }

  @BeforeEach
  public void z_setUpBufferedReader() throws IOException {
    reader =
        new BufferedReader(
            new InputStreamReader(this.getClass().getResource("/SonnetI.txt").openStream()));
  }

  @AfterEach
  public void z_closeBufferedReader() throws IOException {
    reader.close();
  }

  /**
   * Count the total number of words and the number of distinct, lower case words in a stream, in
   * one pass. This exercise uses a helper class that defines methods that are called by the
   * Stream.collect() method. Your task is to fill in the implementation of the accumulate() and
   * combine() methods in the helper class. You don't need to modify the test method itself.
   *
   * <p>The stream is run in parallel, so you must write a combine() method that works properly.
   */
  static class TotalAndDistinct {
    private final Set<String> set = new HashSet<>();
    private int count = 0;

    // rely on implicit no-arg constructor

    void accumulate(String s) {
      // UNCOMMENT//// TODO write code to accumulate a single string into this object
      // BEGINREMOVE
      count++;
      set.add(s);
      // ENDREMOVE
    }

    void combine(TotalAndDistinct other) {
      // UNCOMMENT//// TODO write code to combine the other object into this one
      // BEGINREMOVE
      count += other.count;
      set.addAll(other.set);
      // ENDREMOVE
    }

    int getTotalCount() {
      return count;
    }

    int getDistinctCount() {
      return set.size();
    }
  }
}
