package com.github.vihaan.interview;

public class LongestPalindrome {

    public static String findLongestPalindrome(String s) {
         if (s == null || s.isEmpty()) {
             return "";
         }
        char[] chars = s.toCharArray();
        int iStart = 0;
        int iEnd = 1;

        for(int i = 0; i < chars.length - 1; i++) {
            for (int j = 1; j < chars.length; j++) {
                if (isPalindrome(chars, i, j) && j - i > iEnd - iStart) {
                    iStart = i;
                    iEnd = j;
                }
            }
        }
        return s.substring(iStart, iEnd + 1);
    }

    private static boolean isPalindrome (char[] chars, int i, int j) {
        do {
            if (chars[i] == chars[j]) {
                i += 1;
                j -= 1;
            } else {
                return false;
            }
        } while (j > i);
        return true;
    }

    public static String findLongestPalindromeOn2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int maxStart = 0;
        int maxEnd = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length - 1; i++) {
            int length1 = longestPalindromeRadius(chars, i, i);
            int length2 = longestPalindromeRadius(chars, i, i + 1);

            int tLength = Math.max(length1, length2);
            if (tLength > maxEnd - maxStart + 1) {
                maxStart = i - (tLength - 1) / 2;
                maxEnd = i + tLength / 2;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private static int longestPalindromeRadius (char[] chars, int iStart, int iEnd) {
        int maxIndex = chars.length;
        while (iStart >= 0 && iEnd < maxIndex && chars[iStart] == chars[iEnd]) {
            iStart -= 1;
            iEnd += 1;
        }
        return iEnd - iStart - 1;
    }


}
