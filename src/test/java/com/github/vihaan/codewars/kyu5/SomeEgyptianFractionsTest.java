package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SomeEgyptianFractionsTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        testing(SomeEgyptianFractions.decompose("3", "4"), "[1/2, 1/4]");
        testing(SomeEgyptianFractions.decompose("12", "4"), "[3]");
        testing(SomeEgyptianFractions.decompose("0", "2"), "[]");
        testing(SomeEgyptianFractions.decompose("9", "10"), "[1/2, 1/3, 1/15]");
    }
}