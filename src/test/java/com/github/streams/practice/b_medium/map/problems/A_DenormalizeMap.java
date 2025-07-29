package com.github.streams.practice.b_medium.map.problems;

import com.github.streams.practice.b_medium.ProblemSolutions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Auodumbar
 * <p>
 * <p>
 * Denormalize this map. The input is a map whose keys are the number of legs of an animal
 * and whose values are lists of names of animals. Run through the map and generate a
 * "denormalized" list of strings describing the animal, with the animal's name separated
 * by a colon from the number of legs it has. The ordering in the output list is not
 * considered significant.
 * <p>
 * Input is Map<Integer, List<String>>:
 * { 4=["ibex", "hedgehog", "wombat"],
 * 6=["ant", "beetle", "cricket"],
 * ...
 * }
 * <p>
 * Output should be a List<String>:
 * [ "ibex:4",
 * "hedgehog:4",
 * "wombat:4",
 * "ant:6",
 * "beetle:6",
 * "cricket:6",
 * ...
 * ]
 */
public class A_DenormalizeMap {

    @Test
    @Disabled
    public void A_denormalizeMap() {
        Map<Integer, List<String>> input = new HashMap<>();
        input.put(4, Arrays.asList("ibex", "hedgehog", "wombat"));
        input.put(6, Arrays.asList("ant", "beetle", "cricket"));
        input.put(8, Arrays.asList("octopus", "spider", "squid"));
        input.put(10, Arrays.asList("crab", "lobster", "scorpion"));
        input.put(750, Arrays.asList("millipede"));

        List<String> mySolution = ProblemSolutions.denormalizeMap(input);
        List<String> yourSolution = List.of();

        assertEquals(mySolution, yourSolution);
    }
}
