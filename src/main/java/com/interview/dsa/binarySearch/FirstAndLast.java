package com.interview.dsa.binarySearch;

public class FirstAndLast {

    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10,10,10,78,89};

        var first = firstOccrences(arr, 10);
        var last = lastOccrences(arr, 10);
        System.out.println(first);
        System.out.println(last);
        System.out.println(last - first + 1);
    }

    static int firstOccrences(int[] arr, int target) {

        int start = 0;
        int end = arr.length -1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                index = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }

    static int lastOccrences(int[] arr, int target) {

        int start = 0;
        int end = arr.length -1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                index = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }
}
