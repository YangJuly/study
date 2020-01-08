package com.yangzanjie.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : yangzanjie
 * create at:  2019-12-04  13:54
 * @description:
 */
public class ThreadSample {

    public static int countNum = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("main start");
        runnableSample();
        callableSample();
        System.out.println("main end");
        System.out.println("spent time: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void callableSample() {
        System.out.println("callable main thread begin...");

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("callable begin...");
                Thread.sleep(10000);
                System.out.println("callable end.");

                return "success";
            }
        };

        // FutureTask可以获取线程的执行情况，也可取消线程的执行
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // 也可使用线程池 ThreadPoolTaskExecutor.execute(Runnable task, long startTimeout) 方法启动线程
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Thread.sleep(500);
            System.out.println("callable main thread sleep 500ms");
            // 该方法是阻塞的，会等待线程执行完才会返回结果
//            String result = futureTask.get();

            futureTask.run();
            System.out.println("futureTask result=" + null);
        } catch (InterruptedException e) {
            // 记录异常日志
        }
//        catch (ExecutionException e) {
//            // 记录异常日志
//        }

    }

    public static void runnableSample() {
        System.out.println("runnable main thread begin...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable begin...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // 记录异常日志
                }
                System.out.println("runnable end.");
            }
        };

        // 也可使用线程池 ThreadPoolTaskExecutor.execute(Runnable task, long startTimeout) 方法启动线程
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("runnable main thread end.");
    }
}
