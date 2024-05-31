package com.interview.dsa.array;

import java.util.Arrays;

public class MarvoloGauntsRing {

    public static void main(String[] args) {

        int n = 5, p = 1, q = 2,  r = -3;
        int[] arr = {-1, -2, -3, -4, -5};

        long[][] dp = new long[n +1][3];

        dp[0][0] = dp[0][1] = dp[0][2] = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i+1][0] = Math.max(arr[i], p * dp[i][0]);
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < n; j++) {
                int constant = (i == 1) ? q : r;
                dp[j+1][i] = Math.max(dp[j][i], constant * arr[j] + dp[j+1][i-1]);
            }
        }
        print2D(dp);
        System.out.println(dp[n][2]);

    }

    public static void print2D(long[][] mat)
    {
        // Loop through all rows
        for (long[] row : mat){

            // Loop through all columns of current row
            for (long x : row)
                System.out.print(x + " ");

        System.out.println();
        }
    }
}
