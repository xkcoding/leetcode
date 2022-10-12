package com.xkcoding.leetcode.code20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * https://leetcode.cn/problems/valid-parentheses
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-12 17:03
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> mapping = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (!mapping.containsKey(curr)) {
                // 边界判断，第一个就不匹配，则栈为空
                // 比较当前元素是否和栈顶元素匹配，匹配弹出栈顶元素，不匹配，直接失败
                if (stack.isEmpty() || mapping.get(stack.peek()) != curr) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}