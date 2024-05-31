package com.interview.dsa.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        System.out.println(Character.isLetterOrDigit(']'));
        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        if (s.length() == 1) return false;

        for (int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                if (stack.empty()) return false;

                char top = stack.pop();

                if (ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
