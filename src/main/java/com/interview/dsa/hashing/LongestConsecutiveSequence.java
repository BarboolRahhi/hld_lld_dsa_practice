package com.interview.dsa.hashing;

import java.util.*;

public class LongestConsecutiveSequence {


    public static void main(String[] args) {
       // int[] arr = {-8,-4,9,9,4,6,1,-4,-1,6,8};
        int[] arr = {9,1,-3,2,4,8,3,-1,6,-2,-4,7};
//        System.out.println(longestConsecutive(arr));
//
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        System.out.println(areConsecutives(new long[]{89, 93, 94, 88, 91, 92, 94}, 7));
    }


     static  boolean areConsecutives(long[] arr, int N)
    {
        Set<Long> set = new HashSet<>();
        long min = Long.MAX_VALUE;
        for(long val: arr) {
            set.add(val);
            min = Math.min(min, val);
        }


        for (long i = min; i < min + N; i++) {
            if(!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, ans = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            map.put(nums[i], 0);
        }

        if (min < 0) {
            map.put(0,0);
        }

        for (int i = min; i < min + nums.length; i++) {
            if (map.containsKey(i)) {
                count++;
            } else {
                count = 0;
            }
            ans = Math.max(ans, count);
        }
        return ans;

    }
}
