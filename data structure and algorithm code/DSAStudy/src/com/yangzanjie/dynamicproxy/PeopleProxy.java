package com.yangzanjie.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : yangzanjie
 * create at:  2019-11-20  15:31
 * @description: People的代理类
 */
public class PeopleProxy implements InvocationHandler {
    private Object targetObject;

    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法开始");
        Object res = method.invoke(targetObject, args);
        System.out.println("方法结束");
        return res;
    }
}
