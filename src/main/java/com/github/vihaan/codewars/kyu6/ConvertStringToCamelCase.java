package com.github.vihaan.codewars.kyu6;

/**
 * Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.
 * Examples
 * <p>
 * "the-stealth-warrior" gets converted to "theStealthWarrior"
 * <p>
 * "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
 * <p>
 * "The_Stealth-Warrior" gets converted to "TheStealthWarrior"
 */
public class ConvertStringToCamelCase {
    static String toCamelCase(String s) {
        char[] inputCharacters = s.toCharArray();
        StringBuilder transformedInput = new StringBuilder();
        for (int i = 0; i < inputCharacters.length; i++) {
            if (!Character.isAlphabetic(inputCharacters[i])) {
                transformedInput.append(Character.toUpperCase(inputCharacters[++i]));
            } else {
                transformedInput.append(inputCharacters[i]);
            }
        }
        return transformedInput.toString();
    }
}
