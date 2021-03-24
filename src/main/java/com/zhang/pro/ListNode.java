package com.zhang.pro;

/**
 * @author by SUNS3T
 * @Classname ListNode
 * @Description TODO
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
