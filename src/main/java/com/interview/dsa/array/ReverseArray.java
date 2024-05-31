package com.interview.dsa.array;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        //reverseArray(arr,0,arr.length-1);
      //  reverse(arr, 0, arr.length - 1);
        nextPermutation(arr);
       // Comparator.naturalOrder()
        System.out.println(Arrays.toString(arr));

    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        //step 1
        int peekPoint = nums.length - 2;
        while (peekPoint > 0 && nums[peekPoint] >= nums[peekPoint + 1]) {
            peekPoint--;
        }

        // step 2
        int peekSwapPoint = nums.length - 1;
        while (peekSwapPoint > 0 && nums[peekPoint] >= nums[peekSwapPoint]) {
            peekSwapPoint--;
        }

        //step 3
        swap(nums, peekPoint, peekSwapPoint);

        //step 4
        // if peekPoint == 0 && peekSwapPoint == 0, means whole arr is in decending order,
        int reverseStartIndex = peekPoint == 0 && peekSwapPoint == 0 ? 0 : peekPoint + 1;
        reverse(nums, reverseStartIndex, nums.length - 1);
    }


    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public static void reverseArray(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverseArray(arr, l + 1, r -1);
    }
}
