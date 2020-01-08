package com.yangzanjie.demo;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author : yangzanjie
 * create at:  2019-12-06  17:40
 * @description: 以出现次数对URL排序（升序）
 */
public class SortUrlByCount {

    private int buketSize = 1000;

    private int min;

    private int max;

    private int size;

    public String[] sort(String[] urlArrays) {
        //step 1 get count
        size = urlArrays.length;
        Map<String, Integer> map = new HashMap<>();
        for (String s : urlArrays) {
            if (map.containsKey(s)) {
                int value = map.get(s) + 1;
                map.put(s, value);
            } else {
                map.put(s, 1);
            }
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
            }
            if (min > map.get(s)) {
                min = map.get(s);
            }
        }

        if (max - min + 1 < buketSize) {
            //bucketSort
            return bucketSort(map);
        } else {
            //quickSort
            //todo
        }


        return null;
    }

    private String[] bucketSort(Map<String, Integer> map) {
        //todo
        List<String>[] temp = new ArrayList[this.buketSize];
        for (String s : map.keySet()) {
            int count = map.get(s);
            int index = count - min;
            if (temp[index] == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                temp[index] = list;
            } else {
                List<String> list = temp[index];
                list.add(s);
            }
        }

        String[] result = new String[size];

        int i = 0;
        for (int count = 0; count < temp.length; count++) {
            if (temp[count] != null) {
                for (String s : temp[count]) {
                    int tempCount = count;
                    while (tempCount >= 0) {
                        tempCount--;
                        result[i] = s;
                        i++;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        SortUrlByCount test = new SortUrlByCount();
        String[] urls = {"https://www.souche.com",
                "https://www.souche.com",
                "https://www.souche.com",
                "https://www.taobao.com",
                "https://www.taobao.com",
                "https://www.baidu.com"};

        String[] results = test.sort(urls);

        for (String s : results) {
            System.out.println(s);
        }
    }
}
