package com.interview.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

        var arrs = new int[]{1,1};
        System.out.println(Arrays.toString(leftNextSmallerElements(arrs)));
        System.out.println(Arrays.toString(rightNextSmallerElements(arrs)));
        System.out.println(new NextSmallerElement().largestRectangleArea(arrs));

    }

    public int largestRectangleArea(int[] heights) {

        var rb = rightNextSmallerElements(heights);
        var lb = leftNextSmallerElements(heights);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

    public static int[] leftNextSmallerElements(int[] arr) {
        var st = new Stack<Integer>();
        var result = new int[arr.length];
        st.push(0);
        result[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (!st.empty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            result[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    public static int[] rightNextSmallerElements(int[] arr) {
        var stack = new Stack<Integer>();
        var result = new int[arr.length];
        stack.push(arr.length - 1);
        result[arr.length -1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.empty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.empty() ? arr.length : stack.peek();
            stack.push(i);
        }

        return result;
    }
}
