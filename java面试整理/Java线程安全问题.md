## Java线程安全问题

#### 1.what-什么是线程安全问题，怎么导致的？

从线程模型谈：

code 为例，最后count值大概率不为1000*100

```java
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
```

从计算机原理谈：

1. ```markdown
   数据的读写
   缓存设计：   Cache（cpu高速缓存）--内存--磁盘。
   数据IO效率，   高--一般--慢
   CPU执行指令:
   	1.先查询Cache是否有该数据，若有，则直接使用，若无，则从内存取，并复制到Cache中；
   	2.执行完后的数据，放到Cache中，然后从Cache刷新到内存中。
   多核CPU，每一核有对应的Cache（单CPU，参考线程模型），并发下，存在数据不一致情形（这个好解释，略）。
   ```



#### 2. 谈谈Java线程安全常用的Volatile、Synchronized

Volatile：

- 可见性

  每次读取数据，都从内存中读取。（多线程时，不从自己的线程空间读）

- 有序性

  虚拟机，在编译时，不对其进行优化，保证其顺序执行。

但是，存在问题：

- 不满足原子性

  对数据的操作过程中，会被打断。



Synchronized

```java
synchronized (object) {

}

public synchronized void test() {
  
}
```

​	锁机制，保证操作原子性。





实质都是对对象加锁。

锁对象

对象在内存中的存储结构：

1. 对象头（包含锁信息）
2. 实例数据
3. 填重数据



锁机制

- 偏向锁
- 轻量级锁
- 重量级锁

```markdown
1. 偏向锁，偏向于第一个获得的线程，如果不存在竞争，则偏向锁保持;
2. 若存在竞争，则撤销偏向锁，升级为轻量级锁；
3. 轻量级锁，即另一个线程来竞争时，该线程会循环等待，而不是阻塞，
4. 轻量级锁，采用自旋机制，包括自旋锁、自适应自旋锁。
5. 轻量级锁，适用于同步处理快速场景，若同步处理耗时长，自旋次数超过阈值，则升级为重量级锁
6. 重量级锁（互斥锁、阻塞同步、悲观），即另一个线程来竞争时，该线程阻塞，当然对应的有唤醒机制，
7. 因为这俩操作都是操作系统提供，伴随【用户态】<->【内核态】的切换，十分耗时。
```





#### 4. 谈谈CAS操作

compareAndSet，保证原子操作，对应一条硬件操作指令，底层各个操作系统（不同硬件）不同。

- 非阻塞

- 内存值K，原先预估值A，目标值V

  若K=A，则修改K为V，

  若不等，则不能修改

- 存在ABA

  因此，引入版本控制方法。AtomicStampedReference类

- Java8的优化

  如果进入cas操作的线程太多，会引起重复循环，浪费CPU的问题。

  引入分组法。



Java的concurrent包中的基础类都是使用这种模式来实现。

<img src="/Users/yangzanjie/code/study/java面试整理/线程问题--CAS-AQS-Concurrent.png" alt="线程问题--CAS-AQS-Concurrent" style="zoom:50%;" />



#### 5. 谈谈synchronize和ReentrantLock

synchronized涉及到偏向锁、轻量级锁、重量级锁等，通过对象内部的监视器锁monitor实现。

ReentrantLock等java.util.*下的lock，使用的是ABS。



从使用上：

从特性上;

注意事项：

以上已有叙述。