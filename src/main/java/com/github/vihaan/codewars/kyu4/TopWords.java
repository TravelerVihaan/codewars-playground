package com.github.vihaan.codewars.kyu4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopWords {
    
    public static List<String> top3(String s) {
        Pattern pattern = Pattern.compile("'*\\p{L}+(?:'+\\p{L}+)*'*|\\p{N}+");
        Matcher matcher = pattern.matcher(s);
        Map<String, Integer> wordsOccurrences = new HashMap<>();
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // normalizacja
            wordsOccurrences.put(word, wordsOccurrences.getOrDefault(word, 0) + 1);
        }
        return  wordsOccurrences.entrySet().stream()
            .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
            .limit(3).map(Map.Entry::getKey)
            .toList();
    }
}