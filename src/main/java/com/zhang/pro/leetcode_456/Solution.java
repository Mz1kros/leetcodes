package com.zhang.pro.leetcode_456;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author by SUNS3T
 * @Classname Solution
 * @Description TODO
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        int last = Integer.MIN_VALUE; //2
        if (nums.length < 3){
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();//用来存储132中的3
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < last){
                return true;
            }
            // 若当前值大于或等于2则更新2
            while (!stack.isEmpty() && stack.peek() < nums[i]){
                last = stack.poll();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
