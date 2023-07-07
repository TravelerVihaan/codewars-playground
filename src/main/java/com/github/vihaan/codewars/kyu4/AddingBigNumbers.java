package com.github.vihaan.codewars.kyu4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
We need to sum big numbers and we require your help.

Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.
Example

add("123", "321"); -> "444"
add("11", "99");   -> "110"

Notes

    The input numbers are big.
    The input is a string of only digits
    The numbers are positives
 */
public class AddingBigNumbers {
  public static String add(String a, String b) {
    List<Integer> aNumbers = extractNumbers(a);
    List<Integer> bNumbers = extractNumbers(b);
    List<Integer> resultNumbers = new ArrayList<>();
    List<Integer> longerNumbers = Stream.of(aNumbers, bNumbers).max(Comparator.comparing(List::size)).orElseGet(Collections::emptyList);

    int reps = Math.min(aNumbers.size(), bNumbers.size());
    int accumulator = 0;
    for (int i=0; i < reps; i++) {
        int sum = aNumbers.get(i) + bNumbers.get(i) + accumulator;
        if (sum >= 10) {
            accumulator = sum / 10;
            resultNumbers.add(sum % 10);
        } else {
            accumulator = 0;
            resultNumbers.add(sum);
        }
    }

    if (aNumbers.size() != bNumbers.size()) {
        for (int i = reps; i < longerNumbers.size(); i++) {
            int sum = longerNumbers.get(i) + accumulator;
            if (sum > 10) {
                accumulator = sum / 10;
                resultNumbers.add(sum % 10);
            } else {
                accumulator = 0;
                resultNumbers.add(sum);
            }
        }
    } else {
        if (accumulator != 0) {
            resultNumbers.add(accumulator);
        }
    }
    StringBuilder outputBuilder = new StringBuilder();
    Collections.reverse(resultNumbers);
    resultNumbers.forEach(outputBuilder::append);

    return outputBuilder.toString();
  }

  private static List<Integer> extractNumbers(String input) {
      char[] charNumbers = input.toCharArray();
      List<Integer> resultNumbers = new ArrayList<>();
      for (int i=charNumbers.length-1; i >= 0; i--) {
          resultNumbers.add(Integer.parseInt(String.valueOf(charNumbers[i])));
      }
      return resultNumbers;
  }
}