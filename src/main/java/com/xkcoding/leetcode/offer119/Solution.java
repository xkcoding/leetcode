package com.xkcoding.leetcode.offer119;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>
 * https://leetcode.cn/problems/WhsWhI/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-11-01 20:36
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int result = 0;

        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else {
                int data = stack.peek();
                if (nums[i] == data) {
                    continue;
                } else if (nums[i] == (data + 1)) {
                    stack.push(nums[i]);
                } else {
                    result = Math.max(result, stack.size());
                    stack.clear();
                    stack.push(nums[i]);
                }
            }
        }

        return Math.max(result, stack.size());
    }
}