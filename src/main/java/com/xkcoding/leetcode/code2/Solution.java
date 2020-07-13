package com.xkcoding.leetcode.code2;

/**
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 * {@code 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807}
 *
 * @author yangkai.shen
 * @date Created in 2020-07-02 13:32
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cache = result;
        // 进位标记
        int x = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + x;

            x = sum / 10;
            sum = sum % 10;

            cache.next = new ListNode(sum);

            cache = cache.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (x == 1) {
            cache.next = new ListNode(x);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        four.next = three;
        ListNode two = new ListNode(2);
        two.next = four;

        ListNode four2 = new ListNode(4);
        ListNode six = new ListNode(6);
        six.next = four2;
        ListNode five = new ListNode(5);
        five.next = six;

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(two, five);
        System.out.println("listNode = " + listNode);
    }


}


