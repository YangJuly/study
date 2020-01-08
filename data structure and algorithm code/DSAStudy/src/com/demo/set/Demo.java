package com.demo.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : yangzanjie
 * create at:  2019-12-13  15:22
 * @description:
 */
public class Demo {
    public static void main(String[] args) {
        SetTest setTest1 = new SetTest(1);
        SetTest setTest2 = new SetTest(2);
        SetTest setTest3 = new SetTest(3);
        SetTest setTest0 = new SetTest(0);

        HashSet<SetTest> set = new HashSet<>();

        System.out.println(set.size());
        set.add(setTest0);
        set.add(setTest1);
        set.add(setTest2);
        set.add(setTest3);
        System.out.println(set.size());
        for (SetTest test : set) {
            System.out.println(test.toString());
        }

    }
}
