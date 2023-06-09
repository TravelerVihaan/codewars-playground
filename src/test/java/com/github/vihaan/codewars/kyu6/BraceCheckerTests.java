package com.github.vihaan.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BraceCheckerTests {

    private BraceChecker checker = new BraceChecker();

    @Test
    public void testValid() {
        assertTrue(checker.isValid("()"));
        assertTrue(checker.isValid("{}"));
        assertTrue(checker.isValid("({})[({})]"));
        assertTrue(checker.isValid("(({{[[]]}}))"));
    }

    @Test
    public void testInvalid() {
        assertFalse(checker.isValid("[(])"));
    }

}