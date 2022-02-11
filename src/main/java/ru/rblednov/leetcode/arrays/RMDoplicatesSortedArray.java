package ru.rblednov.leetcode.arrays;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RMDoplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {

        int current = 0;
        int prev = -10001;
        int inARow = 1;
        int newPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];

            if (current == prev) {
                inARow++;
                if (inARow <= 2) {
                    nums[newPosition] = nums[i];
                    newPosition++;
                }
            } else {
                inARow = 1;
                nums[newPosition] = nums[i];
                newPosition++;

            }

            prev = current;
        }
        return newPosition;

    }

    public static void main(String[] args) {
    }
}
