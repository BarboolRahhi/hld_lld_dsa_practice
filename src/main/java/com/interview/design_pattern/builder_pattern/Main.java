package com.interview.design_pattern.builder_pattern;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
//       // var s = "ss".endsWith("dd")
//        var product = new Product.Builder()
//                .id(223)
//                .name("Smart Phone")
//                .price(BigDecimal.valueOf(34000))
//                .color("BLUE")
//                .build();
//
//        var product1 = Product.builder()
//                .id(223)
//                .name("Smart Phone")
//                .price(BigDecimal.valueOf(34000))
//                .color("BLUE")
//                .build();
//
//        var locale = new Locale("en");
//
//        System.out.println(locale);
//        System.out.println(product);

        System.out.println(Arrays.toString(twoSum(new int[]{10, 10, 10, 1, 8, 5, 4, -6, -6 }, 9, 4)));
    }

    public static int[] twoSum(int arr[], int n,int target) {
        // Write your code here.

        var integer = new BigInteger("567");
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < arr.length; i++) {
            int key = target - arr[i];
            if (map.containsKey(key)) {
                if (map.get(key) < res[0] || (map.get(key) == res[0] && res[1] < i)) {
                    res[0] = map.get(key);
                    res[1] = i;
                }
            } else if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }

        return res[0] == Integer.MAX_VALUE ? new int[] {-1, -1} : res;
    }
}
