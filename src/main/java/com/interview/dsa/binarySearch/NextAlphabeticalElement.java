package com.interview.dsa.binarySearch;

public class NextAlphabeticalElement {
    public static void main(String[] args) {
        char[] arr = {'d', 'h', 'l'};
        //"abcdefghijklmnopqrstuvwzxy"
        System.out.println("abcdefghijklmnopqrstuvwzxy".length());
        System.out.println(nextAlphabeticalElement(arr, 'j'));

    }

    public static char nextAlphabeticalElement(char[] array, char target) {

        if (array == null || array.length == 0) return '0';

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return array[start];
    }
}
