package com.github.vihaan.codewars;

/**
 * Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question is still correct. However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.
 * <p>
 * Your task is to write a function maskify, which changes all but the last four characters into '#'.
 * Examples
 * <p>
 * Maskify.Maskify("4556364607935616"); // should return "############5616"
 * Maskify.Maskify("64607935616");      // should return "#######5616"
 * Maskify.Maskify("1");                // should return "1"
 * Maskify.Maskify("");                 // should return ""
 * <p>
 * // "What was the name of your first pet?"
 * Maskify.Maskify("Skippy");                                   // should return "##ippy"
 * Maskify.Maskify("Nananananananananananananananana Batman!"); // should return "####################################man!"
 */
public class CreditCardMask {
    public static String maskify(String str) {
        int strLength = str.length();
        if (strLength > 4) {
            int maskedLength = strLength - 4;
            str = str.replace(str.subSequence(0, maskedLength), "#".repeat(strLength - 4));
        }
        return str;
    }
}
