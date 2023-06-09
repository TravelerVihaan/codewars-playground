package com.github.vihaan.codewars.kyu5;

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
        char[] str2chars = str2.toCharArray();
        for (int i = 0; i < str2.length(); i++) {
            String charFromStr2 = Character.toString(str2chars[i]);
            if (!str1.contains(charFromStr2)) {
                return false;
            }
            str1 = str1.replaceFirst(charFromStr2, "0");
        }
        return true;
    }
}