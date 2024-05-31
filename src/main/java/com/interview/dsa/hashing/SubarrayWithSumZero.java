package com.interview.dsa.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithSumZero {


    public static void main(String[] args) {
        System.out.println(findsum(new int[] {4, 2, -3, 1, 6}, 5));
    }

    static boolean findsum(int arr[],int n)
    {
        //Your code here
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;
        for (int i =0; i < n; i++) {
            sum = sum + arr[i];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }

        return false;
    }



}
