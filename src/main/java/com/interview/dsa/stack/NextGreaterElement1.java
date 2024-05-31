package com.interview.dsa.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class NextGreaterElement1 {

    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};
       System.out.println(Arrays.toString(nextGreaterElement(arr1, arr2)));

      //  System.out.println(nextGreaterElements(new int[]{1,3,4,2}));
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        final int nums2Size = nums2.length;
        final int lastElement2 = nums2[nums2Size - 1];

        stack.push(lastElement2);
        map.put(lastElement2, -1);

        for(int i = nums2Size - 2; i >= 0; i--) {
            while(!stack.empty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);
        }

        System.out.println(stack);
        return Arrays.stream(nums1).map(map::get).toArray();
    }

    public static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            stack.push(nums[i]);
        }

        int greater[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            greater[i]=stack.empty()?-1:stack.peek();
            stack.push(nums[i]);
        }

        return greater;
    }
}
