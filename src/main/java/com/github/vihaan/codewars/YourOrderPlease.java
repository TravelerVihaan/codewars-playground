package com.github.vihaan.codewars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
 * Examples
 * <p>
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
 * ""  -->  ""
 */
public class YourOrderPlease {
    public static String order(String words) {
        if (words.isEmpty()) {
            return words;
        }
        return Arrays.stream(words.split(" ")).sorted(Comparator.comparingInt(YourOrderPlease::findDigitInWord)).collect(Collectors.joining(" "));
    }

    static int findDigitInWord(String word) {
        for (Character ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                return Integer.valueOf(ch);
            }
        }
        return 0;
    }
}
