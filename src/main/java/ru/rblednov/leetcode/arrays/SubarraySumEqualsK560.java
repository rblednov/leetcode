package ru.rblednov.leetcode.arrays;

public class SubarraySumEqualsK560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int lb=0;
            int rb=0;
            int sum=0;
            int response =0 ;
            while(true){
                if(sum<k){
                    if(rb<nums.length){
                        rb=rb+1;
                        sum = sum+nums[rb];
                    }
                    return 0;
                } else {

                }
            }
        }
    }
}
