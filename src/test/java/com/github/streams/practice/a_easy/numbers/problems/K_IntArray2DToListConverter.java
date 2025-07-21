package com.github.streams.practice.a_easy.numbers.problems;

import com.github.streams.practice.a_easy.numbers.EasyNumbersProblemSolution;
import com.github.streams.practice.a_easy.numbers.problems.ignore.data.DummyData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class K_IntArray2DToListConverter {
    @Test
    void convertInt2DArrayToList() {
        final int[][] input = DummyData.random2DPrimitiveArray();

        var mySolution = EasyNumbersProblemSolution.convertInt2DArrayToList(input);
        var yourSolution = Stream.of(input).map(arr -> Arrays.stream(arr).boxed().toList()).toList();


        Assertions.assertEquals(mySolution, yourSolution);
    }
}
