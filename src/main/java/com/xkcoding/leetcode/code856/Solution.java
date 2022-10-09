package com.xkcoding.leetcode.code856;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * https://leetcode.cn/problems/score-of-parentheses/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-09 15:15
 */
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (char idx : s.toCharArray()) {
            if (idx == '(') {
                stack.push(0);
            } else {
                Integer top = stack.pop();
                // 栈顶元素为 0，则代表是() ==> 1，否则 ==> 2*top
                if (top == 0) {
                    top = 1;
                } else {
                    top = 2 * top;
                }
                // 累加后的值为新的栈顶元素
                stack.push(stack.pop() + top);
            }
        }

        return stack.peek();
    }
}