package com.interview.dsa.stack;

import java.util.Stack;

public class NextGreaterElement2 {



    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];

        // adding elements from last index to first in stack
        // so we can compare in cyclic way
        for (int i = nums.length - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while(!st.empty() && st.peek() <= nums[i]) {
                st.pop();
            }
            result[i] = st.empty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return result;
    }
}
