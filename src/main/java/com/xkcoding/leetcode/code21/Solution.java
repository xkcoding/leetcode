package com.xkcoding.leetcode.code21;

/**
 * <p>
 * https://leetcode.cn/problems/merge-two-sorted-lists
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-12 17:39
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        merge(dummyHead, list1, list2);
        return dummyHead.next;
    }

    private void merge(ListNode curr, ListNode list1, ListNode list2) {
        // 任一链表为空，则另一个链表直接接上
        if (list1 == null) {
            curr.next = list2;
            return;
        }

        if (list2 == null) {
            curr.next = list1;
            return;
        }

        if (list1.val < list2.val) {
            curr.next = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            curr.next = new ListNode(list2.val);
            list2 = list2.next;
        }

        curr = curr.next;
        merge(curr, list1, list2);
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