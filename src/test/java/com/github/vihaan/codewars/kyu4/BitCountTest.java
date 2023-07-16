package com.github.vihaan.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCountTest {
    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("7"), BitCount.countOnes(5,7));
        assertEquals(new BigInteger("51"), BitCount.countOnes(12,29));
    }
}