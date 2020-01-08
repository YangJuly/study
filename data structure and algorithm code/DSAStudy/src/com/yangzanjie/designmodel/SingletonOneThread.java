package com.yangzanjie.designmodel;

/**
 * @author : yangzanjie
 * create at:  2019-11-18  16:29
 * @description: 单例模式-基础-针对单线程
 */
public class SingletonOneThread {
    private static SingletonOneThread instance;
    private SingletonOneThread() {
    }
    public static SingletonOneThread getInstance() {
        if (instance == null) {
            instance = new SingletonOneThread();
        }
        return instance;
    }
}
