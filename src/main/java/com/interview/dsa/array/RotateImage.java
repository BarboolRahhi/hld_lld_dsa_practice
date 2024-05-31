package com.interview.dsa.array;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int start = 0;
        int end = arr.length -1;
        while (start < end) {
            int[] temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        print2D(arr);

        rotate(arr);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
       // int[][] temp = new int[n][n];
        /*for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                temp[i][n - j - 1] = matrix[j][i];
            }
        }

        matrix = temp;*/

        int start = 0;
        int end = matrix.length -1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        int c = 0;
        for (int i = 0; i < n -1; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[c][j];
                matrix[c][j] = matrix[j][c];
                matrix[j][c] = temp;
            }
            c++;
        }

        print2D(matrix);
    }



    public static void print2D(int[][] mat) {
        // Loop through all rows
        for (int[] row : mat) {

            // Loop through all columns of current row
            for (int x : row)
                System.out.print(x + " ");

            System.out.println();
        }
    }

}
