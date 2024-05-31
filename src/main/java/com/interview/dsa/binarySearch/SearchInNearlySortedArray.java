package com.interview.dsa.binarySearch;

public class SearchInNearlySortedArray {

    public static void main(String[] args) {
        int res = binarySearchInNearlySortedArray(new int[]{5, 10, 30, 20, 40}, 40);
        System.out.println(res);
    }


    public static int binarySearchInNearlySortedArray(int[] array, int target) {
        if (array == null || array.length == 0) return -1;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            if (mid < right && array[mid + 1] == target) return mid + 1;
            if (mid > left && array[mid - 1] == target) return mid - 1;

            if (array[mid] > target) {
                right = mid - 2;
            } else {
                left = mid + 2;
            }
        }

        return -1;
    }
}
