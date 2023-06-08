package com.github.vihaan.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Write a function called sumIntervals/sum_intervals that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.
 * Intervals
 * <p>
 * Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
 * Overlapping Intervals
 * <p>
 * List containing overlapping intervals:
 * <p>
 * [
 * [1, 4],
 * [7, 10],
 * [3, 5]
 * ]
 * <p>
 * The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
 * Examples:
 * <p>
 * sumIntervals( [
 * [1, 2],
 * [6, 10],
 * [11, 15]
 * ] ) => 9
 * <p>
 * sumIntervals( [
 * [1, 4],
 * [7, 10],
 * [3, 5]
 * ] ) => 7
 * <p>
 * sumIntervals( [
 * [1, 5],
 * [10, 20],
 * [1, 6],
 * [16, 19],
 * [5, 11]
 * ] ) => 19
 * <p>
 * sumIntervals( [
 * [0, 20],
 * [-100000000, 10],
 * [30, 40]
 * ] ) => 100000030
 * <p>
 * Tests with large intervals
 * <p>
 * Your algorithm should be able to handle large intervals. All tested intervals are subsets of the range [-1000000000, 1000000000].
 */
public class Interval {

    public static int sumIntervals(int[][] intervals) {
        LinkedList<int[]> intervalsCollection = new LinkedList<>(Arrays.asList(intervals));
        List<int[]> outputIntervals = new ArrayList<>();
        while (!intervalsCollection.isEmpty()) {
            int[] currentInterval = intervalsCollection.pop();
            for (int[] interval : intervalsCollection) {
                if (isOverlapping(currentInterval, interval)) {
                    currentInterval = (mergeOverlappingIntervals(currentInterval, interval));
                    intervalsCollection.remove(interval);
                }
            }
            outputIntervals.add(currentInterval);
        }
        outputIntervals.forEach(element -> System.out.println(element[0] + " + " + element[1]));
        return 0;
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        int interval1Min = Math.min(interval1[0], interval1[1]);
        int interval1Max = Math.max(interval1[0], interval1[1]);
        int interval2Min = Math.min(interval2[0], interval2[1]);
        int interval2Max = Math.max(interval2[0], interval2[1]);
        return ((interval1Max >= interval2Min && interval1Max <= interval2Max) || (interval1Min <= interval2Max && interval1Min >= interval2Min));
    }

    private static int[] mergeOverlappingIntervals(int[] interval1, int[] interval2) {
        int[] mergedInterval = {interval1[0], interval1[1], interval2[0], interval2[1]};
        int min = Arrays.stream(mergedInterval).min().getAsInt();
        int max = Arrays.stream(mergedInterval).max().getAsInt();
        return new int[]{min, max};
    }
}
