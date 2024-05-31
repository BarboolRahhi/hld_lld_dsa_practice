package com.interview.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumDivisibleByK {


    public static void main(String[] args) {
       // System.out.println(subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.compute(2, (k ,v) -> null);
        System.out.println(map);
    }

    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0;
        map.put(0,  1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0)
                rem += k;
            ans += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }


}
