package com.github.vihaan.codewars.kyu5;

import java.util.*;

/**
 * When working with color values it can sometimes be useful to extract the individual red, green, and blue (RGB) component values for a color.
 * Implement a function that meets these requirements:
 *
 *     Accepts a case-insensitive hexadecimal color string as its parameter (ex. "#FF9933" or "#ff9933")
 *     Returns a Map<String, int> with the structure {r: 255, g: 153, b: 51} where r, g, and b range from 0 through 255
 *
 * Note: your implementation does not need to support the shorthand form of hexadecimal notation (ie "#FFF")
 * Example
 *
 * "#FF9933" --> {r: 255, g: 153, b: 51}
 */
public class HexToRGB {

    public static HashMap<String, Integer> hexStringToRGB(String hex) {
        if (hex == null || hex.length() != 7) {
            return null;
        }
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        result.put("r", 0);
        result.put("g", 0);
        result.put("b", 0);
        int i = 1;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            result.put(entry.getKey(), HexFormat.fromHexDigits(hex, i, i + 2));
            i += 2;
        }
        return result;
    }
}