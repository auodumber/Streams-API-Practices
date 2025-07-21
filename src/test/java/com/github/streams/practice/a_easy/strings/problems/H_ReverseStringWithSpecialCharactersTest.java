package com.github.streams.practice.a_easy.strings.problems;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Unit test for reversing a string that contains special characters.
 *
 * <p>This test class is designed to verify the correctness of a method that reverses a string while
 * preserving the original positions of special characters.
 *
 * @author Zahid Khan.
 */
class H_ReverseStringWithSpecialCharactersTest {
  /**
   * Test case for reversing a string with special characters.
   *
   */
  @Test
  void testReverseStringWithSpecialCharactersTest() {
    var input = "Hello world! This is a test. 😅";
    var mySolution = StringProblemsSolution.reverseStringWithSpecialCharacters(input);

    var yourSolution = Stream.of(input.split("")).reduce("" ,(a,b) -> {
        return new StringBuilder(b).reverse().append(a).toString();
    });

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
