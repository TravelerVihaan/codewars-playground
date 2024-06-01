package com.github.vihaan.codewars.kyu4;

import java.util.ArrayList;
import java.util.List;

/**
 * There is a secret string which is unknown to you. Given a collection of random triplets from the string,
 * recover the original string.
 * A triplet here is defined as a sequence of three letters such that each letter occurs somewhere
 * before the next in the given string. "whi" is a triplet for the string "whatisup".
 * As a simplification, you may assume that no letter occurs more than once in the secret string.
 * You can assume nothing about the triplets given to you other than that they are valid triplets
 * and that they contain sufficient information to deduce the original string.
 * In particular, this means that the secret string will never contain letters
 * that do not occur in one of the triplets given to you.
 */

public class SecretDetective {

    public String recoverSecret(char[][] triplets) {
        List<Character> result = new ArrayList<>();

        for (char[] triplet : triplets) {
            if (!result.contains(triplet[0])) {
                result.add(0, triplet[0]);
            }

            if (!result.contains(triplet[1])) {
                result.add(result.indexOf(triplet[0]), triplet[1]);
            }

            if (result.contains(triplet[1]) && result.indexOf(triplet[1]) < result.indexOf(triplet[0])) {
                int index = result.indexOf(triplet[1]);
                result.remove(index);
                result.add(result.indexOf(triplet[0]) + 1, triplet[1]);
            }

            if (!result.contains(triplet[2])) {
                result.add(result.indexOf(triplet[1]), triplet[2]);
            }

            if (result.contains(triplet[2]) && result.indexOf(triplet[2]) < result.indexOf(triplet[1])) {
                int index = result.indexOf(triplet[2]);
                result.remove(index);
                result.add(result.indexOf(triplet[1]) + 1, triplet[2]);
            }
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(sb::append);
        return new String(sb);
    }
}