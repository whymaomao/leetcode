package com.DailyCheck;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Comparator;

public class Day11_DaynamicProgramming {
    // No 70: climb stairs
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // No 746 min cost to Climb stairs
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for(int i =3 ;i <= len; i ++) {
            dp[i] = Math.min(dp[i-1] + cost[i-2], dp[i-2] + cost[i-3]);
        }
        return dp[len];
    }

    // No 62 unique Paths
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1] [j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    // No 63
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if(i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if(i == 0) {
                        dp[i][j] = dp[i][j-1];
                    } else if(j == 0) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

    // No 343 break integer
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            for(int j = i - 1; j >= 1; j --) {
                dp[i] = Math.max(dp[i], Math.max((i-j) * j, dp[i-j] * j));
            }
        }
        return dp[n];
    }

    // 1049 last stone weight
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int stone : stones) {
            for(int i = target; i >= stone; i --) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - dp[target] - dp[target];
    }

    // 494 find target sum ways
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int minusSum = (sum + target) / 2;
        if(((sum + target ) % 2) == 1 ) {
            return 0;
        }
        int[] dp = new int[minusSum + 1];
        dp[0] = 1;
        for(int num : nums) {
            for(int i = minusSum; i >= num; i --) {
                dp[i] += dp[i-num];
            }
        }
        return dp[minusSum];
    }


    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for(int i = 1; i <= amount; i ++) {
            for(int j = 0; j < coins.length; j ++) {
                if(coins[j] < i) {
                    if(dp[i-coins[j]] != Integer.MAX_VALUE && dp[coins[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i-coins[j]] + dp[coins[j]]);
                    }
                }
                if(coins[j] == i) {
                    dp[j] = 1;
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n ; i ++) {
            for(int j = 1; j*j <= i; j ++) {
                dp[i] = Math.min(dp[i - j*j] + 1, dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {

        int[][] twoDim = { {1, 2}, {3, 7}, {8, 9}, {4, 2}, {5, 3} };

        Arrays.sort(twoDim, Comparator.<int[]>comparingInt(a -> a[0])
                .reversed());

        System.out.println(Arrays.deepToString(twoDim));
    }

}
