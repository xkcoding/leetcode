package com.xkcoding.leetcode.code19;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-12 16:47
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode curr = dummyHead;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // 出栈
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        // 栈顶元素即为删除节点的前一个节点
        curr = stack.peek();
        curr.next = curr.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode listNode = solution.removeNthFromEnd(head, 1);
        System.out.println(listNode);
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