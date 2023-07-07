package com.github.vihaan.codewars.kyu3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleFieldTest {

  private static int[][] battleField = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                                        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    @Test
    public void SampleTest() {
        assertEquals(true, BattleField.fieldValidator(battleField));
    }
}