package com.yangzanjie.queue;

/**
 * @author : yangzanjie
 * create at:  2019-09-14  11:00
 * @description: 队列测试类
 */
public class QueueTest {
    public static void main(String[] args) {
        /* test 基于数组实现的顺序队列
        ArrayQueue arrayQueue =  new ArrayQueue(3);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        //arrayQueue   1 -> 2 -> 3
        System.out.println(arrayQueue.dequeue()); //1

        arrayQueue.enqueue(4);

        //arrayQueue 2 -> 3 -> 4
        System.out.println(arrayQueue.dequeue()); //2
        System.out.println(arrayQueue.dequeue()); //3
        System.out.println(arrayQueue.dequeue()); //4
        */

        /* test 基于单链表实现的链式队列 */
        LinkedQueue linkedQueue = new LinkedQueue(3);
        linkedQueue.enqueue(1 + "");
        linkedQueue.enqueue(2 + "");
        linkedQueue.enqueue(3 + "");
        linkedQueue.enqueue(4 + "");

        //linkedQueue 1 -> 2 -> 3

        System.out.println(linkedQueue.dequeue()); //1
        System.out.println(linkedQueue.dequeue()); //2

        linkedQueue.enqueue(4+"");
        linkedQueue.enqueue(5+"");
        linkedQueue.enqueue(6+"");

        //linkedQueue 3 -> 4 -> 5

        System.out.println(linkedQueue.dequeue()); //3
        System.out.println(linkedQueue.dequeue()); //4
        System.out.println(linkedQueue.dequeue()); //5
        System.out.println(linkedQueue.dequeue()); //null


    }
}
