package com.company;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No532_findPairs {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> pairMap = new HashMap<>();
        for(int num : nums) {
            pairMap.put(num, pairMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);
        if(k == 0) {
            for(Map.Entry<Integer, Integer> entry : pairMap.entrySet()) {
                int temp = entry.getValue();
                if(temp > 1) {
                    result += 1;
                }
            }
        } else {
            for(int i = 0; i < nums.length ;i ++ ) {
                if(i != 0 && nums[i] == nums[i-1]) {
                    continue;
                } else {
                    if(pairMap.containsKey(nums[i] + k)) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }


    public String greatestLetter(String s) {
        return "";
    }
}
