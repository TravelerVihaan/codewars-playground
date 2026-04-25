package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class EgyptianFractionsTest {

    @Test
    public void test1() {
        assertEquals("[1/2, 1/4]",              EgyptianFractions.decompose("3", "4"));
        assertEquals("[3]",                      EgyptianFractions.decompose("12", "4"));
        assertEquals("[]",                       EgyptianFractions.decompose("0", "2"));
        assertEquals("[1/2, 1/3, 1/15]",         EgyptianFractions.decompose("9", "10"));
        assertEquals("[1/2, 1/3, 1/13, 1/359, 1/644046]",
                                                 EgyptianFractions.decompose("21", "23"));
        assertEquals("[1/2, 1/6]",               EgyptianFractions.decompose("2", "3"));
    }
}

