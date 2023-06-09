package com.github.vihaan.codewars.kyu6;

import java.util.Arrays;
import java.util.List;

/**
 * Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
 * Example
 * <p>
 * Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // K> returns "(123) 456-7890"
 * <p>
 * The returned format must be correct in order to complete this challenge.
 * <p>
 * Don't forget the space after the closing parentheses!
 */
public class CreatePhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length != 10) {
            return "";
        }
        for (int number : numbers) {
            if (number > 9 || number < 0) {
                return "";
            }
        }
        List<String> numbersChars = Arrays.stream(numbers).mapToObj(String::valueOf).toList();
        return String.format("(%s) %s-%s", String.join("", numbersChars.subList(0, 3)), String.join("", numbersChars.subList(3, 6)), String.join("", numbersChars.subList(6, numbersChars.size())));
    }
}
