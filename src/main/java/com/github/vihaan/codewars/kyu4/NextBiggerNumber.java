package com.github.vihaan.codewars.kyu4;

/*
Create a function that takes a positive integer and returns the next bigger number that can be formed by rearranging its digits. For example:

  12 ==> 21
 513 ==> 531
2017 ==> 2071

If the digits can't be rearranged to form a bigger number, return -1 (or nil in Swift, None in Rust):

  9 ==> -1
111 ==> -1
531 ==> -1
 */
public class NextBiggerNumber {

    public static long nextBiggerNumber(long n) {
        char[] digits = String.valueOf(n).toCharArray();

        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);
        return Long.parseLong(new String(digits));
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
}