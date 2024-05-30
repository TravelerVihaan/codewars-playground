package com.github.vihaan.hackerrank.towerbreakers;

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        if (m == 1 || n % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

}