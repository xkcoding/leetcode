package com.xkcoding.leetcode.code5;

/**
 * <p>
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-10 17:44
 */
class Solution {
    public String longestPalindrome(String s) {
        // 边界检查
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        // 只要不为空串，最长子串最短就为 1
        int maxSubLen = 1;
        int subStart = 0;

        for (int i = 0; i < len; i++) {
            // 每次循环，初始化指针位置和子串长度
            int left = i - 1, right = i + 1, subLen = 1;
            // 左边指针左移，找到与当前位置字符不同的为止
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
                subLen++;
            }

            // 右边边指针右移，找到与当前位置字符不同的为止
            while (right < len && s.charAt(i) == s.charAt(right)) {
                right++;
                subLen++;
            }

            //左右同时移动
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                subLen += 2;
            }

            if (subLen >= maxSubLen) {
                maxSubLen = Math.max(maxSubLen, subLen);
                // left 会递减到-1，所以起始位置要补全回来
                subStart = left + 1;
            }
        }

        return s.substring(subStart, subStart + maxSubLen);
    }

}
