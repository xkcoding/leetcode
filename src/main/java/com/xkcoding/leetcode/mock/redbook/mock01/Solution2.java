package com.xkcoding.leetcode.mock.redbook.mock01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestConsecutive(new int[] {1, 2, 0, 1}));
    }

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