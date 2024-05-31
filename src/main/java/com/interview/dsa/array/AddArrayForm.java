package com.interview.dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddArrayForm {

    public static void main(String[] args) {

        System.out.println(addToArrayForm(new int[]{1}, 806));
    }


    public static List<Integer> addToArrayForm(int[] num, int k) {

        LinkedList<Integer> result  = new LinkedList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0 || k > 0; i--) {
            int var1 = i >= 0  ? num[i] : 0;
            int var2 = k % 10;
            k = k / 10;
            int sum = var1 + var2 + carry;
            carry = sum / 10;
            result.addFirst(sum % 10);
        }

        if (carry != 0){
            result.addFirst(carry);
        }

        return result;
    }

}
