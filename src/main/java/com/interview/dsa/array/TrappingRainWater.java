package com.interview.dsa.array;

import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(pMax(height)));
        System.out.println(Arrays.toString(sMax(height)));
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int amountOfWater = 0;
        int[] pMax = pMax(height);
        int[] sMax = sMax(height);

        for (int i = 1; i < height.length - 1; i++) {
            int d = Math.min(pMax[i], sMax[i]);
            if (d > height[i]) {
                amountOfWater += (d - height[i]);
            }
        }
        return amountOfWater;
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

    public  static  int[] sMax(int[] height) {
        int n = height.length;
        int[] sMax = new int[n];
        sMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            sMax[i] = Math.max(sMax[i+1], height[i]);
        }
        return sMax;
    }
}
