package com.xkcoding.leetcode.mock.redbook.mock01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 三数之和
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-11-01 21:25
 */
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 第一个数不能大于 0
            if (nums[i] > 0) {
                break;
            }

            // 去除相同的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 接下来就是两数之和
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // 去除相同的数
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