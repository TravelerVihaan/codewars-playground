package com.github.vihaan.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervalTest {

    @Test
    public void shouldAddDisjoinedIntervals() {
        assertEquals(9, Interval.sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
        assertEquals(11, Interval.sumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
        assertEquals(7, Interval.sumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
        assertEquals(78, Interval.sumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
    }

    @Test
    public void shouldAddOverlappingIntervals() {
        assertEquals(7, Interval.sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
        assertEquals(6, Interval.sumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
        assertEquals(19, Interval.sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
    }
}