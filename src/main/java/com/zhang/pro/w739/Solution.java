package com.zhang.pro.w739;

import java.util.Stack;

/**
 * @author by SUNS3T
 * @Classname Solution
 * @Description TODO
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        //stack存储的是index而不是值
        Stack<Integer> stack = new Stack<Integer>();
        int[] aq = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                int res =  stack.pop();
                aq[res] = i - res;
            }
            stack.add(i);
        }
        return aq;
    }
}
