package com.interview.dsa.array;

import java.util.Arrays;

public class FirstAndLastOfSortedArray {

    public static void main(String[] args) {

        int[] arr = {1,2,2,3,4,5};
        System.out.println(Arrays.toString(searchRange(arr, 2)));
        System.out.println(Arrays.toString(searchRangeWithBinarySearch(arr, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[]{-1, -1};

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (nums[left] == target && nums[right] == target) {
                return new int[]{left, right};
            }
            if (nums[left] != target) {
                left++;
            }
            if (nums[right] != target) {
                right--;
            }
        }

        return new int[]{-1, -1};
    }


    public static int[] searchRangeWithBinarySearch(int[] nums, int target) {
        return new int[]{startIndex(nums, target), lastIndex(nums, target)};
    }



    private static int startIndex(int[] nums, int target) {
        int n = nums.length;
        int result = -1;
        if(n == 0) return result;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    private static int lastIndex(int[] nums, int target) {
        int n = nums.length;
        int result = -1;
        if(n == 0) return result;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }
}
