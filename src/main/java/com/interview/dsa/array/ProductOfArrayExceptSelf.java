package com.interview.dsa.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        int previousCount = 1;
        for (int i = nums.length - 2;  i >= 0; i--) {
            int result = nums[i + 1] * previousCount;
            previousCount = result;
            left[i] *= result;
        }

        return left;
    }
}
