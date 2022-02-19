package ru.rblednov.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
    // 1 1 2 -3 1 2 -2 1 0 3 // 3
    // 1 2 4  1 2 4  2 3 3 6 // 3

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int response = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            response = response + hashMap.getOrDefault(sum - k, 0);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return response;
    }


    public static void main(String[] args) {
        System.out.println("b".getBytes()[0]^"b".getBytes()[0]);
    }
}
