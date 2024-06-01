package com.github.vihaan.codewars.kyu5;

/**
 * Given an array arr of strings, complete the function by calculating
 * the total perimeter of all the islands. Each piece of land will be marked with 'X' while
 * the water fields are represented as 'O'. Consider each tile being a perfect 1 x 1 piece of land.
 * Some examples for better visualization:
 *
 * ['XOOXO',
 *  'XOOXO',
 *  'OOOXO',
 *  'XXOXO',
 *  'OXOOO']
 *
 *  should return: "Total land perimeter: 24".
 *
 *  Following input:
 *
 *  ['XOOO',
 *  'XOXO',
 *  'XOXO',
 *  'OOXX',
 *  'OOOO']
 *
 *  should return: "Total land perimeter: 18"
 */

public class LandPerimeter {
	
	public static String landPerimeter(String[] arr) {
        int maxHeight = arr.length;

        for (int i = 0; i < arr.length; i++) {
            char[] column = arr[0].toCharArray();
            for (int j = 0; j < column.length; j++) {

            }
        }
    // Code away
    return "";
  }
}