package com.xkcoding.leetcode.code1;

import java.util.HashMap;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-07-02 13:25
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (cache.containsKey(result)) {
                int position = cache.get(result);
                cache.clear();
                return new int[]{i, position};
            }
            cache.put(nums[i], i);
        }

        throw new RuntimeException();
    }
}
