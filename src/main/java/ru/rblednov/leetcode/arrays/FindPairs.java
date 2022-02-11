package ru.rblednov.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairs {
    public static int findPairs(int[] nums, int k) {

        int response = 0;
        if(k==0){
            Map<Integer, Boolean> mapNums = new HashMap<>();
            for(int num:nums){
                Boolean flag = mapNums.get(num);
                if(flag==null)
                    mapNums.put(num, false);
                else
                    mapNums.put(num, true);
            }
            for(Map.Entry<Integer,Boolean> entry:mapNums.entrySet()){
                if (entry.getValue()){
                    response++;
                }
            }
            return response;
        }

        Set<Integer> setNums = new HashSet<>();

        for(int num:nums){
            setNums.add(num);
        }

        for(int num: setNums.toArray(new Integer[setNums.size()])){
            setNums.remove(num);
            if(setNums.contains(num-k)){
                response = response +1;
            }
            if(setNums.contains(num+k)){
                response = response +1;
            }
        }
        return response;
    }
}
