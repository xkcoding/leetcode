package com.xkcoding.leetcode.code1636;

import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // count every number
        Map<Integer, Integer> dataCount = new HashMap<>();
        for (int num : nums) {
            dataCount.put(num, dataCount.getOrDefault(num, 0) + 1);
        }

        List<Integer> sortList = new ArrayList<>();
        for (int num : nums) {
            sortList.add(num);
        }

        // 频率相等，则按数字大小降序排列，否则按评率升序排列
        sortList.sort((o1, o2) ->
                Objects.equals(dataCount.get(o1), dataCount.get(o2)) ? (o2 - o1) : (dataCount.get(o1) - dataCount.get(o2)));

        for (int i = 0; i < sortList.size(); i++) {
            nums[i] = sortList.get(i);
        }

        return nums;
    }
}