package com.interview.dsa.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(ints));

        rotate(ints, 3);

    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        reverseArray(nums, 0, k  - 1);
        reverseArray(nums, k, nums.length - 1 );
        System.out.println(Arrays.toString(nums));
    }

    static void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
