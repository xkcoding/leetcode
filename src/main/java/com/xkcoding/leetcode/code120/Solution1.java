package com.xkcoding.leetcode.code120;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-07-14 12:40
 */
class Solution1 {
    /**
     * 暴力解法，容易超时
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int maxRow = triangle.size();

        return moveToNextRow(0, 0, triangle, maxRow) + triangle.get(0).get(0);
    }

    private int moveToNextRow(int row, int col, List<List<Integer>> triangle, int maxRow) {
        // 设置边界
        if (row >= maxRow - 1) {
            return 0;
        }
        int left = triangle.get(row + 1).get(col) + moveToNextRow(row + 1, col, triangle, maxRow);
        int right = triangle.get(row + 1).get(col + 1) + moveToNextRow(row + 1, col + 1, triangle, maxRow);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3, 4);
        List<Integer> row3 = Arrays.asList(6, 5, 7);
        List<Integer> row4 = Arrays.asList(4, 1, 8, 3);

        List<List<Integer>> triangle = Arrays.asList(row1, row2, row3, row4);
        Solution1 solution = new Solution1();
        System.out.println("solution = " + solution.minimumTotal(triangle));
    }
}