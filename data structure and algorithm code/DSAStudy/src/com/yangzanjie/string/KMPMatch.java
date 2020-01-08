package com.yangzanjie.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yangzanjie
 * create at:  2019-12-09  16:18
 * @description: KMP算法实现
 * 思想：回退pattern模式串，不回退text主串
 * 回退pattern模式串，用到最大前缀后缀匹配，用到动态规划思想，这部分提前预处理，减少算法时间复杂度
 */
public class KMPMatch {
    public static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int[] maxLength = calculateMaxLength(pattern);
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            while (count > 0 && text.charAt(i) != pattern.charAt(count)) {
                count = maxLength[count-1];
            }
            if (text.charAt(i) == pattern.charAt(count)) {
                count++;
            }
            if (count == pattern.length()) {
                positions.add(i - count + 1);
                count = maxLength[pattern.length() - 1];
            }
        }
        return positions;
    }

    public static int[] calculateMaxLength(String pattern) {
        int[] maxMaxLengths = new int[pattern.length()];
        int maxLength =  0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(i) != pattern.charAt(maxLength)) {
                maxLength = maxMaxLengths[maxLength - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(maxLength)) {
                maxLength += 1;
            }
            maxMaxLengths[i] = maxLength;
        }
        return maxMaxLengths;
    }

    public static void main(String[] args) {
        String text = "hello";
        String pattern = "ll";
        List<Integer> positions = search(text, pattern);
        for (int i : positions) {
            System.out.println(i);
        }
    }
}
