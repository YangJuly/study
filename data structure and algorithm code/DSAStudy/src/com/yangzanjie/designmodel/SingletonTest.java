package com.yangzanjie.designmodel;

public enum SingletonTest {
    SINGLETON_TEST;
    public static SingletonTest getSingleton() {
        return SINGLETON_TEST;
    }
}

