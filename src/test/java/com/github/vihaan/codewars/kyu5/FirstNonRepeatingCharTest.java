package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FirstNonRepeatingCharTest {
    @DisplayName("Sample tests") @Order(1)
    @Test void testSimpleInput() {
        doTest("a", "a");
        doTest("streSS", "t");
        doTest("moon-men", "-");
        doTest("moonmoon", "");
    }

    @DisplayName("Empty String") @Order(2)
    @Test void testEmptyString() {
        doTest("", "");
    }

    @DisplayName("All repeating characters") @Order(3)
    @Test void testAllRepeatingStrings() {
        doTest("abba", "");
        doTest("aa", "");
        doTest("aA", "");
        doTest("AbBa", "");
    }

    @DisplayName("Odd characters") @Order(4)
    @Test void testOddCharacters() {
        doTest("🐐🦊🐐", "🦊");
        doTest("∞§ﬁ›ﬂ∞§", "ﬁ");
        doTest("hello world, eh?", "w");
        doTest("moon-men", "-");
    }

    @DisplayName("Letter case") @Order(5)
    @Test void testLetterCase() {
        doTest("streSS", "t");
        doTest("I Like To Take Candy From A Baby", "L");
    }

    private static void doTest(String input, String expected) {
        final String actual = FirstNonRepeatingChar.firstNonRepeatingLetter(input);
        assertEquals(expected, actual, "for input \"" + input + "\"\n \n");
    }
}