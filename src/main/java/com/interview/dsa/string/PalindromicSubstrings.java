package com.interview.dsa.string;

import java.util.Arrays;
import java.util.Stack;

public class PalindromicSubstrings {
    public static void main(String[] args) {

        System.out.println(countSubstrings("abccbc"));
    }

    public static int countSubstrings(String s) {

        Stack stack = new Stack<>();

        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {

                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j]) count++;

            }
        }
        return count;
    }
}
