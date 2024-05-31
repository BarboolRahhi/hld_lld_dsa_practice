package com.interview.basic;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class ShortCut {

    public static void main(String[] args) {
        String s = "rhhi@stateaut.com";

        Validation validation = value -> value.startsWith("ra");

        // combinator pattern
        boolean validate = Validation
                .email()
                .and(Validation.domain())
                .and(validation)
                .validate(s);
        System.out.println(validate);

        System.out.println(longestConsecutive(new int[]{200,1,3,4,2,6}));

        int[][] arr = new int[4][3];

        System.out.println(arr[0].length);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var store = new HashMap<Character, Integer>();

        for (char ch: s.toCharArray()) {
            store.put(ch, store.getOrDefault(ch, 0) + 1);
        }

        for (char ch: s.toCharArray()) {
            if (!store.containsKey(ch)) {
                return false;
            } else {
                store.put(ch, store.get(ch) - 1);
                if (store.get(ch) <= 0) {
                    store.remove(ch);
                }
            }
        }

        return store.isEmpty();
    }

    public static void complete(LocalDateTime localDateTime) {

        String s = Arrays.toString(new int[]{1, 2});
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
