package com.xkcoding.leetcode.code11;

/**
 * <p>
 * https://leetcode.cn/problems/container-with-most-water/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-12 15:25
 */
class Solution {
    public int maxArea(int[] height) {
        // 初始化双指针
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // 下标从 0 开始，所以长就是下标做差即可
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            // 每次移动短板
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}