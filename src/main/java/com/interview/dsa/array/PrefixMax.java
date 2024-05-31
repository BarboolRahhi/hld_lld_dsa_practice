package com.interview.dsa.array;

import java.util.Arrays;

public class PrefixMax {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pMax(new int[]{1, 3, 2, 4, 3})));
        System.out.println(Arrays.toString(sMax(new int[]{1, 3, 2, 4, 3})));

        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
        int m = Integer.MIN_VALUE;
    }

    public static int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int amount = 0;
        int[] pMax = pMax(height);
        int[] sMax = sMax(height);

        for (int i = 1; i < height.length - 1; i++) {
            int d = Math.min(pMax[i], sMax[i]);
            if (d > height[i]) {
                amount += (d - height[i]);
            }
        }
        return amount;
    }

    public static int[] pMax(int[] height) {
        int n = height.length;
        int[] pMax = new int[n];
        pMax[0] = height[0];
        for (int i = 1; i <= n-1; i++) {
            pMax[i] = Math.max(pMax[i-1], height[i]);
        }
        return pMax;
    }

    public static int[] sMax(int[] height) {
        int n = height.length;
        int[] sMax = new int[n];
        sMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            sMax[i] = Math.max(sMax[i+1], height[i]);
        }
        return sMax;
    }
}
