package com.interview.dsa.binarySearch;

import static com.interview.dsa.binarySearch.FindPivot.findPivot;

public class SearchInRoatedArray {

    public static void main(String[] args) {

        int target = 81;
        int[] array = new int[]{4,6,7,8,1,2, 3};
        int res  = findInRotatedArray(array, target);
        System.out.println("Index: "+ res + " Res: "+ (res == -1 ? "not found" : array[res]));
    }

    public static int findInRotatedArray(int[] array, int target) {
        int pivot = findPivot(array);
        System.out.println("pivot: "+ pivot);
        if (pivot == -1) {
            return binarySearch(array, target, 0, array.length - 1);
        }

        if (array[pivot] == target) {
            return pivot;
        }

        if (target > array[0]) {
           return binarySearch(array, target, 0, pivot - 1);
        } else {
            return binarySearch(array, target, pivot, array.length - 1);
        }
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1 ;
            }
        }

        return -1;
    }

}
