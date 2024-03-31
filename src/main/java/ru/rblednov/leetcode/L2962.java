package ru.rblednov.leetcode;

import java.util.*;

public class L2962 {
    public static void main(String[] args) {
        L2962 l2962 = new L2962();
        System.out.println(l2962.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }

    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long counter = 0;
        int start = 0;
        int maxElementsInWindow = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                ++maxElementsInWindow;
            }
            while (maxElementsInWindow == k) {
                if (nums[start] == maxElement) {
                    --maxElementsInWindow;
                }
                ++start;
            }
            counter = counter + (start);
        }
        return counter;
    }
}
