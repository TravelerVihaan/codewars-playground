package com.github.vihaan.codewars.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void fixedTests() {
        assertEquals(1, Parser.parseInt("one"));
        assertEquals(20, Parser.parseInt("twenty"));
        assertEquals(246, Parser.parseInt("two hundred forty-six"));
    }
}