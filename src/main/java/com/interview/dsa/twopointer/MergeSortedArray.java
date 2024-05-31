package com.interview.dsa.twopointer;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] array1 = new int[]{2,2,3,0,0,0};
        int[] array2 = new int[]{1,5,6};
        merge(array1, 3, array2, 3);

        System.out.println(Arrays.toString(array1));
    }

    public static void merge(int[] num1, int m, int[] num2, int n) {
        int index = m + n - 1;

        while (m > 0  && n > 0) {
            if (num1[m - 1] > num2[n - 1]) {
                num1[index] = num1[m - 1];
                m--;
            } else {
                num1[index] = num2[n - 1];
                n--;
            }
            index--;
        }

        while (n > 0) {
            num1[index] = num2[n - 1];
            n--;
            index--;
        }
    }

    public void mergeWithExtraSpace(int[] nums1, int m, int[] nums2, int n) {

         int[] dummyNum1 = new int[m];

         for (int i = 0; i < m; i++) {
             dummyNum1[i] = nums1[i];
         }

         int indexA = 0;
         int indexB = 0;
         int i = 0;
         while (indexA != m && indexB != n) {
         	if (dummyNum1[indexA] < nums2[indexB]) {
         		nums1[i] = dummyNum1[indexA];
         		indexA++;
         		i++;
         	} else {
         		nums1[i] = nums2[indexB];
         		indexB++;
         		i++;
         	}
         }

         while (indexB != n) {
         	nums1[i] = nums2[indexB];
         	indexB++;
         	i++;
         }

         while (indexA != m) {
         	nums1[i] = dummyNum1[indexA];
         	indexA++;
         	i++;
         }

    }

}
