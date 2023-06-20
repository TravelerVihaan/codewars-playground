package com.github.vihaan.codewars.kyu4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

/*
Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.

Example:

Given an input string of:

apples, pears # and bananas
grapes
bananas !apples

The output expected would be:

apples, pears
grapes
bananas

The code would be called like so:

var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"


 */
public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        String[] textLines = text.split(Pattern.quote("\n"));
        StringBuilder outputTextBuilder = new StringBuilder();
        for (String textLine : textLines) {
            Arrays.stream(commentSymbols)
                    .filter(textLine::contains)
                    .map(symbol -> textLine.substring(0, textLine.indexOf(symbol)).trim())
                    .min(Comparator.comparing(String::length))
                    .ifPresentOrElse(line -> outputTextBuilder.append(line.stripTrailing()).append("\n"), () -> outputTextBuilder.append(textLine.stripTrailing()).append("\n"));
        }
        var outputText = outputTextBuilder.toString();
        return outputText.endsWith("\n") ? outputText.substring(0, outputText.length() - 1) : outputText;
    }

}