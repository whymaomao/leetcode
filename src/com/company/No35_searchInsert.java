package com.company;

public class No35_searchInsert {
    //refer to:https://blog.csdn.net/ebowtang/article/details/50770315
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int end = nums.length - 1;
        int start = 0;
        int mid = 0;
        while(start <= end)
        {
            mid = start + (end - start)/2;
            if(nums[mid] >= target)
                end = mid - 1;
            else if(nums[mid] < target)
                start = mid + 1;

        }
        return start;
    }
}
