package com.epam.m1.exceptions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseIntegers {
      private static final List<String> WORDS =
            Arrays.asList(
                    "JDK 17 has released on 14 September 2021 with 10 new features, 2 feature removals and 2 feature deprecations."
                            .split(" "));

    public static void main(String[] args) {
        try {
        Iterator<String> words = WORDS.iterator();
        int sum = 0;
        String justWords = "";
        while (words.hasNext()) {
            String next = words.next();
            justWords = justWords + next + " ";
        }

        Pattern p = Pattern.compile("\\b[\\d]+\\b");
        Matcher m = p.matcher(justWords);
        while (m.find()) {
            int s = Integer.parseInt(m.group());
            sum = sum + s;
        }

        String q = justWords.replaceAll("\\d", "");
        justWords = q.replaceAll("  ", " ");


        System.out.println("Sum is " + sum);
        System.out.println("Just words: " + justWords);
        } catch (NumberFormatException e) {
            System.out.println("We can catch the NumberFormatException");
        }
    }
}
