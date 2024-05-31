package com.interview.dsa.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println((1 + Math.sqrt(5)) / 2.0);
        System.out.println(
                characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }

    public static int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxCount = 0;

        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char chRight = s.charAt(right);
            int chVal = map.getOrDefault(chRight, 0) + 1;
            maxCount = Math.max(maxCount, chVal);
            map.put(chRight, chVal);

            while (right - left + 1 - maxCount > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
