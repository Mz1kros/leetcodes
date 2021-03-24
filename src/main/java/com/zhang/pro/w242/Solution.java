package com.zhang.pro.w242;

import java.util.Arrays;

/**
 * @author by SUNS3T
 * @Classname Solution
 * @Description TODO
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }
}
