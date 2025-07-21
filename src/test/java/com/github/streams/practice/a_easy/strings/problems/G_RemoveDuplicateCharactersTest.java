package com.github.streams.practice.a_easy.strings.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

class G_RemoveDuplicateCharactersTest {
  @Test
  public void testRemoveDuplicates() {
    final String input = "dabfcadef";
    final StringBuilder s = new StringBuilder();
    final String yourSolution = input.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
    final String mySolution = StringProblemsSolution.getUniqueCharacters(input);

    assertEquals(mySolution, yourSolution);
  }
}
