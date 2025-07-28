package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class D_NumberOfOccurencesOfEachCharacterTest {
    @Test
    void numberOfOccurencesOfEachCharacter() {
        final String input = "the quick brown fox jumps right over the little lazy dog little";
        final var mySolution = StringProblemsSolution.findOccurenceOfCharacter(input);
        final var yourSolution = input.chars().mapToObj(i -> Character.valueOf((char) i))
                .filter(c -> !Character.isSpaceChar(c))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        assertEquals(mySolution, yourSolution);
    }
}
