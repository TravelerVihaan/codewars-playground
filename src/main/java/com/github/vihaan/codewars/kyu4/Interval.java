package com.github.vihaan.codewars.kyu4;

import java.util.*;

/**
 * Write a function called sumIntervals/sum_intervals that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.
 * Intervals
 * <p>
 * Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
 * Overlapping Intervals
 * <p>
 * List containing overlapping intervals:
 * [
 * [1, 4],
 * [7, 10],
 * [3, 5]
 * ]
 * The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
 * Examples:
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
        Set<List<Integer>> outputIntervals = new HashSet<>();
        int loopRounds = intervalsCollection.size();
        int overlapsCounter = 0;
        for (int i = 0; i < loopRounds; i++) {
            int[] currentInterval = intervalsCollection.pop();
            for (ListIterator<int[]> intervalIterator = intervalsCollection.listIterator(); intervalIterator.hasNext(); ) {
                int[] nextInterval = intervalIterator.next();
                if (isOverlapping(currentInterval, nextInterval)) {
                    currentInterval = (mergeOverlappingIntervals(currentInterval, nextInterval));
                    outputIntervals.remove(List.of(nextInterval[0], nextInterval[1]));
                    intervalIterator.remove();
                    intervalIterator.add(currentInterval);
                    overlapsCounter++;
                    if (overlapsCounter == loopRounds) {
                        break;
                    }
                }
            }
            //TODO remove updated interval
            outputIntervals.add(Arrays.stream(currentInterval).boxed().toList());
        }
        return outputIntervals.stream().mapToInt(Interval::calculateInterval).sum();
    }

    private static int calculateInterval(List<Integer> interval) {
        int startInterval = interval.get(0);
        int endInterval = interval.get(1);
        if (Integer.signum(startInterval) == Integer.signum(endInterval)) {
            return endInterval - startInterval;
        } else {
            return Math.abs(endInterval) + Math.abs(startInterval);
        }
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
