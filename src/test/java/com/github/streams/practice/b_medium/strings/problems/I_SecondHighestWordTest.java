package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class I_SecondHighestWordTest {
    @Test
    public void find2ndHighestWord() {
        final String input = "I am interested123455 to grow in my organization";
        String mySolution = StringProblemsSolution.find2ndLargestWordInTheString(input);

      final String collect = Stream.of(input.split(" "))
              .sorted(Comparator.comparingInt((String str) -> str.length()).reversed()).skip(1).limit(1).collect(Collectors.joining(" "));
      assertEquals(mySolution, collect);
    }
}
