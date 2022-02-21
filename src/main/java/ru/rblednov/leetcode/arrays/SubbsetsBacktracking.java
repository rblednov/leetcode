package ru.rblednov.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubbsetsBacktracking {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        LinkedList<Integer> stepResponse = new LinkedList<>();
        backtrack(response, stepResponse, nums, 0);
        return response;
    }

    //[1,2,3]
    //[1],[1,2],[1,2,3],[1,3]
    //[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
    private static void backtrack(List<List<Integer>> response, LinkedList<Integer> stepResponse, int[] nums, int k) {
        response.add(List.copyOf(stepResponse));
        for (int i = k; i < nums.length; i++) {
            stepResponse.addLast(nums[i]);
            backtrack(response, stepResponse, nums, i + 1);
            stepResponse.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{}));
    }
}
