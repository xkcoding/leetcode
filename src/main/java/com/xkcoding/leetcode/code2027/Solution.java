package com.xkcoding.leetcode.code2027;

/**
 * https://leetcode.cn/problems/minimum-moves-to-convert-string/
 *
 * @author Yangkai.Shen
 * @date Created in 2022/12/27 11:27
 */
class Solution {
    public int minimumMoves(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                i += 2;
                ret++;
            }
        }
        return ret;
    }
}