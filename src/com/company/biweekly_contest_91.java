package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class biweekly_contest_91 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> averageSet = new HashSet<>();
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            double temp = (nums[start] + nums[end]) / 2.0;
            //System.out.println(temp);
            averageSet.add(temp);
            start ++;
            end --;
        }
        return averageSet.size();
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int mod = (int) Math.pow(10, 9) + 7;
        dp[0] = 1;
        for(int i = 1; i <= high; i ++) {
            if(i >= zero) {
                dp[i] += dp[i-zero] % mod;
            }
            if(i>= one) {
                dp[i] += dp[i-one] % mod;
            }
        }
        int sum = 0;
        for(int j = low; j <= high; j ++) {
            sum = (sum + dp[j]) % mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("this is really a very awesome message".length());
    }
}
