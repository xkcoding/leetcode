package com.xkcoding.leetcode.code350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-07-13 23:45
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 假定前面的数组长度小于后面的数组，节省空间
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> cache = new HashMap<>(nums1.length);
        for (int num : nums1) {
            Integer times = cache.getOrDefault(num, 0);
            cache.put(num, times + 1);
        }

        int[] result = new int[nums1.length];
        int pos = 0;
        for (int num : nums2) {
            Integer times = cache.getOrDefault(num, 0);
            if (times > 0) {
                result[pos++] = num;
                times--;
                if (times > 0) {
                    cache.put(num, times);
                } else {
                    cache.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(result, 0, pos);
    }
}