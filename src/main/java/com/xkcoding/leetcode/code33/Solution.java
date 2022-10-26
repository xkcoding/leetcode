package com.xkcoding.leetcode.code33;

/**
 * <p>
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-26 16:31
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[] {5, 1, 3}, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 判断中点是否存在旋转
            if (nums[mid] >= nums[left]) {
                // 未旋转，则比较端点
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 发生旋转，则比较中点
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

}