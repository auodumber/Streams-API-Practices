package com.github.streams.practice.c_hard.numbers.problems;

import com.github.streams.practice.c_hard.numbers.HardNumbersProblemSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class A_GenerateAPrimeNumberStream {

  @Test
  @Disabled
  void intStreamOfPrimeNumber() {
    final var mySolution = HardNumbersProblemSolution.generateIntStreamOfPrimeNumberStream(5);
    final var yourSolution = IntStream.rangeClosed(1,5);

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
