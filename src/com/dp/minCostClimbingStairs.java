package com.dp;

import java.util.Arrays;

public class minCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= len; i ++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[len];
    }

    public int minCost(int[][] costs) {
        int[] dp = new int[3];
        for(int i = 0; i < costs.length; i ++) {
            int[] dpNew = new int[3];
            for(int j = 0; j < 3; j ++) {
                if(i == 0) {
                    dp[j] = costs[0][j];
                } else {
                    dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
                }
            }
            dp = dpNew;
        }
        return Arrays.stream(dp).min().getAsInt();

    }

    public static void main(String[] args) {
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(arr));
     }
}
