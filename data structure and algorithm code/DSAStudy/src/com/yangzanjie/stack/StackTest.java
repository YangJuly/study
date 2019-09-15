package com.yangzanjie.stack;

/**
 * @author : yangzanjie
 * create at:  2019-09-09  20:39
 * @description: 栈的测试类
 */
public class StackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1+"");
        arrayStack.push(2+"");
        arrayStack.push(3+"");
        arrayStack.push(4+"");
        System.out.println(arrayStack.poll());


        LinkedStack linkedStack = new LinkedStack(3);
        linkedStack.push(1+"");
        linkedStack.push(2+"");
        linkedStack.push(3+"");
        linkedStack.push(4+"");
        linkedStack.poll();
        linkedStack.poll();
        linkedStack.poll();
        linkedStack.push(5+"");
        System.out.println(linkedStack.poll());

        BrowserFBBasedSrtack browserFBBasedSrtack = new BrowserFBBasedSrtack();
        //模拟访问页面A
        browserFBBasedSrtack.access("A");
        //模拟访问页面B
        browserFBBasedSrtack.access("B");
        //模拟访问页面C
        browserFBBasedSrtack.access("C");
        //模拟访问页面D
        browserFBBasedSrtack.access("D");

        String web = browserFBBasedSrtack.back();
        System.out.println(web); //C

        web = browserFBBasedSrtack.back();
        System.out.println(web); //B

        web = browserFBBasedSrtack.back();
        System.out.println(web); //null

        browserFBBasedSrtack.access("E");

        web = browserFBBasedSrtack.forward();
        System.out.println(web); //B

        web = browserFBBasedSrtack.forward();
        System.out.println(web); //C

        web = browserFBBasedSrtack.forward();
        System.out.println(web); //D
    }
}
