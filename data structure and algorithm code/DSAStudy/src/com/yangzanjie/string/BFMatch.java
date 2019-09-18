package com.yangzanjie.string;

/**
 * @author : yangzanjie
 * create at:  2019-09-17  20:48
 * @description: BF算法，暴力匹配算法，朴素匹配算法
 */
public class BFMatch {
    public boolean isMatch(String mainStr, String targetStr) {
        char[] targetChars = targetStr.toCharArray();
        char[] mainChars = mainStr.toCharArray();
        for (int i = 0; i < mainChars.length - targetChars.length; i++) {
            int j = 0;
            for (; j < targetChars.length; j++) {
                if (mainChars[i] != targetChars[j])  {
                    break;
                }
            }
            if (j == targetChars.length - 1) return true;
        }
        return false;
    }
}
