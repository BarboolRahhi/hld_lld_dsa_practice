package com.interview.dsa.array;

import java.util.Arrays;
import java.util.Scanner;

//0 1 2 3 4 5
//1 2 4 5 6 7
// 1,3
public class PrefixSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scan.nextInt();
        }

        int[] sumarr = new int[arraySize];
        sumarr[0] = array[0];
        for (int i = 1; i < sumarr.length; i++) {
            sumarr[i] = array[i] + sumarr[i - 1];
        }

        int q = scan.nextInt();

        for (int i = 0; i < q; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int sum = sumarr[r] - sumarr[l-1];
            System.out.println(sum);
        }


        System.out.println(Arrays.toString(sumarr));

    }

    static void prefixSum(int[] arr) {

    }
}

