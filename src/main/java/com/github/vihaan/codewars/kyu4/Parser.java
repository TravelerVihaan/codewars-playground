package com.github.vihaan.codewars.kyu4;

import java.util.HashMap;
import java.util.Map;

/*
In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.

Examples:

    "one" => 1
    "twenty" => 20
    "two hundred forty-six" => 246
    "seven hundred eighty-three thousand nine hundred and nineteen" => 783919

Additional Notes:

    The minimum number is "zero" (inclusively)
    The maximum number, which must be supported is 1 million (inclusively)
    The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
    All tested numbers are valid, you don't need to validate them


 */
public class Parser {

    public static int parseInt(String numStr) {
        if (numStr.contains("million")) {
            return 1000000;
        }
        numStr = numStr.replaceAll(" and ", " ");
        int resultInt = 0;
        if (numStr.contains(THOUSAND)) {
            String thousandPart = numStr.split(THOUSAND)[0];
            if (thousandPart.contains(HUNDRED)) {
                String[] thousandHundredPart = thousandPart.split(HUNDRED);
                resultInt += parseNumber(thousandHundredPart[0]) * 100;
                if (thousandHundredPart.length > 1) {
                    resultInt += parseNumber(thousandHundredPart[1]);
                }
            } else {
                resultInt += parseNumber(thousandPart);
            }
            resultInt *= 1000;
            numStr = numStr.replaceFirst(thousandPart, EMPTY_STRING).replaceFirst(THOUSAND, EMPTY_STRING);
        }
        if (numStr.contains(HUNDRED)) {
            String hundredPart = numStr.split(HUNDRED)[0];
            resultInt += (parseNumber(hundredPart) * 100);
            numStr = numStr.replaceFirst(hundredPart, EMPTY_STRING).replaceFirst(HUNDRED, EMPTY_STRING).trim();
        }
        if (!numStr.isEmpty() || !numStr.isBlank()) {
            resultInt += parseNumber(numStr);
        }
        return resultInt;
    }

    private static int parseNumber(String wordsToParse) {
        if (wordsToParse.contains(DASH_SIGN)) {
            String[] thousandHundredPartWithDash = wordsToParse.split(DASH_SIGN);
            return ALL_NUMBER_MAPPINGS.getOrDefault(thousandHundredPartWithDash[0].trim(), 0) + ALL_NUMBER_MAPPINGS.getOrDefault(thousandHundredPartWithDash[1].trim(), 0);
        } else {
            return ALL_NUMBER_MAPPINGS.getOrDefault(wordsToParse.trim(), 0);
        }
    }

    private static final String EMPTY_STRING = "";
    private static final String DASH_SIGN = "-";
    private static final String HUNDRED = "hundred";
    private static final String THOUSAND = "thousand";
    private static final Map<String, Integer> NUMBER_MAPPINGS = new HashMap<>() {{
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
        put("ten", 10);
        put("eleven", 11);
        put("twelve", 12);
        put("thirteen", 13);
        put("fourteen", 14);
        put("fifteen", 15);
        put("sixteen", 16);
        put("seventeen", 17);
        put("eighteen", 18);
        put("nineteen", 19);
        put("zero", 0);

    }};

    private static final Map<String, Integer> NUMBER_MAPPINGS_TENS = new HashMap<>() {{
        put("ten", 10);
        put("twenty", 20);
        put("thirty", 30);
        put("forty", 40);
        put("fifty", 50);
        put("sixty", 60);
        put("seventy", 70);
        put("eighty", 80);
        put("ninety", 90);
    }};

    private static final Map<String, Integer> ALL_NUMBER_MAPPINGS = new HashMap<>(NUMBER_MAPPINGS_TENS) {{
        putAll(NUMBER_MAPPINGS);
    }};

}