package com.example;

import java.util.ArrayList;
import java.util.List;

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

        String[] nums = numbers.split("[" + delimiter + "\n]");
        int sum = 0;
        List<String> negatives = new ArrayList<>();

        for (String num : nums) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                negatives.add(num);
            } else if (n <= 1000) {
                sum += n;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }

        return sum;
    }
}
