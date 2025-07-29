package com.github.streams.practice.b_medium.strings.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Auodumbar
 */
public class R_SelectLongestWordInOnePass {

    @Test
    public void h3_selectLongestWordsOnePass() {
        Stream<String> input = Stream.of(
                "alfa", "bravo", "charlie", "delta",
                "echo", "foxtrot", "golf", "hotel").parallel();

        List<String> result = input.collect(
                () -> new ArrayList<String>(),
                (list, str) -> list.add(str),
                (list1, list2) -> {
                    list1.addAll(list2);
                     List<String> list = list1.stream().sorted(Comparator.comparingInt(String::length).reversed()).limit(2).toList();
                     list1.clear();
                     list1.addAll(list);
                }
        );

        System.out.println(result);

        assertEquals(Arrays.asList("charlie", "foxtrot"), result);
    }
}
