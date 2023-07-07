package com.github.vihaan.codewars.kyu4;

import java.util.ArrayList;
import java.util.List;

/*
Write a function which makes a list of strings representing all of the ways you can balance n pairs of parentheses
Examples

balancedParens(0) returns ArrayList<String> with element:  ""
balancedParens(1) returns ArrayList<String> with element:  "()"
balancedParens(2) returns ArrayList<String> with elements: "()()","(())"
balancedParens(3) returns ArrayList<String> with elements: "()()()","(())()","()(())","(()())"
 */
public class BalancedParens {

    public static List<String> balancedParens (int n) {
        List<String> resultCombinations = new ArrayList<>();
        if (n == 0) {
            return List.of("");
        } else if (n > 0) {
            resultCombinations.add(BOTH_PARENTHESES.repeat(n));
        }

        if (n > 1) {
            resultCombinations.add(LEFT_PARENTHESES.repeat(n) + RIGHT_PARENTHESES.repeat(n));
        }
        if (n >= 3) {
        }

        return resultCombinations;
    }

    private static List<String> generateParenthesesCombinations(List<String> resultCombinations, int n) {
        return resultCombinations;
    }

    private static final String BOTH_PARENTHESES = "()";
    private static final String LEFT_PARENTHESES = "(";
    private static final String RIGHT_PARENTHESES = ")";
}