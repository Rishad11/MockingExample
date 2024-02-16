package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String regex = "[" + delimiter + "\n]";
        String[] nums = numbers.split(regex);

        int sum = 0;
        List<String> negatives = new ArrayList<>();

        for (String num : nums) {
            if (!num.isEmpty()) {
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negatives.add(num);
                } else if (n <= 1000) {
                    sum += n;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }

        return sum;
    }
}
