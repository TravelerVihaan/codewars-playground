package com.github.vihaan.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;

/**
 * Egyptian Fractions – greedy decomposition.
 *
 * Greedy step: for remaining n/d the smallest unit fraction <= n/d is 1/k
 * where k = ceil(d/n) = (d + n - 1) / n.
 *
 * After subtracting: n/d - 1/k = (n*k - d) / (d*k)  →  simplify by GCD.
 */
class SomeEgyptianFractions {

    public static String decompose(String nrStr, String drStr) {
        long fNumerator = Long.parseLong(nrStr);
        long fDenominator = Long.parseLong(drStr);

        List<String> parts = new ArrayList<>();

        if (fNumerator == 0) {
            return parts.toString();
        }

        if (fNumerator > fDenominator) {
            long whole = fNumerator / fDenominator;
            fNumerator = fNumerator % fDenominator;
            parts.add(String.valueOf(whole));
            if (fNumerator == 0) {
               return parts.toString();
            }
        }

        // Greedy loop
        long egyptianFractionDen = 2;
        while (fNumerator != 0) {
            if ((double) fNumerator / fDenominator >= (double) 1 / egyptianFractionDen) {
                long lcm = lcm(fDenominator, egyptianFractionDen);
                fNumerator = fNumerator * (lcm / fDenominator) - (lcm / egyptianFractionDen);
                long gcd = gcd(fNumerator, lcm);
                fNumerator /= gcd;
                fDenominator = lcm / gcd;
                parts.add(String.format("1/%d", egyptianFractionDen));
            }
            egyptianFractionDen += 1;
        }
        return parts.toString();
    }

    private static long lcm(long denominator1, long denominator2) {
        return Math.abs(denominator1 / gcd(denominator1, denominator2) * denominator2);
    }

    private static long gcd(long num1, long num2) {
        while (num2 != 0) {
            long divider = num1 % num2;
            num1 = num2;
            num2 = divider;
        }
        return num1;
    }
}