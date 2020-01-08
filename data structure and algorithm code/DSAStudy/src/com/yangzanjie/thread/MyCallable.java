package com.yangzanjie.thread;

import java.util.concurrent.Callable;

/**
 * @author : yangzanjie
 * create at:  2019-12-11  11:43
 * @description:
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "开始");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "结束");
        //返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}
