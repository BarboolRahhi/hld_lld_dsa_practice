package com.interview.dsa.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {

        System.out.println( Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,2,2,3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

       TreeMap<Integer, Integer> map = new TreeMap<>();

       for (int num: nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }

        System.out.println(map.pollLastEntry());
        System.out.println(map);


        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
