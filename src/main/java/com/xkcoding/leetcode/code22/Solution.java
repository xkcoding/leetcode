package com.xkcoding.leetcode.code22;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * https://leetcode.cn/problems/generate-parentheses
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-13 13:04
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(8));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generate(List<String> result, StringBuilder curr, int left, int right, int total) {
        // total 表示括号对数
        if (curr.length() == total * 2) {
            result.add(curr.toString());
            return;
        }

        // 左括号不够，增加左括号
        if (left < total) {
            curr.append("(");
            generate(result, curr, left + 1, right, total);
            curr.deleteCharAt(curr.length() - 1);
        }

        // 右括号未全部匹配
        if (right < left) {
            curr.append(")");
            generate(result, curr, left, right + 1, total);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

}