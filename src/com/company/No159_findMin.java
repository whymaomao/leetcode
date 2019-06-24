package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class No159_findMin {

    List<List<Integer>> ListResult = new ArrayList<>();

    private void findTwoSum(int[] nums, int begin, int end, int target)
    {
        int l = begin, r = end;
        while (l < r)
        {
           if(nums[l] + nums[r] + target == 0)
           {
               List<Integer> temp = new ArrayList<>();
               temp.add(target);
               temp.add(nums[l]);
               temp.add(nums[r]);
               ListResult.add(temp);
               while(l < r && nums[l] == nums[l + 1]) l ++;
               while(l < r && nums[r] == nums[r - 1]) r --;
               l ++;
               r --;
           }
           else if(nums[l] + nums[r] + target > 0)
               r --;
           else l ++;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        if(nums == null || nums.length < 3) return ListResult;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++)
        {
            if( i> 0 && nums[i] == nums[i -1]) continue;
            findTwoSum(nums,i + 1,nums.length - 1, nums[i]);
        }

        return ListResult;
    }
}
