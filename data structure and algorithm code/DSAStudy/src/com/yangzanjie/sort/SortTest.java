package com.yangzanjie.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  14:17
 * @description: 测试排序算法
 */
public class SortTest {

    /**
     * 产生值随机在[min, max)之间，长度为length的数组
     * @param min
     * @param max
     * @param length
     * @return
     */
    public static int[] generate(int min, int max, int length) {
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = (int)(Math.random() * (max - min) + min);
        }
        return res;
    }

    /**
     * 调用cla的排序算法，并打印出消耗的时间
     * @param cla
     * @param arr
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static void sort(Class cla, int[] arr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method sortMethod = cla.getMethod("sort", int[].class);

        long start = System.nanoTime();
        sortMethod.invoke(cla.getConstructor().newInstance(), arr);
        long end = System.nanoTime();

        System.out.println("Method " + cla.getName() + " spend time: " + (end -  start) +  "  nanoseconds");
    }

    /**
     * 打印数组的所有数字
     * @param arr
     */
    public static void printArr(int[] arr) {
        System.out.println();
        System.out.println("********start*******");
        for(int i : arr) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.println("*********end**********");
        System.out.println();
    }

    /**
     * 检查数组是否升序排列
     * @param arr
     * @return
     */
    public static boolean checkArrAsc(int[] arr) {
        int end = arr.length -  1;
        for (int i = 0; i < end; i++)  {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException,
            InstantiationException {
        int[] arr = generate(0, 10000, 100000);
//        printArr(arr);
        System.out.println(checkArrAsc(arr));
        System.out.println("\n");

        int[] arrBubble = arr.clone();
        sort(BubbleSort.class, arrBubble);
//        printArr(arrBubble);
        System.out.println(checkArrAsc(arrBubble));
        System.out.println();

        int[] arrInsertion = arr.clone();
        sort(InsertionSort.class, arrInsertion);
//        printArr(arrInsertion);
        System.out.println(checkArrAsc(arrInsertion));
        System.out.println();

        int[] arrSelector = arr.clone();
        sort(SelectSort.class, arrSelector);
//        printArr(arrSelector);
        System.out.println(checkArrAsc(arrSelector));
        System.out.println();

        int[] arrShells =  arr.clone();
        sort(ShellsSort.class, arrShells);
//        printArr(arrShells);
        System.out.println(checkArrAsc(arrShells));
        System.out.println();
    }
}
