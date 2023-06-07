package com.github.vihaan.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
 * <p>
 * Examples:
 * <p>
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
 * spinWords( "This is a test") => returns "This is a test"
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 */

public class StopGninnipSMySdroW {
    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> word.length() > 4 ? new StringBuilder(word).reverse().toString() : word)
                .collect(Collectors.joining(" "));
    }
}
