package com.interview.dsa.binarySearch;

public class CeilingInSortedArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 8, 12, 19};
        int index = ceilingInSortedArray(arr, 0);
        if (index != -1)
            System.out.println(arr[index]);
        int floor = floorInSortedArray(arr, 0);

        if (floor != -1)
            System.out.println(arr[floor]);
    }

    public static int ceilingInSortedArray(int[] array, int target) {

        if (array == null || array.length == 0) return -1;

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
               return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static int floorInSortedArray(int[] array, int target) {

        if (array == null || array.length == 0) return -1;

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
