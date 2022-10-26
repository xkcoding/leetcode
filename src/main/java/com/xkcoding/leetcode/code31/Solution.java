package com.xkcoding.leetcode.code31;

/**
 * <p>
 * https://leetcode.cn/problems/next-permutation/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-26 15:48
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //        solution.nextPermutation(new int[] {4, 2, 0, 2, 3, 2, 0});
        solution.nextPermutation(new int[] {1, 2, 3, 2, 1});
    }

    public void nextPermutation(int[] nums) {
        int left = nums.length - 2, right = nums.length - 1;

        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left >= 0) {
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }
            // 两数交换
            swap(nums, left, right);
        }

        // 对刚交换的大数后面的数排序
        order(nums, left + 1);

    }

    private void order(int[] nums, int idx) {
        for (int i = idx; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}