package com.zhang.pro.w347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author by SUNS3T
 * @Classname Solution
 * @Description TODO
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //建立一个hashmap统计每个元素的出现频率
        Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0)+1);
        }
        //建立一个优先队列，声明是小顶堆
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //分2种情况
        //当小于k时，往里面添加就行了
        //当length == k时，检查堆顶与当前出现次数的大小，如果堆顶大，那么就有K个比堆顶出现次数多的，
        //不需要理会，否则弹出堆顶添加新的
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k){
                if (queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{key, count});
                }
            }else {
                queue.offer(new int[]{key, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
