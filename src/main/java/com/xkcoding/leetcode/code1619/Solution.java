package com.xkcoding.leetcode.code1619;

import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        // 排序
        Arrays.sort(arr);
        int count=0;
        // 不需要参与计算的数据量
        int removeFlag = (int) (arr.length * 0.05);
        for (int i = removeFlag; i < (arr.length-removeFlag); i++) {
            count+=arr[i];
        }
        // 两头减少0.05 剩下就是 0.9
        return count / (arr.length * 0.9);
    }
}