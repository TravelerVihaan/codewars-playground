package com.github.vihaan.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestPalindromeTest {

    @ParameterizedTest
    @CsvSource({"abba,abba", "babba,abba", "baba,bab"})
    void testFindLongestPalindrome(String input, String longestPalindrome) {
        Assertions.assertEquals(longestPalindrome, LongestPalindrome.findLongestPalindrome(input));
    }


    @ParameterizedTest
    @CsvSource({"abba,abba", "babba,abba", "baba,bab"})
    void testFindLongestPalindromeOn2(String input, String longestPalindrome) {
        Assertions.assertEquals(longestPalindrome, LongestPalindrome.findLongestPalindromeOn2(input));
    }

}