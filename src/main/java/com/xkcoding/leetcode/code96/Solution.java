package com.xkcoding.leetcode.code96;

/**
 * <p>
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-07-15 19:35
 */
class Solution {
    public int numTrees(int n) {
        int[] root = new int[n + 1];
        root[0] = 1;
        root[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                root[i] += root[j - 1] * root[i - j];
            }
        }

        return root[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 5; i++) {
            System.out.println(solution.numTrees(i));
        }
    }
}