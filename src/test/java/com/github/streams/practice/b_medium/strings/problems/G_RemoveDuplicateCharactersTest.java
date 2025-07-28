package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class G_RemoveDuplicateCharactersTest {
  @Test
  public void testRemoveDuplicates() {
    final String input = "dabfcadef";
    final var yourSolution = input.chars().mapToObj(i -> String.valueOf((char) i)).distinct().collect(Collectors.joining());
    final String mySolution = StringProblemsSolution.getUniqueCharacters(input);

    assertEquals(mySolution, yourSolution);
  }
}
