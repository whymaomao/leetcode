package com.company;

public class contest2_numberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] %2 == 1)
                count ++;
        }
        if(count < k) return 0;

        return 0;
    }
}
