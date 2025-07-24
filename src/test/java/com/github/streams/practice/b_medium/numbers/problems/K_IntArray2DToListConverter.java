package com.github.streams.practice.b_medium.numbers.problems;

import com.github.streams.practice.b_medium.numbers.MediumNumbersProblemSolution;
import com.github.streams.practice.b_medium.numbers.problems.ignore.data.DummyData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class K_IntArray2DToListConverter {
    @Test
    void convertInt2DArrayToList() {
        final int[][] input = DummyData.random2DPrimitiveArray();

        var mySolution = MediumNumbersProblemSolution.convertInt2DArrayToList(input);
        var yourSolution = Arrays.stream(input)
                .map(row -> Arrays.stream(row).boxed().toList())
                .toList();
        Assertions.assertEquals(mySolution, yourSolution);
    }
}
