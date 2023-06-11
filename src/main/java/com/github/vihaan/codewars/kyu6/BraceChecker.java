package com.github.vihaan.codewars.kyu6;

import java.util.Map;

/*
Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

Examples
"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False
 */
public class BraceChecker {

    public boolean isValid(String braces) {
        if (braces.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < BRACES_PAIRS.size(); i++) {
            for (Map.Entry<Character, Character> bracesPair : BRACES_PAIRS.entrySet()) {
                if (bracesPair.getKey() == null) {
                    continue;
                }
                String notNestedBracesPair = bracesPair.getKey().toString().concat(bracesPair.getValue().toString());
                if (braces.contains(notNestedBracesPair)) {
                    braces = braces.replace(notNestedBracesPair, "");
                }
            }
        }

        char[] bracesChars = braces.toCharArray();
        int bracesLength = bracesChars.length;
        for (int i = 0; i < bracesLength / 2; i++) {
            if (BRACES_PAIRS.getOrDefault(bracesChars[i], '0') != bracesChars[bracesLength - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static final Map<Character, Character> BRACES_PAIRS = Map.of('(', ')', '{', '}', '[', ']');
}
