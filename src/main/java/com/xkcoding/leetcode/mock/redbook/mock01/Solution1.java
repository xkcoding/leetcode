package com.xkcoding.leetcode.mock.redbook.mock01;

import java.util.Arrays;

class Solution1 {
    public int arrayPairSum(int[] nums) {
        // 排序后，从前到后取数即可
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result += nums[i];
            }
        }

        return result;
    }
}