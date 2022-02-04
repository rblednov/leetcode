package ru.rblednov.leetcode.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {

        int index = 0;
        int response = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index--;
            } else {
                index++;
            }
            Integer leftIndex = map.get(index);
            if(leftIndex==null){
                map.put(index, i);
            }else {
                int newResponse = i-leftIndex;
                if(newResponse>response){
                    response = newResponse;
                }
            }
        }

        return response;
    }

    public static void main(String[] args) {

        System.out.println(findMaxLength(new int[]{0,1}));
    }
}
//0**0*00*0*******00**
//001010010001001001010001111000101
//
//новый элем это либо +2 либо +0
//