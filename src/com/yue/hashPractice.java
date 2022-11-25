package com.yue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class hashPractice {

    /**
     * No 594
     */
    public int findLHS(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for(int num : nums) {
            if(numsMap.containsKey(num)) {
                numsMap.put(num, numsMap.get(num) + 1);
            } else {
                numsMap.put(num, 1);
            }
        }
        for(Map.Entry<Integer, Integer> mapEntry : numsMap.entrySet()) {
            int temp = mapEntry.getKey();
            if(numsMap.containsKey(temp - 1)) {
                int count = numsMap.get(temp - 1) + mapEntry.getValue();
                result = count > result ? count : result;
            }

            if(numsMap.containsKey(temp + 1)) {
                int count = numsMap.get(temp + 1) + mapEntry.getValue();
                result = count > result ? count : result;
            }
        }
        return result;
    }

    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 1));
        }

        return result;
    }
}
