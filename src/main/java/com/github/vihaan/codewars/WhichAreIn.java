package com.github.vihaan.codewars;

import java.util.Arrays;

/**
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
 * Example 1:
 * <p>
 * a1 = ["arp", "live", "strong"]
 * <p>
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * <p>
 * returns ["arp", "live", "strong"]
 * Example 2:
 * <p>
 * a1 = ["tarp", "mice", "bull"]
 * <p>
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * <p>
 * returns []
 * Notes:
 * <p>
 * Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
 * In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
 * Beware: In some languages r must be without duplicates.
 */
public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(str ->
                        Arrays.stream(array2).anyMatch(s -> s.contains(str)))
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }
}