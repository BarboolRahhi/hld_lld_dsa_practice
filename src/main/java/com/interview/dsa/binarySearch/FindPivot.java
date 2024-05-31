package com.interview.dsa.binarySearch;

public class FindPivot {

    public static void main(String[] args) {

        //System.out.println(8 % 5);

        // if first element is mid or
        // last element is mid
        // then simply use modulo so it
        // never goes out of bound.
//        int mid = low + (high - low) / 2;
//        int prev = (mid - 1 + n) % n;
//        int next = (mid + 1) % n;

        int[] arr = {6,7,9,10,11,14,2,3,4,5};

        int index = findPivot(arr);

        System.out.println(arr[index]);
    }

    public static int findPivot(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) return mid + 1;
            if (mid > start && arr[mid] < arr[mid - 1]) return mid;

            if (arr[mid] > arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
