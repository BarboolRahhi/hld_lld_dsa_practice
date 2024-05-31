package com.interview.dsa.binarySearch;

import java.util.Arrays;

public class BinarySearchAlgo {

    public static void main(String[] args) {

        //System.out.println(search(new int[] {2}, 2));
//        System.out.println(rotatedSearch(new int[]{4,5,6,7,0,1,2}, 0));
//        System.out.println('a' + 1);
//        System.out.println(nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'j'));
//
//        System.out.println(peakIndexInMountainArray(new int[]{1,2,3,5,6,4,3,3}));

        System.out.println(findPivotInRotatedArray(new int[]{10,1,10,10,10}));

        //System.out.println(searchRotated(new int[]{3, 5, 1}, 3));

       // System.out.println(specialArray(new int[]{4,3,1,2}));

       // System.out.println(findSingleElement(new int[]{3,3,7,7,10,11,11}));


       // System.out.println(13 ^ 1);
    }

    static int findSingleElement(int nums[]) {

        int low = 0;
        int high = nums.length - 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 0) {
                // Checking whether we are in right half
                if (nums[mid] != nums[mid + 1])

                    //Shrinking the right half
                    high = mid - 1;
                else
                    // Shrinking the left half
                    low = mid + 1;
            } else {
                // Checking whether we are in right half
                if (nums[mid] == nums[mid + 1])
                    //Shrinking the right half
                    high = mid - 1;
                else
                    // Shrinking the left half
                    low = mid + 1;
            }
        }
        return nums[low];
    }

    public static int specialArray(int[] nums) {

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid  = start + (end - start) / 2;
            int x = nums.length - mid;
            if (nums[mid] >= x) {
                if (mid == 0 || nums[mid - 1] <= x) {
                    return x;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int searchRotated(int[] nums, int target) {

        int piviot = findPivotInRotatedArray(nums);
        if (piviot == -1) {
            return binarySearch(nums, target, 0, nums.length -1);
        }

        if (target == nums[piviot]) {
            return piviot;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, piviot - 1);
        }

        return binarySearch(nums, target, piviot + 1, nums.length -1);

    }

    public static int findPivotInRotatedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid  = start + (end - start) / 2;
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid  - 1;
            } else if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid] < arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;

    }

    public static int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1 ;
            }
        }

        return start >= letters.length ? letters[0]  : letters[start];
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
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



    public static int rotatedSearch(int[] arr, int target) {

        int pivot = 0;
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i + 1;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(pivot);

        return -1;
    }
}
