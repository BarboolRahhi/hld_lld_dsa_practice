package com.interview.dsa.stack;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {

        System.out.println(calculate("2147483647"));

    }

    public static int calculate(String exp) {
        int sign = 1;
        int currentNumber = 0;
        int sum = 0;

        var stack = new Stack<Integer>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    currentNumber = currentNumber * 10 + (exp.charAt(i) - '0');
                    i++;
                }
                currentNumber = currentNumber * sign;
                sum += currentNumber;
                currentNumber = 0;
                sign = 1;
                i--;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                int pervSign = stack.pop();
                sum *= pervSign;
                int pervSum = stack.pop();
                sum += pervSum;
            }
        }

        return sum;
    }
}
