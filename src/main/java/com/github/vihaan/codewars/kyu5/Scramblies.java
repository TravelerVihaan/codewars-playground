package com.github.vihaan.codewars.kyu5;

import java.util.Map;
import java.util.stream.Collectors;

/*
Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

Notes:

    Only lower case letters will be used (a-z). No punctuation or digits will be included.
    Performance needs to be considered.

Examples

scramble('rkqodlw', 'world') ==> True
scramble('cedewaraaossoqqyt', 'codewars') ==> True
scramble('katas', 'steak') ==> False


 */
public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        Map<Integer, Long> charsCount2 = str2.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Integer, Long> charsCount1 = str1.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for (Map.Entry<Integer, Long> charCount2 : charsCount2.entrySet()) {
            if (charsCount1.getOrDefault(charCount2.getKey(), 0L) < charCount2.getValue()) {
                return false;
            }
        }
        return true;
    }
}