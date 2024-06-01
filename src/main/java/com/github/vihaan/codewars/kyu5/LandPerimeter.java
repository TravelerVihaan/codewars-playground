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

        int[][] matrix = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            matrix[i] = new int[arr[i].length()];
            char[] row = arr[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = row[j] == 'X' ? 1 : 0;
            }
        }

        int perimeter = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1) {
                    perimeter += 4;
                    if (r > 0 && matrix[r - 1][c] == 1) {
                        perimeter -= 2;
                    }
                    if (c > 0 && matrix[r][c - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return "Total land perimeter: " + perimeter;
    }
}