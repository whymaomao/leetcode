package com.company;

import java.util.ArrayList;
import java.util.List;

public class No55_JumpGames {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        boolean result = true;
        int[] jumpArray = canJump(nums,end);
        for(int i = end - 1; i > 0; i --)
        {
           if(jumpArray[i] == 0) continue;
           else
           {

           }
        }
        return result;
    }

    private int[] canJump(int[] nums, int end)
    {
        List<Integer> jumpresult = new ArrayList<Integer>();
        for(int i = end - 1; i >= 0; i --)
        {
            if(nums[i] >= end - i)
            {
                jumpresult.add(i,1);
            }
            else jumpresult.add(i,0);
        }
        int []ret = new int[end - 1];
        for(int i = 0; i < jumpresult.size();i ++)
        {
            ret[i] = jumpresult.get(i);
        }
        return ret;
    }
}
