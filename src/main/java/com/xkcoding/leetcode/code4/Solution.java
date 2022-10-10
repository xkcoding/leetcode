package com.xkcoding.leetcode.code4;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * <p>
 * 参考题解三：https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 *
 * @author yangkai.shen
 * @date Created in 2020-07-13 11:55
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKthData(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKthData(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKthData(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKthData(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 二分法找剩余数组的中间下标
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            // 舍弃 nums2[j] 之前的数据，k 值同步减少
            return getKthData(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            // 舍弃 nums1[i] 之前的数据，k 值同步减少
            return getKthData(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}