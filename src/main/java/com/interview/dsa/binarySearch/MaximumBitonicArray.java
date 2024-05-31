package com.interview.dsa.binarySearch;

public class MaximumBitonicArray {

    public static void main(String[] args) {
        int[] array = new int[]{3, 23};
        var res = findMaxBitonic(array);
        System.out.println(res);
        if (res != -1) {
            System.out.println(array[res]);
        }
    }

    public static int findMaxBitonic(int[] array) {
        int start = 0;
        int end = array.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || array[mid] > array[mid - 1])
                    && (mid == array.length - 1 || array[mid] > array[mid + 1])) {
                return mid;
            } else if (array[mid] < array[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
