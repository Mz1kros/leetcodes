package com.zhang.pro.w239;

import java.util.LinkedList;

/**
 * @author by SUNS3T
 * @Classname Solution
 * @Description TODO
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> linkedList = new LinkedList();
        // 结果数组
        int[] res = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]){
                linkedList.pollLast();
            }
            // 添加当前值对应的数组下标
            linkedList.addLast(i);
            // 判断当前队列中队首的值是否有效,队首储存的下标应该在滑动窗口的范围内
            if (linkedList.peek() <= i - k)
                linkedList.poll();
            // 当窗口长度为k时 保存当前窗口中最大值,双端队列的头每次都是最大的
            if (i + 1 >= k)
                res[i+1-k] = nums[linkedList.peek()];
        }
        return res;
    }
}
