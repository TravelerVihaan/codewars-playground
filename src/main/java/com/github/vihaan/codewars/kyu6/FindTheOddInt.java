package com.github.vihaan.codewars.kyu6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find the one that appears an odd number of times.
 * <p>
 * There will always be only one integer that appears an odd number of times.
 * Examples
 * <p>
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 */
public class FindTheOddInt {
    public static int findIt(int[] a) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        Arrays.stream(a).forEach(n -> occurrences.merge(n, 1, Integer::sum));
        return occurrences.entrySet().stream().filter(e -> e.getValue() % 2 != 0).map(Map.Entry::getKey).findFirst().orElse(0);
    }
}
