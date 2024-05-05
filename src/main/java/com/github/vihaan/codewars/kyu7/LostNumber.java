package com.github.vihaan.codewars.kyu7;

import java.util.Arrays;
import java.util.List;

public class LostNumber {
    public static int findDeletedNumber(int[] arr, int[] mixedArr) {
        List<Integer> mixedList = Arrays.stream(mixedArr).boxed().toList();
        return Arrays.stream(arr).filter(x -> !mixedList.contains(x)).findFirst().orElse(0);
    }
}