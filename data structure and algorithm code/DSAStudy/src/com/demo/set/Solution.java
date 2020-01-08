package com.demo.set;

/**
 * @author : yangzanjie
 * create at:  2019-12-20  14:55
 * @description:
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi",
                "issip"));
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] pattern = generatePattern(needle);

        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (count > 0 && haystack.charAt(i) != needle.charAt(count)) {
                count = pattern[count];
            }
            if (haystack.charAt(i) == needle.charAt(count)) {
                count++;
            }
            if (count == needle.length()) {
                return i - count + 1;
            }
        }
        return -1;
    }

    public int[] generatePattern(String needle) {
        int[] pattern = new int[needle.length()];
        int maxLength = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (maxLength > 0 && needle.charAt(maxLength) !=  needle.charAt(i)) {
                maxLength = pattern[maxLength - 1];
            }
            if (needle.charAt(i) == needle.charAt(maxLength)) {
                maxLength++;
            }
            pattern[i] = maxLength;
        }
        return pattern;
    }
}
