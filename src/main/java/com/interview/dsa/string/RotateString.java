package com.interview.dsa.string;

public class RotateString {
    public static void main(String[] args) {

        //abcdeabcde
        System.out.println(rotateString("abcde", "eabcd"));

    }

    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)) return true;

        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(i) + s.substring(0 , i);
            System.out.println(temp);
            if (temp.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}
