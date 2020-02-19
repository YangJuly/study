package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yangzanjie
 * create at:  2020-01-13  23:29
 * @description:
 */
public class Demo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println("before remove list = " + list);
        for (String str : list) {
            if ("2".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println("after remove list = " + list);
    }
}
