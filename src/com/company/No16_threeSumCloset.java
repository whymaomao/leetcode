package com.company;

import java.util.Arrays;

public class No16_threeSumCloset {

    private int findClosetTarget(int[] nums, int start, int end, int current, int target)
    {
        int l = start;
        int r = end;
        int minGap = Integer.MAX_VALUE;
        int closetTarget = 0;
        while(l < r)
        {
            int tempTarget = nums[l] + nums[r] + current;
            int gap = Math.abs(tempTarget - target);
            if(gap < minGap)
            {
                minGap = gap;
                closetTarget = tempTarget;
            }

            if(tempTarget == target) return target;
            else if(tempTarget > target) r --;
            else l ++;
        }
        return closetTarget;
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minGap = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i ++)
        {
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int tempTarget = findClosetTarget(nums, i + 1, nums.length -1, nums[i], target);
            if(Math.abs(tempTarget - target) < minGap)
            {
                result = tempTarget;
                minGap = Math.abs(tempTarget - target);
                if(minGap == 0) return target;
            }
        }
        return result;
    }
}
