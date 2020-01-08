//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {7,6,5,4,3,2,1};
        System.out.println(solution.findKthLargest(nums, 2));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //堆
    public int findKthLargest2(int[] nums, int k) {
       PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
       for (int i : nums) {
           queue.add(i);
           if (queue.size() > k) {
               queue.poll();
           }
       }
       return queue.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quickFind(nums, 0, nums.length - 1, target);
    }

    private int quickFind(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];
        int p = partition(nums, start, end);
        if (p == k) return nums[p];
        else if (p < k) return quickFind(nums, p + 1, end, k);
        else return quickFind(nums, start, p - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int i = start;
        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = start + random_num.nextInt(end - start);
        swap(nums, pivot_index, end);
        int pivot = nums[end];
        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }


    }
//leetcode submit region end(Prohibit modification and deletion)

}