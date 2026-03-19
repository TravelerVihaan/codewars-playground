package com.github.vihaan.codewars.kyu6;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * In this Kata, you will be given a series of times at which an alarm sounds. Your task will be to determine the maximum time interval between alarms. Each alarm starts ringing at the beginning of the corresponding minute and rings for exactly one minute. The times in the array are not in chronological order. Ignore duplicate times, if any.
 * Examples:
 *
 *     ["14:51"] --> "23:59"
 *
 *     If the alarm sounds now, it will not sound for another 23 hours and 59 minutes.
 *
 *     ["23:00","04:22","18:05","06:24"] --> "11:40"
 *
 *     The alarm sounds 4 times in a day. The max interval that the alarm will not sound is 11 hours and 40 minutes.
 */
class SimpleTimeDiff {
    public static String solve(String [] arr) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LinkedList<LocalTime> times = Arrays.stream(arr)
                .map(LocalTime::parse)
                .sorted(LocalTime::compareTo)
                .collect(Collectors.toCollection(LinkedList::new));
        Arrays.stream(arr).forEach(System.out::println);

        if (times.isEmpty()) {
            return null;
        }

        LinkedList<LocalTime> resultDiffs = new LinkedList<>();

        if (times.size() == 1) {
            resultDiffs.add(LocalTime.MIDNIGHT.minusMinutes(1));
        } else {

            Iterator<LocalTime> timeIterator = times.iterator();
            LocalTime current = timeIterator.next();

            while (timeIterator.hasNext()) {
                LocalTime next = timeIterator.next();
                if (current.equals(next)) {
                    resultDiffs.add(LocalTime.ofSecondOfDay(0));
                    continue;
                }
                LocalTime curr2 = current.plusMinutes(1);
                resultDiffs.add(LocalTime.ofSecondOfDay(Duration.between(curr2, next)
                        .abs()
                        .toSeconds()));
                if (!timeIterator.hasNext()) {
                    long duration1 = Duration.between(next, LocalTime.MAX).abs().toSeconds();
                    long duration2 = Duration.between(LocalTime.MIDNIGHT, times.getFirst()).abs().toSeconds();
                    LocalTime time = LocalTime.ofSecondOfDay(duration1 + duration2);
                    resultDiffs.add(time);
                }
            current = next;
            }
        }
        return resultDiffs.stream().max(LocalTime::compareTo).orElse(resultDiffs.getFirst()).format(formatter);
    }
}