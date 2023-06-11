package com.github.vihaan.codewars.kyu5;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RgbToHexTest {

    @Test
    public void sampleTests() {
        assertEquals("000000", RgbToHex.rgb(0, 0, 0), "For input: (0, 0, 0)");
        assertEquals("010203", RgbToHex.rgb(1, 2, 3), "For input: (1, 2, 3)");
        assertEquals("FFFFFF", RgbToHex.rgb(255, 255, 255), "For input: (255, 255, 255)");
        assertEquals("FEFDFC", RgbToHex.rgb(254, 253, 252), "For input: (254, 253, 252)");
        assertEquals("00FF7D", RgbToHex.rgb(-20, 275, 125), "For input: (-20, 275, 125)");
    }
}