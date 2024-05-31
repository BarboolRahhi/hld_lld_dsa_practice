package com.interview.dsa;

import java.util.Arrays;

public class CheckStringContainsNumber {

    public static void main(String[] args) {
        System.out.println(isNumeric("-1."));
    }

    public static boolean isNumeric(String value) {
        value = value.trim();
        int i = 0;
        int n = value.length();
        boolean isNumeric = false;
        if (i < n && (value.charAt(i) == '+' || value.charAt(i) == '-')) i++;
        while (i < n && Character.isDigit(value.charAt(i))) {
            i++;
            isNumeric = true;
        }

        if (i < n && value.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(value.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }

        if (isNumeric && i < n && (value.charAt(i) == 'e' || value.charAt(i) == 'E')) {
            i++;
            isNumeric = false;
            if (i < n && (value.charAt(i) == '+' || value.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(value.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }

        return isNumeric && i == n;

    }
}
