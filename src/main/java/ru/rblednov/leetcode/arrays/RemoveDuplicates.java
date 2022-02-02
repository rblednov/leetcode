package ru.rblednov.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::println);

    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int j = 0;
        int current = nums[0];
        for(int i = 0;i<nums.length;i++){
            if(current!=nums[i]){
                j = j+1;
                nums[j] = nums[i];
            }
            current = nums[i];
        }
        return j+1;
    }
}
