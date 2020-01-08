package com.yangzanjie.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author : yangzanjie
 * create at:  2019-11-22  16:41
 * @description: 线程测试类
 */
public class ThreadTest {
    public static void main(String[] args) {
        //1
//        for (int i = 0; i < 5; i++) {
//            Sing sing = new Sing();
//            sing.run();
//        }
        //2
        Runnable runnable = () -> System.out.println("hello world");
        try {
            Thread thread = new Thread(runnable);
            thread.run();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3
        try {
            Executors.newFixedThreadPool(1)
                    .submit(runnable)
                    .get();
        } catch (ExecutionException e) {

        } catch (InterruptedException e) {

        }

    }
}

/**
 * 通过集成Thread类创建线程
 */
class Sing extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("我是线程：" + this.getName());
                System.out.println("我在唱歌 " + i);
                System.out.println("我很快乐");
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
            //do nothing
            e.printStackTrace();
        }
    }
}
