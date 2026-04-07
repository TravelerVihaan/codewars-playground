package com.github.vihaan.codewars.kyu5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Write a function that takes a string input, and returns the first character that is not repeated anywhere in the string.
 *
 * For example, if given the input "stress", the function should return 't', since the letter t only occurs once in the string, and occurs first in the string.
 *
 * As an added challenge, upper- and lowercase characters are considered the same character, but the function should return the correct case for the initial character. For example, the input "sTreSS" should return "T".
 *
 * If a string contains only repeating characters, return an empty string ("");
 *
 * Note: despite its name in some languages, your function should handle any Unicode codepoint:
 *
 * "@#@@*"    --> "#"
 * "かか何"   --> "何"
 * "🐐🦊🐐" --> "🦊"
 */
public class FirstNonRepeatingChar {
    public static String firstNonRepeatingLetter(String s) {
        IntStream codePoints = s.codePoints();
        Map<String, Integer> charOccurrences = new LinkedHashMap<>();

        codePoints.forEach(codePoint -> {
            String lowerLetter = String.valueOf(Character.toChars(Character.toLowerCase(codePoint)));
            if (charOccurrences.containsKey(lowerLetter)) {
                charOccurrences.merge(lowerLetter, 1, Integer::sum);
                return;
            }
            String upperLetter = String.valueOf(Character.toChars(Character.toUpperCase(codePoint)));
            if (charOccurrences.containsKey(upperLetter)) {
                charOccurrences.merge(upperLetter, 1, Integer::sum);
                return;
            }

            String letter = String.valueOf(Character.toChars(codePoint));
            charOccurrences.put(letter, 1);
        });

        return charOccurrences.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .map(String::valueOf)
            .orElse("");
    }
}