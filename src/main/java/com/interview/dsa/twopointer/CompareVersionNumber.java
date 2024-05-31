package com.interview.dsa.twopointer;

public class CompareVersionNumber {

    public static void main(String[] args) {

        System.out.println(compareVersion("1.0", "1.0.0"));

    }

    public static int compareVersion(String version1, String version2) {

        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        int i = 0;
        int j = 0;

        while (i < v1Arr.length || j < v2Arr.length) {

            int v1Val = i < v1Arr.length ? Integer.parseInt(v1Arr[i++]) : 0;
            int v2Val = j < v2Arr.length ? Integer.parseInt(v2Arr[j++]) : 0;

            if (v1Val != v2Val) {
                return v1Val < v2Val ? -1 : 1;
            }
        }

        return 0;
    }
}
