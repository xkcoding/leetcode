package com.xkcoding.leetcode.code15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * https://leetcode.cn/problems/3sum/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-12 15:38
 */
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 当前数大于 0，总和一定大于 0
            if (nums[i] > 0) {
                break;
            }

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // 和大于0，右指针左移
                    right--;
                } else if (sum < 0) {
                    // 和小于0，左指针右移
                    left++;
                } else {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}