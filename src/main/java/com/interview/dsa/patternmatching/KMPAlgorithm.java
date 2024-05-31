package com.interview.dsa.patternmatching;

import java.util.Arrays;

public class KMPAlgorithm {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeLPS("aabcadaabea")));
    }


    private static int[] computeLPS(String pattern) {
        int pLength = pattern.length();
        int[] lps = new int[pLength];
        lps[0] = 0;
        int i = 1;
        int previousLength = 0;

        while (i < pLength) {
            if (pattern.charAt(i) == pattern.charAt(previousLength)) {
                previousLength += 1;
                lps[i] = previousLength;
                i++;
            } else if (previousLength != 0) {
                previousLength = lps[previousLength - 1];
            } else {
                lps[i] = 0;
                i++;
            }

        }
        return lps;
    }
}
