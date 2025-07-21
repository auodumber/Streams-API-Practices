package com.github.streams.practice.a_easy.strings.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class I_SecondHighestWordTest {
    @Test
    public void find2ndHighestWord() {
        final String input = "I am interested123455 to grow in my organization";
        String mySolution = StringProblemsSolution.find2ndLargestWordInTheString(input);

        final String yourSolution = Stream.of(input.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(1)
                .limit(1)
                .findFirst()
                .orElse("");

        assertEquals(mySolution, yourSolution);
    }
}
