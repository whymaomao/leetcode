package com.dp;

public class No300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;
        for(int i = 0; i < nums.length ; i ++)
        {
            for(int j = 0; j < i; j ++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            length = Math.max(dp[i], length);
        }
        return length;
    }
}
