//我们提供一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2: 
//
// 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
//
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFoobarAlternately{
    public static void main(String[] args) {

    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class FooBar {
    private int n;

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    volatile boolean fin = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            //fin=true才能通过
            while (!fin);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fin = false;
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {

            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fin = true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}