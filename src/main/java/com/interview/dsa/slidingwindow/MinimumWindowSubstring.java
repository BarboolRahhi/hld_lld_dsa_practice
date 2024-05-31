package com.interview.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {

        if (s == null || t == null || t.isEmpty() || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        int i = 0, j = 0, count = map.size();
        int left = 0, right = s.length(), min = s.length();

        boolean found = false;

        while (j < s.length()) {
            char endChar = s.charAt(j++);

            var val = map.computeIfPresent(endChar, (key, value) -> value - 1);
            if (val != null && val == 0) {
                count -= 1;
            }

            if (count > 0) continue;

            while (count == 0) {
                char startChar = s.charAt(i++);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count += 1;
                    }
                }
            }


            if ((j - i) < min) {
                left = i;
                right = j;
                min = j - i;
                found = true;
            }
        }



        return !found ? "" : s.substring(left - 1, right);
    }
}
