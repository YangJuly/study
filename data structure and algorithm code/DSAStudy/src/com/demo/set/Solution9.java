package com.demo.set;

import java.util.*;

/**
 * @author : yangzanjie
 * create at:  2019-12-28  12:23
 * @description:
 */
public class Solution9 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        Map<String, Integer> map = new HashMap<>();
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        set.add("I" + 8);
        linkedHashSet.add("I" + 8);
        map.put("I" + 8, 8);
        linkedHashMap.put("I" + 8, 8);

        for (int i = 0; i < 10; i++) {
            set.add("I" + i);
            linkedHashSet.add("I" + i);
            map.put("I" + i, i);
            linkedHashMap.put("I" + i, i);
        }

        System.out.println("*************HashSet****************");

        for (String i : set) {
            System.out.println(i);
        }

        System.out.println("*************LinkedHashSet****************");

        for (String i : linkedHashSet) {
            System.out.println(i);
        }


        System.out.println("***************HashMap**************");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        System.out.println("*************linkedHashMap****************");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

    }
}
