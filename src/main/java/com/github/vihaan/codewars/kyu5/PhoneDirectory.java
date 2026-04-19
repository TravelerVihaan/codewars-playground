package com.github.vihaan.codewars.kyu5;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/// John keeps a backup of his old personal phone book as a text file. On each line of the file he can find the phone number (formated as +X-abc-def-ghij where X stands for one or two digits), the corresponding name between < and > and the address.
/// Unfortunately everything is mixed, things are not always in the same order; parts of lines are cluttered with non-alpha-numeric characters (except inside phone number and name).
/// Examples of John's phone book lines:
/// "/+1-541-754-3010 156 Alphand\_St. <j steeve>\n"
///
/// " 133, Green, Rd. <e kustur> NY-56423 ;+1-541-914-3010!\n"
///
/// "<anastasia> +48-421-674-8974 Via Quirinal Roma\n"
///
/// Could you help John with a program that, given the lines of his phone book and a phone number num returns a string for this number : "Phone =&gt; num, Name =&gt; name, Address =&gt; adress"
/// Examples:
///
/// s = "/+1-541-754-3010 156 Alphand_St. <j steeve>\n 133, Green, Rd. <e kustur> NY-56423 ;+1-541-914-3010!\n"
///
/// phone(s, "1-541-754-3010") should return "Phone =&gt; 1-541-754-3010, Name =&gt; J Steeve, Address =&gt; 156 Alphand St."
///
///     It can happen that there are many people for a phone number num, then return : "Error =&gt; Too many people: num"
///
///     or it can happen that the number num is not in the phone book, in that case return: "Error =&gt; Not found: num"</e></j></anastasia></e></j>
class PhoneDirectory {
    
    public static String phone(String strng, String num) {
        Set<String> results = Arrays.stream(strng.split("\n"))
            .filter(row -> row.contains("+" + num))
            .map(row -> {
                StringBuilder builder = new StringBuilder("Phone => ");
                String phone = findRegex(row, "\\d+-\\d+-\\d+-\\d+");
                row = row.replace("+" +phone, "");
                builder.append(phone);

                String name = findRegex(row, "<([^>]+)>");
                row = row.replace(name, "");
                name = name.replaceAll("[<>]", "");
                builder.append(String.format(", Name => %s", name));

                row = row.replaceAll("[^a-zA-Z0-9\\s.-]", " ");

                row = row.replaceAll("\s+", " ").strip();
                builder.append(String.format(", Address => %s", row));
                return builder.toString();
            })
            .collect(Collectors.toSet());

        if (results.isEmpty()) {
            return String.format("Error => Not found: %s", num);
        } else if (results.size() > 1) {
            return String.format("Error => Too many people: %s", num);
        }
        return results.stream().findFirst().get();
    }

    private static String findRegex(String row, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(row);
        matcher.find();
        return matcher.group();
    }
}