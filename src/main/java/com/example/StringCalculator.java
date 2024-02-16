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
            Matcher matcher = Pattern.compile("//\\[(.*?)\\]\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            } else {
                delimiter = numbers.substring(2, 3);
                numbers = numbers.substring(4);
            }
        }

        String regex = "[" + delimiter + "\n]+";
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
