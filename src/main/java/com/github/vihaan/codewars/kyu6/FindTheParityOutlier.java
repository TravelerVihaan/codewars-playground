package com.github.vihaan.codewars.kyu6;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
 * Examples
 * <p>
 * [2, 4, 0, 100, 4, 11, 2602, 36]
 * Should return: 11 (the only odd number)
 * <p>
 * [160, 3, 1719, 19, 11, 13, -21]
 * Should return: 160 (the only even number)
 */
public class FindTheParityOutlier {
    static int find(int[] integers) {
        IntPredicate numberCheck = x -> x % 2 == 0;
        if (Arrays.stream(Arrays.copyOfRange(integers, 0, 3)).filter(number -> number % 2 == 0).count() > 1) {
            numberCheck = x -> x % 2 != 0;
        }
        return Arrays.stream(integers).filter(numberCheck).findFirst().orElse(0);
    }
}
