package com.interview.dsa.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestSubarrayWithSumZero {


    public static void main(String[] args) {
        System.out.println(9%5);
     //   System.out.println(findsum(new int[] {15, -2, 2, -8, 1, 7, 10, 23}, 8));
    }

    static int findsum(int arr[],int n)
    {

        Map<Integer, Integer> map = new HashMap<>();


        int pSum = 0;
        int length = 0;
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            pSum += arr[i];
            if (!map.containsKey(pSum)) {
                map.put(pSum, i);
            } else {
                length = Math.max(length, i - map.get(pSum));
            }

        }

        return length;
    }



}
