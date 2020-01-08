package com.yangzanjie.dynamicproxy;

/**
 * @author : yangzanjie
 * create at:  2019-11-20  15:28
 * @description: 动态代理测试
 */
public class DynamicProxtTest {
    public static void main(String[] args) {
        PeopleProxy peopleProxy = new PeopleProxy();
        People teacher = (People) peopleProxy.newProxyInstance(new Teacher());
        teacher.speak();
    }
}
