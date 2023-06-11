package com.github.vihaan.codewars.kyu5;

import java.util.HexFormat;

/*
The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be rounded to the closest valid value.

Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

The following are examples of expected output values:

RgbToHex.rgb(255, 255, 255) // returns FFFFFF
RgbToHex.rgb(255, 255, 300) // returns FFFFFF
RgbToHex.rgb(0, 0, 0)       // returns 000000
RgbToHex.rgb(148, 0, 211)   // returns 9400D3

 */
public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        StringBuilder rgbHex = new StringBuilder();
        int[] rgb = {r, g, b};
        for (Integer i : rgb) {
            if (i < 0) {
                i = 0;
            } else if (i > 255) {
                i = 255;
            }
            long longI = i;
            rgbHex.append(HexFormat.of().toHexDigits(longI, 2));
        }
        return rgbHex.toString().toUpperCase();
    }
}