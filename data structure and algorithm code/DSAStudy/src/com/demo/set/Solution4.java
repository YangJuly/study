package com.demo.set;

import java.util.*;

/**
 * @author : yangzanjie
 * create at:  2019-12-26  15:47
 * @description:
 */
public class Solution4 {
    public String countOfAtoms(String formula) {
        i = 0;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) result.append(entry.getValue());
        }
        return result.toString();
    }

    //用于存储当前处理formula的index
    int i;

    //return 当前次处理到何处
    public Map<String, Integer> parse(String formula) {
        int N = formula.length();
        //使用TreeMap 字典顺序存储元素
        Map<String, Integer> count = new TreeMap<>();
        //遇到')' 就要准备返回
        while(i < N && formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                i++;
                //处理子问题
                for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) i++;
                String temp = formula.substring(iStart, i);
                //process num
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                int num = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                count.put(temp, count.getOrDefault(temp, 0) + num);
            }
        }
        int iStart = ++i;
        while (i < N && Character.isDigit(formula.charAt(i))) i++;
        //如果'）'跟了数字，即大于1，则需要乘操作处理下
        if (iStart < i) {
            int multi = Integer.parseInt(formula.substring(iStart, i));
            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                count.put(entry.getKey(), entry.getValue() * multi);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution4 solution =  new Solution4();
        String str = "H2O";
        System.out.println(solution.countOfAtoms(str));
    }
}
