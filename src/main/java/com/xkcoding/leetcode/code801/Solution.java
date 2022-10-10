package com.xkcoding.leetcode.code801;

/**
 * <p>
 * https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-10 11:06
 */
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        // 满足严格递增：每个数组当前位置的数一定比当前位置-1的数大 --> (nums1[i] > nums1[i - 1]) && (nums2[i] > nums2[i - 1])
        // 交换：A数组当前位置交换的数一定比B数组当前位置-1的数大 --> (nums1[i] > nums2[i - 1]) && (nums2[i] > nums1[i - 1])
        int length = nums1.length;
        int f0 = 0, f1 = 1;

        for (int i = 1; i < length; i++) {
            int a = f0, b = f1;
            // 初始化次数为数组长度
            f0 = f1 = length;
            // 要么不替换、要么都替换
            if ((nums1[i] > nums1[i - 1]) && (nums2[i] > nums2[i - 1])) {
                f0 = Math.min(f0, a);
                f1 = Math.min(f1, b + 1);
            }

            // 要么替换当前位置，要么替换当前位置-1
            if ((nums1[i] > nums2[i - 1]) && (nums2[i] > nums1[i - 1])) {
                f0 = Math.min(f0, b);
                f1 = Math.min(f1, a + 1);
            }

        }

        return Math.min(f0, f1);
    }
}