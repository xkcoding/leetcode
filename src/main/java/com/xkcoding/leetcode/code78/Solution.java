package com.xkcoding.leetcode.code78;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(new int[]{0});
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        f(0, nums, new ArrayList<>(), finalList);
        return finalList;
    }

    public void f(int i, int[] nums, List<Integer> temp, List<List<Integer>> finalList) {
        ArrayList<Integer> arr1 = new ArrayList<>(temp);

        if (i == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int item : arr1) {
                list.add(nums[item]);
            }

            finalList.add(list);
            return;
        }

        f(i + 1, nums, arr1, finalList);
        arr1.add(i);
        f(i + 1, nums, arr1, finalList);
    }

}