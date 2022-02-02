package ru.rblednov.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i])) {
                int j = dict.get(nums[i]);
                return new int[]{i, j};
            }
            dict.put(target - nums[i], i);
        }
//        dict=null;
//        System.gc();
        return new int[]{-1, -1};
    }
}
