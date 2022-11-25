package com.DailyCheck;

public class Day12_Rob {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp0 = 0;
        int dp1 = nums[0];
        int dp = 0;
        for(int i = 1; i < nums.length; i ++) {
            dp = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1;
            dp1 = dp;
        }
        return dp;
    }


    public int robII(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp0 = 0;
        int dp1 = nums[0];
        int dpWay1 = 0;
        for(int i = 1; i < nums.length - 1; i ++) {
            dpWay1 = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1;
            dp1 = dpWay1;
        }

        dp0 = 0;
        dp1 = nums[1];
        int dpWay2 = 0;
        for(int i = 2; i < nums.length; i ++) {
            dpWay2 = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1;
            dp1 = dpWay2;
        }
        return Math.max(dpWay1, dpWay2);
    }
}
