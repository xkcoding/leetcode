package com.xkcoding.leetcode.code17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2022-10-12 16:19
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> mapping = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        combine(result, mapping, digits, 0, new StringBuilder());

        return result;
    }

    private void combine(List<String> result, Map<Character, String> mapping, String digits, int index, StringBuilder tempData) {
        // 边界
        if (index == digits.length()) {
            result.add(tempData.toString());
            return;
        }

        String mappingString = mapping.get(digits.charAt(index));
        for (int i = 0; i < mappingString.length(); i++) {
            tempData.append(mappingString.charAt(i));

            combine(result, mapping, digits, index + 1, tempData);

            // 移除当前新增字符，为了下次循环可以新增下个字符
            tempData.deleteCharAt(index);
        }

    }
}