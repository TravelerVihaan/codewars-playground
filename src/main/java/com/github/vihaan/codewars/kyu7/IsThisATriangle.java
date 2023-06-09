package com.github.vihaan.codewars.kyu7;

import java.util.Arrays;

/**
 * Implement a function that accepts 3 integer values a, b, c. The function should return true if a triangle can be built with the sides of given length and false in any other case.
 * <p>
 * (In this case, all triangles must have surface greater than 0 to be accepted).
 */
public class IsThisATriangle {
    public static boolean isTriangle(int a, int b, int c) {
        if (a < 1 || b < 1 || c < 1) {
            return false;
        }
        int[] triangleSides = {a, b, c};
        Arrays.sort(triangleSides);
        return triangleSides[0] + triangleSides[1] > triangleSides[2];
    }
}
