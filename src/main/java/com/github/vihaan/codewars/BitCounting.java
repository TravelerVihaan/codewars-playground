package com.github.vihaan.codewars;

/**
 * Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.
 * <p>
 * Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
 */
public class BitCounting {

    public static int countBits(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }
}