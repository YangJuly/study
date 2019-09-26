package com.yangzanjie.heap;

import java.util.PriorityQueue;

/**
 * @author : yangzanjie
 * create at:  2019-09-19  19:25
 * @description: 利用优先级队列合并K个有序队列
 */
public class MergeKOrderedArrays {


    public static int[] merge(int[][] numArrays) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        for (int[] nums : numArrays) {
            for (int i : nums) {
                priorityQueue.add(i);
            }
        }

        int[] result = new int[priorityQueue.size()];
        for (int i=0; i < result.length; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = {2,3,5,9,11,12};
        int[] nums3 = {4,5,6,7,8,100};

        int[][] nums = {nums1, nums2, nums3};

        int[] result = merge(nums);
        for (int i:result) {
            System.out.println(i);
        }
    }
}
