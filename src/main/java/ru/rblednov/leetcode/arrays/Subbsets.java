package ru.rblednov.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subbsets {

    public static List<List<Integer>> subsets(int[] nums) {
        //[1,2,3]
        //[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
        // 0, 1 , 10,  11 ,100, 101 , 110 , 111
        // 0, 1 , 2 ,  3  , 4 ,  5  ,
        //8
        int len = nums.length;
        int power = (int) Math.pow(2, len);
        List<List<Integer>> response = new ArrayList();
        for (int i = 0; i < power; i++) {
            List<Integer> newVal = new ArrayList<>();
            String current = Integer.toBinaryString(i);
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(current.length()-j-1) == '1') {
                    newVal.add(nums[j]);
                }
            }
            response.add(newVal);
        }
        return response;
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }
}
