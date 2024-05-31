package com.interview.dsa.stack;

import java.util.HashMap;
import java.util.Stack;

public class InfixEvaluation {

    public static void main(String[] args) {
        // Q - "2+(5-3*6/2)"

        var exp = "-2+1";
        var operators = new Stack<Character>();
        var operends = new Stack<Integer>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') continue;

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operends.push(ch - '0');
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char optor = operators.pop();
                    int v2 = operends.pop();
                    int v1 = operends.pop();
                    int res = Operator.getOperator(optor).operation(v1, v2);
                    operends.push(res);
                }
                operators.pop();
            } else {
                while (!operators.empty() && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())  ) {
                    char optor = operators.pop();
                    int v2 = operends.pop();
                    int v1 = operends.pop();
                    int res = Operator.getOperator(optor).operation(v1, v2);
                    operends.push(res);
                }

                operators.push(ch);
            }
        }

        while (!operators.empty()) {
            char optor = operators.pop();
            int v2 = operends.pop();
            int v1 = operends.pop();
            int res = Operator.getOperator(optor).operation(v1, v2);
            operends.push(res);
        }

        System.out.println(operends.peek());

    }


    enum Operator {
        PLUS('+') {
            @Override
            int operation(int v1, int v2) {
                return v1 + v2;
            }
        },
        MINUS('-') {
            @Override
            int operation(int v1, int v2) {
                return v1 - v2;
            }
        },
        DIVIDE('/') {
            @Override
            int operation(int v1, int v2) {
                return v1 / v2;
            }
        },
        MULTIPLE('*') {
            @Override
            int operation(int v1, int v2) {
                return v1 * v2;
            }
        };
        private final char operater;

        Operator(char operater) {
            this.operater = operater;
        }

        abstract int operation(int v1, int v2);

        public char value() {
            return operater;
        }

        public static Operator getOperator(char op) {
            for (var operator : values()) {
                if (operator.operater == op) {
                    return  operator;
                }
            }
            throw new IllegalArgumentException("Operator not Found");
        }
    }

    public static int precedence(char op) {
        Operator operator = Operator.getOperator(op);
        switch (operator) {
            case PLUS:
            case MINUS:
                return  1;
            case DIVIDE:
            case MULTIPLE:
                return 2;
        }
        return -1;
    }
}
