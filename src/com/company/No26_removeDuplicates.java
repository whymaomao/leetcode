package com.company;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

public class No26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int startFlag = nums[0];
        int putIndex = 1;
        int result = 1;
        for(int i = 1; i < nums.length; i ++)
        {
            if(nums[i] != startFlag)
            {
                result ++;
                startFlag = nums[i];
                nums[putIndex] = nums[i];
                putIndex ++;
            }

        }
        nums = Arrays.copyOfRange(nums, 0, result);
        for(int num: nums)
            System.out.println(num);
        return result;
    }
}
