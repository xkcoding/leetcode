package com.xkcoding.leetcode.code23;

import java.util.PriorityQueue;

/**
 * <p>
 * https://leetcode.cn/problems/merge-k-sorted-lists
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-13 13:27
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 通过优先队列，每次取最小的值
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }

        // 虚拟头结点
        ListNode dummyHead = new ListNode();
        // 指针
        ListNode curr = dummyHead;
        while (!queue.isEmpty()) {
            // 取最小的节点加入当前指针的next
            ListNode min = queue.poll();
            curr.next = min;
            // 指针后移
            curr = min;
            // 不为空则将下一个节点加入优先队列
            if (min.next != null) {
                queue.offer(min.next);
            }
        }

        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}