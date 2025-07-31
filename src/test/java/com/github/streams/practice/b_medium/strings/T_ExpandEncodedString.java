package com.github.streams.practice.b_medium.strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Expand an encoded string using character and number format.
 * <p>
 * You are given a string consisting of characters followed by numbers, e.g., "a3b10c1".
 * Each character represents the character to repeat, and the following number represents how many times it should be repeated.
 * <p>
 * For example:
 * - input:  "a3b10c1"
 * - output: "aaabbbbbbbbc"
 * <p>
 * Write a function `expandEncodedString(String input)` to decode this.
 * <p>
 * Constraints:
 * - Only letters (a–z, A–Z) and digits will be present
 * - The number after each character may be more than one digit
 */

public class T_ExpandEncodedString {


    public static class Chunk {
        char character;
        StringBuilder counterBuilder = new StringBuilder();

        public Chunk(char c) {
            this.character = c;
        }
        @Override
        public String toString() {
            return "Chunk{" +
                    "character=" + character +
                    ", counterBuilder=" + counterBuilder +
                    '}';
        }
    }

    private String expandEncodedString(String input) {

        List<Chunk> chunks = new ArrayList<>();
        Chunk currentChunk = null;

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                currentChunk = new Chunk(c);
                chunks.add(currentChunk);
            } else if (currentChunk != null) {
                currentChunk.counterBuilder.append(c);
            }
        }
        final String collect = chunks.stream()
                .<String>mapMulti((chunk, consumer) -> {
                    int times = Integer.parseInt(String.valueOf(chunk.counterBuilder));
                    for (int i = 0; i < times; i++) {
                        consumer.accept(String.valueOf(chunk.character));
                    }
                }).collect(Collectors.joining());
        return collect;
    }


    @Test
    public void testExpandEncodedString() {
        String input = "a3b10c1";
        String expected = "aaabbbbbbbbbbc";
        String actual = expandEncodedString(input);
        assertEquals(expected, actual);
    }


    @Test
    public void testSingleChar() {
        String input = "x1";
        String expected = "x";
        String actual = expandEncodedString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleChunks() {
        String input = "x2y3z1";
        String expected = "xxyyyz";
        String actual = expandEncodedString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testExpandEncodedString2() {


        assertEquals("aaabbbbbbbbbbc", expandEncodedString("a3b10c1"));
        assertEquals("x", expandEncodedString("x1"));
        assertEquals("xxyyyz", expandEncodedString("x2y3z1"));
        assertEquals("aaabba", expandEncodedString("a3b2a1")); // repeated 'a'
    }
}
