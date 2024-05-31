package com.interview.dsa.binarySearch;

public class PositionInInfiniteArray {

    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10,10,10,78,89};
        int target = 78;
        int pos = findPosition(arr, target);
        System.out.println(pos);
    }

    public static int findPosition(int[] arr, int target) {

        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            start = end;
            end *= 2;
        }

        return BinarySearchAlgo.binarySearch(arr, target, start, end);
    }


}
