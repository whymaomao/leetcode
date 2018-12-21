package com.company;

public class No70_ClimbStairs {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int step1 = 1;
        int step2 = 2;
        int result = 0;
        for(int i = 2; i < n; i++)
        {
            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }
        return result;
    }
}
