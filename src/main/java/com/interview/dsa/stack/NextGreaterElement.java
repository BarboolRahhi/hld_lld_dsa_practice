package com.interview.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 3, 5};
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            result[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > cur) {
                    result[i] = arr[j];
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(nextGreaterElement(arr, arr.length)));
    }

    static int[] nextGreaterElement(int[] arr, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.empty() && arr[i] > arr[stack.peek()])  {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }
}
