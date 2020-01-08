package com.yangzanjie.dynamicproxy;

/**
 * @author : yangzanjie
 * create at:  2019-11-20  15:36
 * @description:
 */
public class Teacher implements People{
    @Override
    public void speak() {
        System.out.println("我是老师，教书育人是我的工作。");
    }
}
