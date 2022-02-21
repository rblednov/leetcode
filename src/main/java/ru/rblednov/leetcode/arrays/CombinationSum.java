package ru.rblednov.leetcode.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> response = new LinkedList<>();
        LinkedList<Integer> stepResponse = new LinkedList<>();
        int sum = 0;

        backtrack(response, stepResponse, candidates, target, 0, 0);
        return response;
    }

    public static void backtrack(List<List<Integer>> response, LinkedList<Integer> stepResponse, int[] candidates, int target, int sum, int k) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            response.add(List.copyOf(stepResponse));
            return;
        }
        for (int i = k; i < candidates.length; i++) {
            stepResponse.add(candidates[i]);
            sum = sum + candidates[i];
            backtrack(response, stepResponse, candidates, target, sum, i);
            sum = sum - candidates[i];
            stepResponse.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "123";
        s.chars();
        s=s.replaceFirst(String.valueOf('2'),"");
        System.out.println(s);
        System.out.println(combinationSum(new int[]{1,7}, 7));
    }
}
