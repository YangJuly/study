package com.demo.set;

/**
 * @author : yangzanjie
 * create at:  2019-12-13  15:21
 * @description:
 */
public class SetTest {

    private int count;

    public SetTest() {

    }

    public SetTest(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SetTest{" +
                "count=" + count +
                '}';
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
