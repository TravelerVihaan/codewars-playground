package com.github.vihaan.codewars.kyu6;

import java.util.HashMap;
import java.util.Map;

/**
 * Count the number of Duplicates
 * <p>
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
 * Example
 * <p>
 * "abcde" -> 0 # no characters repeats more than once
 * "aabbcde" -> 2 # 'a' and 'b'
 * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
 * "indivisibility" -> 1 # 'i' occurs six times
 * "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
 * "aA11" -> 2 # 'a' and '1'
 * "ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class CountingDuplicates {
    public static int duplicateCount(String text) {
        String normalizedText = text.toLowerCase();
        char[] chars = normalizedText.toCharArray();
        Map<Character, Integer> occurrences = new HashMap<>();
        for (Character ch : chars) {
            if (occurrences.containsKey(ch)) {
                occurrences.replace(ch, occurrences.get(ch) + 1);
            } else {
                occurrences.put(ch, 1);
            }
        }
        return occurrences.entrySet().stream().filter(entry -> entry.getValue() > 1).toList().size();
    }
}