package com.github.streams.practice.a_easy.strings.problems;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class M_UpperCaseOddLengthWords {

    /**
     * Given a list of words, create an output list that contains only the odd-length words, converted
     * to upper case.
     */
    @Test
    public void uppercaseOddLengthWords() {
        List<String> input = List.of("alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        List<String> result = input.stream()
                .filter(word -> word.length() % 2 != 0)
                .map(String::toUpperCase)
                .toList();

        Assertions.assertEquals(List.of("BRAVO", "CHARLIE", "DELTA", "FOXTROT"), result);
    }
}
