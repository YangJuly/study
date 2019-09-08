package com.yangzanjie.array;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  14:52
 * @description: 数组测试类
 */
public class ArrayTest {
    public static void main(String[] args) {
        DynamicArrray dynamicArrray = new DynamicArrray();

        /***************************** Test  DynamicArrray **********************************/

        System.out.println("Step1 insert [0,4] ");
        for (int i = 0; i < 5; i++) {
            dynamicArrray.add(i + "");
        }
        dynamicArrray.printAll();

        System.out.println("Step2 insert [5,9] ");
        for (int i = 5; i < 10; i++) {
            dynamicArrray.add(i + "");
        }
        dynamicArrray.printAll();

        System.out.println("Step3 insert 10 ");
        dynamicArrray.add(10 + "");
        dynamicArrray.printAll();

        /***************************** Test  OrderedFixedSizeArray **********************************/

        OrderedFixedSizeArray orderedFixedSizeArray = new OrderedFixedSizeArray();
        System.out.println("Step1 insert [5, 1] ");
        for (int i = 0; i < 5; i++) {
            if (!orderedFixedSizeArray.add(5-i)) {
                System.out.println("insert failed");
            }
        }
        orderedFixedSizeArray.printAll();

        System.out.println("Step2 insert 6 ");
        if (!orderedFixedSizeArray.add(6)) {
            System.out.println("insert failed");
        }

        System.out.println("Step3 delete index 2 and then insert 6 ");
        if (!orderedFixedSizeArray.delete(2)) {
            System.out.println("delete index 2 failed");
        }
        if (!orderedFixedSizeArray.add(6)) {
            System.out.println("insert failed");
        }
        orderedFixedSizeArray.printAll();


        /***************************** Test  MergeTwoOrderedArray **********************************/
        int[] arrayOne = {1,2,3,4,5,6};
        int[] arrayTwo = {3,4,5,8,9,10};
        int[] result = MergeTwoOrderedArray.merge(arrayOne, arrayTwo);
        System.out.println();
        for (int i : result) {
            System.out.print( i + " -> ");
        }
        System.out.println();


    }
}
