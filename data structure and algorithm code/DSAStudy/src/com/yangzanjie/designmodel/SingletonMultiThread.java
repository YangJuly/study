package com.yangzanjie.designmodel;

/**
 * @author : yangzanjie
 * create at:  2019-11-18  16:33
 * @description: 单例模式--双锁--考虑多线程并发
 */
public class SingletonMultiThread {
    private volatile static SingletonMultiThread instance = null;

    private SingletonMultiThread() {
    }

    public static SingletonMultiThread getInstance() {
        if (instance == null)  {    // 尽量避免多次进入同步代码
            synchronized (SingletonMultiThread.class) {
                if (instance == null) {
                    instance = new SingletonMultiThread();
                }
            }
        }
        return instance;
    }
}
