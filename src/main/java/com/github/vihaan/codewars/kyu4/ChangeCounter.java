package com.github.vihaan.codewars.kyu4;


/// Write a function that counts how many different ways you can make change for an amount of money, given an array of coin denominations.
/// For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2:<br>
/// `1+1+1+1, 1+1+2, 2+2.`
/// The order of coins does not matter:
/// `1+1+2 == 2+1+1`
/// Also, assume that you have an infinite amount of coins.
/// Your function should take an amount to change and an array of unique denominations for the coins:
///   `new ChangeCounter().countChange(4, new int[] {1,2})` // => 3
///   `new ChangeCounter().countChange(10, new int[] {5,2,3})` // => 4
///   `new ChangeCounter().countChange(11, new int[] {5,7})` //  => 0
public class ChangeCounter {
    public static int countChange(final int money, final int[] coins) {
        int[] dp = new int[money + 1];
        dp[0] = 1;

        for (int num : coins) {
            for (int i = num; i <= money; i++) {
                dp[i] += dp[i - num];
            }
        }
        return dp[money];
    }
}