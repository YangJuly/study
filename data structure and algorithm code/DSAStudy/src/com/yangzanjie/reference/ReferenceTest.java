package com.yangzanjie.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author : yangzanjie
 * create at:  2019-11-20  11:10
 * @description: test
 */
public class ReferenceTest {
    public static void main(String[] args) {
        String str = new String("test");
        String str2 = new String("test2");
        ReferenceQueue rq = new ReferenceQueue();
        //虚引用
        PhantomReference pr = new PhantomReference(str, rq);
        PhantomReference pr2 = new PhantomReference(str2, rq);
        System.out.println(pr.get());
        str = null;
        str2 = null;

        System.out.println(str);
        System.gc();
        System.runFinalization();

        System.out.println(rq.poll() == pr);
    }
}
