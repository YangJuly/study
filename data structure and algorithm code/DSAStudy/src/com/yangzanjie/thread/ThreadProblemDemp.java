package com.yangzanjie.thread;

/**
 * @author : yangzanjie
 * create at:  2019-11-30  13:33
 * @description: 线程问题test
 */
public class ThreadProblemDemp {
    private static int count = 0;
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int j = 0; j < 1000; j++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "count = " + count);
            }
        };

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(count);
    }
}
