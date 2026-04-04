package com.github.vihaan.codewars.kyu5;

/**
 * Consider the following expansion:
 *
 * "3(ab)"     expands to "ababab"    -- because "ab" repeats 3 times
 * "2(a3(b))"  expands to "abbbabbb"  -- "a3(b)" expands to "abbb" and that repeats twice
 *
 * Given a string, return the expansion of that string.
 *
 * Rules:
 *
 *     The input is guaranteed to be well-formed and balanced.
 *     Multipliers are single digits in the range 1–9, and are optional.
 *     Every multiplier is immediately followed by a parenthesised group.
 *     After a group is fully expanded, nothing appears beyond the final closing parenthesis.
 *
 * Lowercase letters and digits are the only characters that appear.
 */
class SimpleStringExpansion {
    public static String solve(String s) {
        return transform(s);
    }

    private static String transform(String input) {
        int indexStart = input.lastIndexOf("(");
        int indexEnd = input.indexOf(")");
        if (indexStart == -1 && indexEnd == -1) {
            return input;
        }

        int multiplier = 1;
        String replacement = input.substring(indexStart + 1, indexEnd);
        indexEnd += 1;

        if (indexStart > 0 && Character.isDigit(input.charAt(indexStart - 1))) {
            indexStart -= 1;
            multiplier = Character.getNumericValue(input.charAt(indexStart));
        }

        String output = input.substring(0, indexStart) + replacement.repeat(multiplier) + input.substring(indexEnd);

        if (output.contains("(")) {
            output = transform(output);
        }
        return output;
    }
}