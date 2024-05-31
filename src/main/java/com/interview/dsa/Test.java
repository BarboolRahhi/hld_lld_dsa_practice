package com.interview.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        Optional<String> name = Optional.of("ABC");
//        name = Optional.ofNullable(null);
//        System.out.println(name.isPresent());
//
//        System.out.println(name.orElse("dfd"));
//        Integer d = 9;
//        i(d);
//        System.out.println(d);
//        Queue<Integer> queue = new LinkedList<>();

        System.out.println(checkInclusion("ab","eidboaboo"));

    }

    public static boolean checkInclusion(String s1, String s2) {
        var map = new HashMap<Character, Integer>();
        for (var ch: s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            if (map.containsKey(s2.charAt(right))) {
                int val = map.get(s2.charAt(right)) - 1;
                if (val == 0) {
                    map.remove(s2.charAt(right));
                } else {
                    map.put(s2.charAt(right), val);
                }
                right++;
                if (right < s2.length() &&!map.containsKey(s2.charAt(right)) && (right - left) == s1.length() - 1) {
//                    while (left < right) {
//
//                    }
                    map.put(s2.charAt(left), map.getOrDefault(s2.charAt(left), 0) + 1);
                    left++;
                }
                if (map.isEmpty()) {
                    return true;
                }
            } else {
                left++;
                right++;
            }
        }

        return false;
    }


    static void i(Integer i) {
        i = 5;
    }
}

