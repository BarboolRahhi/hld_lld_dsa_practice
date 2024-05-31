package com.interview.dsa.array;

import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        System.out.println(findUnsortedSubarray(new int[]{7,9,10,4,3}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -1;

        for(int i = 0;i < nums.length - 1;i++) {
            if(nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }

        if(start == -1) { return 0; }

        for(int i = nums.length - 1;i > 0;i--) {
            if(nums[i] < nums[i - 1]) {
                end = i;
                break;
            }
        }

        int tempMin = Integer.MAX_VALUE;
        int tempMax = Integer.MIN_VALUE;

        for(int i = start;i <= end;i++) {
            tempMin = nums[i] < tempMin ? nums[i] : tempMin;
            tempMax = nums[i] > tempMax ? nums[i] : tempMax;
        }

        for(int i = 0;i < start;i++) {
            if(nums[i] > tempMin) {
                start = i;
                break;
            }
        }

        for(int i = nums.length - 1;i > end;i--) {
            if(nums[i] < tempMax) {
                end = i;
                break;
            }
        }

        return ( end - start + 1 );


    }
}
