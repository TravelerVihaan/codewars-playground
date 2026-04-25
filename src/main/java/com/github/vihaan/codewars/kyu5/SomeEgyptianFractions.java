package com.github.vihaan.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a rational number n
 *
 *  n >= 0, with denominator strictly positive
 *
 *     as a string (example: "2/3" in Ruby, Python, Clojure, JS, CS, Go)
 *     or as two strings (example: "2" "3" in Haskell, Java, CSharp, C++, Swift, Dart)
 *     or as a rational or decimal number (example: 3/4, 0.67 in R)
 *     or two integers (Fortran)
 *
 * decompose this number as a sum of rationals with numerators equal to one and without repetitions (2/3 = 1/2 + 1/6 is correct but not 2/3 = 1/3 + 1/3, 1/3 is repeated).
 *
 * The algorithm must be "greedy", so at each stage the new rational obtained in the decomposition must have a denominator as small as possible. In this manner the sum of a few fractions in the decomposition gives a rather good approximation of the rational to decompose.
 *
 * 2/3 = 1/3 + 1/3 doesn't fit because of the repetition but also because the first 1/3 has a denominator bigger than the one in 1/2 in the decomposition 2/3 = 1/2 + 1/6.
 * Example:
 *
 * (You can see other examples in "Sample Tests:")
 *
 * decompose("21/23") or "21" "23" or 21/23 should return
 *
 * ["1/2", "1/3", "1/13", "1/359", "1/644046"] in Ruby, Python, Clojure, JS, CS, Haskell, Go, Scala
 *
 * "[1/2, 1/3, 1/13, 1/359, 1/644046]" in Java, CSharp, C++, Dart
 *
 * "1/2,1/3,1/13,1/359,1/644046" in C, Swift, R
 *
 * Notes
 *
 *     The decomposition of 21/23 as
 *
 *     21/23 = 1/2 + 1/3 + 1/13 + 1/598 + 1/897
 *
 *     is exact but don't fulfill our requirement because 598 is bigger than 359. Same for
 *
 *     21/23 = 1/2 + 1/3 + 1/23 + 1/46 + 1/69 (23 is bigger than 13)
 *     or
 *     21/23 = 1/2 + 1/3 + 1/15 + 1/110 + 1/253 (15 is bigger than 13).
 *
 *     The rational given to decompose could be greater than one or equal to one, in which case the first "fraction" will be an integer (with an implicit denominator of 1).
 *
 *     If the numerator parses to zero the function "decompose" returns [] (or "",, or "[]").
 *
 *     The number could also be a decimal which can be expressed as a rational.
 *
 * Example:
 *
 * 0.6 in Ruby, Python, Clojure,JS, CS, Julia, Go
 *
 * "66" "100" in Haskell, Java, CSharp, C++, C, Swift, Scala, Kotlin, Dart, ...
 *
 * 0.67 in R.
 *
 * Ref: http://en.wikipedia.org/wiki/Egyptian_fraction
 */
class SomeEgyptianFractions {

    public static String decompose(String nrStr, String drStr) {
        Fraction fraction = Fraction.of(nrStr, drStr);
        List<Integer> resultsDenominators = new ArrayList<>();
        if (fraction.numerator == 0) {
            return "[]";
        } else if (fraction.denominator < fraction.numerator) {
            return "[" + fraction.numerator / fraction.denominator + "]";
        }

        int currentDenominator = 2;
        do {
            if (fraction.numerator == 1) {
                resultsDenominators.add(fraction.denominator);
                break;
            }
            fraction = substractIfPossible(fraction, currentDenominator, resultsDenominators);
            currentDenominator++;
        } while (fraction.numerator != 0);
        return "[" + resultsDenominators.stream()
            .map(d -> "1/" + d)
            .collect(Collectors.joining(", ")) + "]";

    }

    private static Fraction substractIfPossible(Fraction f, int denominatorToSubtract, List<Integer> resultsDenominators) {

        var resultDenominator = f.denominator;
        while (resultDenominator % denominatorToSubtract != 0) {
            resultDenominator *= 2;
        }

        var resultNumerator = f.numerator * (resultDenominator / f.denominator);
        var numeratorToSubtract = resultDenominator / denominatorToSubtract;

        if (numeratorToSubtract > resultNumerator) {
            return f;
        }

        resultNumerator = resultNumerator - numeratorToSubtract;

        resultsDenominators.add(denominatorToSubtract);
        int gcd = gcd(resultNumerator, resultDenominator);
        return gcd != 0 ? Fraction.of(resultNumerator / gcd, resultDenominator / gcd) : Fraction.of(resultNumerator, resultDenominator);


    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static class Fraction {
        private final int numerator;
        private final int denominator;

        private Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        private static Fraction of(String n, String d) {
            return new Fraction(Integer.parseInt(n), Integer.parseInt(d));
        }

        private static Fraction of(int n, int d) {
            return new Fraction(n,d);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
}