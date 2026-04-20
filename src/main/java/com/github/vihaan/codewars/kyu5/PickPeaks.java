package com.github.vihaan.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PickPeaks {
    
    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        if (arr.length > 2) {
            for (int i = 1; i < arr.length - 1; i++) {

                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    pos.add(i);
                    peaks.add(arr[i]);

                } else if (arr[i] > arr[i-1] && arr[i] == arr[i + 1]) {
                    int tempI = i;
                    while (tempI < arr.length - 1 && arr[tempI] == arr[tempI+1]){
                        tempI++;
                    }
                    if (tempI < arr.length - 1 && arr[tempI] > arr[tempI+1]) {
                        pos.add(i);
                        peaks.add(arr[i]);
                    }
                    i = tempI;
                }
            }
        }

        return Map.of(
            "pos", pos,
            "peaks", peaks
        );
    }
}