package com.yue;

public class ThreadGroupPoolTest {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int firstElement = nums[0];
        int secondElement = nums[1];
        int tempNum = 1;
        int startNum = 0;

        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[startNum]){
                tempNum += 1;
            }
        }

        return startNum + 1;

    }
}
