package com.company;

public class No27_removeElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int result = 0;
        int startIndex = 0;
        if(nums[0] != val)
        {
            startIndex = 1;
            result ++;
        }
        for(int i = 1; i < nums.length; i ++)
        {
            if(nums[i] != val)
            {
                nums[startIndex] = nums[i];
                result ++;
                startIndex ++;
            }
        }
        return result;
    }
}
