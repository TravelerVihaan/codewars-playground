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
}
