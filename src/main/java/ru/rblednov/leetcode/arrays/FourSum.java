package ru.rblednov.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer,Integer> hash1= new HashMap<>();
        for (int i1:nums1){
            for(int i2: nums2){
                if(hash1.containsKey(i1+i2)){
                    hash1.put(i1+i2,hash1.get(i1+i2)+1);
                }else {
                    hash1.put(i1+i2,1);
                }
            }
        }

        int response = 0;
        for (int i3:nums3){
            for(int i4: nums4){
                if(hash1.containsKey(-(i3+i4))){
                    response = response + hash1.get(-(i3+i4));
                }
            }
        }

        return response;
    }

    public static void main(String[] args) {
//[1,2]
//[-2,-1]
//[-1,2]
//[0,2]
        int[] nums1 = {0};
        int[] nums2 = {0};
        int[] nums3 = {0};
        int[] nums4 = {0};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
