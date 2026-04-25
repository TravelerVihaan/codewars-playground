package com.github.vihaan.codewars.kyu5;

import java.math.BigInteger;
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
class EgyptianFractions {

    public static String decompose(String nrStr, String drStr) {
        BigInteger num = new BigInteger(nrStr);
        BigInteger den = new BigInteger(drStr);

        if (num.compareTo(BigInteger.ZERO) == 0) {
            return "[]";
        }

        List<String> parts = new ArrayList<>();

        // Handle whole-number part (num >= den)
        if (num.compareTo(den) >= 0) {
            BigInteger whole = num.divide(den);
            parts.add(whole.toString());
            num = num.mod(den);
            if (num.compareTo(BigInteger.ZERO) == 0) {
                return "[" + String.join(", ", parts) + "]";
            }
        }

        // Greedy loop
        while (num.compareTo(BigInteger.ZERO) > 0) {
            // k = ceil(den / num)
            BigInteger k = den.add(num).subtract(BigInteger.ONE).divide(num);

            parts.add("1/" + k);

            // new fraction = (num*k - den) / (den*k)
            BigInteger newNum = num.multiply(k).subtract(den);
            BigInteger newDen = den.multiply(k);

            BigInteger g = newNum.gcd(newDen);
            num = newNum.divide(g);
            den = newDen.divide(g);
        }

        return "[" + String.join(", ", parts) + "]";
    }
}

