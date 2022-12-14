package com.xkcoding.leetcode.interview0803;

/**
 * <p>
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-07-31 18:53
 */
class Solution2 {
    // 二分剪枝
    public int findMagicIndex(int[] nums) {
        return findIndex(nums, 0, nums.length - 1);
    }

    private int findIndex(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        int leftIndex = findIndex(nums, 0, mid - 1);
        if (leftIndex != -1) {
            return leftIndex;
        } else if (nums[mid] == mid) {
            return mid;
        }

        return findIndex(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
    }
}